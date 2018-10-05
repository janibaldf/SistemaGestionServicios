
package com.controller.action;

import com.controller.dao.CatalogoDAO;
import com.model.dto.eCatalogo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.List;


public class catalogoEX extends ActionSupport implements ModelDriven<eCatalogo> {
private eCatalogo catalogo= new eCatalogo(); ;
private CatalogoDAO catalogodao= new CatalogoDAO() ;
private int tcatalogo;
    private List<eCatalogo> catalogos;

    public List<eCatalogo> getCatalogos() {
        return catalogos;
    }

    public void setCatalogos(List<eCatalogo> catalogos) {
        this.catalogos = catalogos;
    }

    public eCatalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(eCatalogo catalogo) {
        this.catalogo = catalogo;
    }

    public CatalogoDAO getCatalogodao() {
        return catalogodao;
    }

    public void setCatalogodao(CatalogoDAO catalogodao) {
        this.catalogodao = catalogodao;
    }

    public int getTcatalogo() {
        return tcatalogo;
    }

    public void setTcatalogo(int tcatalogo) {
        this.tcatalogo = tcatalogo;
    }

 
    
    
    public String listAllTC() {
        setCatalogos( catalogodao.selectAllTipo(getTcatalogo()) );
        return SUCCESS;
    }
    
    
    @Override
    public eCatalogo getModel() {
        return this.catalogo;
    }
    
    private boolean validar() {
        int countError = 0;

        
        if (catalogo.getDescripcion() == null || catalogo.getDescripcion().length() == 0) {
            addActionError("Campo Descripcion no puede estar vacio");
            countError++;
        }
        if (countError > 0) {
            return false;
        } else {
            return true;
        }
    }
    
     public String saveCatalogo() {
        boolean response = false;

        if (catalogo.getCodigo() == 0 || catalogo.getCodigo() == null) {
            if (validar()) {
       
                response = catalogodao.add(catalogo);
                
            }
        } else {
            response = catalogodao.update(catalogo);
        }

        if (response) {
            addActionMessage("Ingreso Satisfactorio!");
            return SUCCESS;
        } else {
            return INPUT;

        }
     }
     
      public String editRuta() {
        this.catalogo = catalogodao.selectOne(getTcatalogo());

        return SUCCESS;
    }

}
