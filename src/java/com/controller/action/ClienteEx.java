package com.controller.action;

import com.controller.dao.CatalogoDAO;
import com.controller.dao.ClienteDAO;
import com.controller.dao.RutaDAO;
import com.model.dto.eCatalogo;
import com.model.dto.eCliente;
import com.model.dto.eRuta;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.inject.Container;
import java.math.BigDecimal;
import java.util.List;

public class ClienteEx extends ActionSupport implements ModelDriven<eCliente> {

    private eCliente cliente = new eCliente();
    ClienteDAO clientedao = new ClienteDAO();
    RutaDAO rutadao = new RutaDAO();
    CatalogoDAO catalogodao = new CatalogoDAO();
     
    private List<eCliente> clientes;
    private int ccliente;
    String mensajeError;

    private List<eCatalogo> tipoEstados;
    private List<eCatalogo> tipoPagos;
    private List<eCatalogo> tipoServicios;

    public List<eCatalogo> getTipoEstados() {
        return tipoEstados;
    }

    public void setTipoEstados(List<eCatalogo> tipoEstados) {
        this.tipoEstados = tipoEstados;
    }

    public List <eCatalogo> getTipoPagos() {
        return tipoPagos;
    }

    public void setTipoPagos(List<eCatalogo>  tipoPagos) {
        this.tipoPagos = tipoPagos;
    }

    public List<eCatalogo> getTipoServicios() {
        return tipoServicios;
    }

    public void setTipoServicios(List<eCatalogo>  tipoServicios) {
        this.tipoServicios = tipoServicios;
    }

    @Override
    public Container getContainer() {
        return container;
    }

    @Override
    public void setContainer(Container container) {
        this.container = container;
    }
    
    
    
    
    
    
    
    
    
    
    public List<eRuta> getRutas() {
        return rutas;
    }

    public void setRutas(List<eRuta> rutas) {
        this.rutas = rutas;
    }
    
    private List<eRuta> rutas;
    
        
    public eCliente getCliente() {
        return cliente;
    }

    public void setCliente(eCliente cliente) {
        this.cliente = cliente;
    }

    public ClienteDAO getClientedao() {
        return clientedao;
    }

    public void setClientedao(ClienteDAO clientedao) {
        this.clientedao = clientedao;
    }

    public List<eCliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<eCliente> clientes) {
        this.clientes = clientes;
    }

    public int getCcliente() {
        return ccliente;
    }

    public void setCcliente(int ccliente) {
        this.ccliente = ccliente;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    @Override
    public eCliente getModel() {
        return this.cliente;
    }

    public String listAllCliente() {
        setClientes(clientedao.selectAll());
        return SUCCESS;
    }

    public String editCliente() {
        IniciarCliente();
        setCliente(clientedao.selectOne(getCcliente()));
        return SUCCESS;
    }

    public String saveCliente() {
        boolean response = false;

        if (cliente.getCodigo() == 0 || cliente.getCodigo() == null) {
            if (validarCliente()) {
                response = clientedao.add(cliente);
            }
        } else {
            response = clientedao.update(cliente);
        }

        if (response) {
            addActionMessage("Exito!");
            return SUCCESS;
        } else {
            return INPUT;

        }
    }

    private boolean validarCliente() {
        int countError = 0;

        if (cliente.getDireccionImpresion() == null || cliente.getDireccionImpresion().length() == 0) {
            addActionError("Direccion no puede ser vacia");
            countError++;
        }
        if (cliente.getCostoServicio() == null) {
            addActionError("Costo Servicio n no puede estar vacio");
            countError++;
        }
        if (countError > 0) {
            return false;
        } else {
            return true;
        }

    }

    public String viewCliente() {
        setCliente(clientedao.selectOne(getCcliente()));

        return SUCCESS;
    }

    public String deleteCliente() {
        clientedao.delete(getCcliente());
        clientedao.selectAll();
        return SUCCESS;
    }
    
    
    
   public String IniciarCliente(){
       setRutas(rutadao.selectAll());
      setTipoEstados(catalogodao.selectAllTipo(3));
      setTipoServicios(catalogodao.selectAllTipo(1));
       setTipoPagos(catalogodao.selectAllTipo(6));
       return SUCCESS;
   } 
}
