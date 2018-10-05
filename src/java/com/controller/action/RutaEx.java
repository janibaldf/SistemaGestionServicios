package com.controller.action;

import com.controller.dao.RutaDAO;
import com.model.dto.eRuta;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.List;

public class RutaEx extends ActionSupport implements ModelDriven<eRuta> {

    private eRuta ruta = new eRuta();
    RutaDAO rutadao = new RutaDAO();
    private List<eRuta> rutas;
    private int rcodigo;
    String mensajeError;

    public int getRcodigo() {
        return rcodigo;
    }

    public void setRcodigo(int rcodigo) {
        this.rcodigo = rcodigo;
    }

    public eRuta getRuta() {
        return ruta;
    }

    public void setRuta(eRuta ruta) {
        this.ruta = ruta;
    }

    public List<eRuta> getRutas() {
        return this.rutas;
    }

    public void setRutas(List<eRuta> r) {
        this.rutas = r;
    }

    public String listAll() {
        setRutas(rutadao.selectAll());
        return SUCCESS;
    }

    public String editRuta() {
        this.ruta = rutadao.selectOne(getRcodigo());

        return SUCCESS;
    }

    public String saveRuta() {
        boolean response = false;

        if (ruta.getCodigo() == 0 || ruta.getCodigo() == null) {
            if (validarRuta()) {
                response = rutadao.add(ruta);
            }
        } else {
            response = rutadao.update(ruta);
        }

        if (response) {
            addActionMessage("You are valid user!");
            return SUCCESS;
        } else {
            return INPUT;

        }
    }

    private boolean validarRuta() {
        int countError = 0;

        if (ruta.getEstado() == null || ruta.getEstado().length() == 0) {
            addActionError("Campo Estado no puede estar vacio");
            countError++;
        }
        if (ruta.getPlaca() == null || ruta.getPlaca().length() == 0) {
            addActionError("Campo Placa no puede estar vacio");
            countError++;
        }
        if (ruta.getAutorizacion() == null || ruta.getAutorizacion().length() == 0) {
            addActionError("Campo Numero de autorizacion no puede estar vacio");
            countError++;
        }
        if (countError > 0) {
            return false;
        } else {
            return true;
        }

    }

    public String viewRuta() {
      setRuta( rutadao.selectOne(getRcodigo()));

        return SUCCESS;
    }
    public String deleteRuta(){
        rutadao.delete(getRcodigo());
        rutadao.selectAll();
      return SUCCESS;  
    }
    
    @Override
    public eRuta getModel() {
        return this.ruta;
    }

}
