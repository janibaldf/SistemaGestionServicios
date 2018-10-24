
package com.controller.action;

import com.controller.dao.CatalogoDAO;
import com.controller.dao.ClienteDAO;
import com.controller.dao.CuentaClienteDAO;
import com.model.dto.eCatalogo;
import com.model.dto.eCliente;
import com.model.dto.eCuentaCliente;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.List;


public class CuentaClienteEX extends ActionSupport implements ModelDriven<eCuentaCliente>  {

    private List<eCliente> clientes;
    private List<eCatalogo> transacciones;
    private List<eCuentaCliente> pagos;
    private ClienteDAO clientedao = new ClienteDAO();
    private CatalogoDAO tipoTransaccion = new CatalogoDAO();
    private eCuentaCliente  pago= new eCuentaCliente();
    private CuentaClienteDAO pagodao= new CuentaClienteDAO();
    private int cCliente; 
    private int cMes;
    private double monto;
    private int cTipoTransaccion; 

    public int getcTipoTransaccion() {
        return cTipoTransaccion;
    }

    public void setcTipoTransaccion(int cTipoTransaccion) {
        this.cTipoTransaccion = cTipoTransaccion;
    }
    

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getcCliente() {
        return cCliente;
    }

    public void setcCliente(int cCliente) {
        this.cCliente = cCliente;
    }

    public int getcMes() {
        return cMes;
    }

    public void setcMes(int cMes) {
        this.cMes = cMes;
    }
    
    public String savePago(){
        eCliente cliente = new eCliente();
        cliente=clientedao.selectOne(getcCliente());
        pago.setCcliente(cliente.getCodigo());
        pago.setCostoServicio(cliente.getCostoServicio());
        pago.setMes(String.valueOf(getcMes()));
        pago.setMontoPago(getMonto());
        pago.setcTipoTransaccion(getcTipoTransaccion());
        
        pago.setNuevoSaldo(cliente.getSaldo()-getMonto());
        pago.setSaldoAnterior(cliente.getSaldo());
       
        //pago.setTipoTransaccion(getcTipoTransaccion());
        pagodao.add(pago);
        
        return SUCCESS;
    }
    public List<eCliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<eCliente> clientes) {
        this.clientes = clientes;
    }

    public List<eCatalogo> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(List<eCatalogo> transacciones) {
        this.transacciones = transacciones;
    }

    public List<eCuentaCliente> getPagos() {
        return pagos;
    }

    public void setPagos(List<eCuentaCliente> pagos) {
        this.pagos = pagos;
    }

    public ClienteDAO getClientedao() {
        return clientedao;
    }

    public void setClientedao(ClienteDAO clientedao) {
        this.clientedao = clientedao;
    }

    public CatalogoDAO getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(CatalogoDAO tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public eCuentaCliente getPago() {
        return pago;
    }

    public void setPago(eCuentaCliente pago) {
        this.pago = pago;
    }
    
   public String getInicial() {
       setClientes( clientedao.selectAll());
       setTransacciones( tipoTransaccion.selectAllTipo(5));
    return SUCCESS;
   }
    @Override
    public eCuentaCliente getModel() {
       return this.pago;
    }

}
