
package com.controller.action;

import com.controller.dao.CatalogoDAO;
import com.controller.dao.ClienteDAO;
import com.controller.dao.CuentaClienteDAO;
import com.model.dto.eCatalogo;
import com.model.dto.eCliente;
import com.model.dto.eCuentaCliente;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.math.BigDecimal;
import java.text.DecimalFormat;
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
    private String monto;
    private int cTipoTransaccion2; 
    private eCliente cliente = new eCliente();

    public String listaPagos() {
        setPagos(pagodao.selectAll());
        return SUCCESS;
    }
    public eCliente getCliente() {
        return cliente;
    }

    public void setCliente(eCliente cliente) {
        this.cliente = cliente;
    }
    
    public int getcTipoTransaccion2() {
        return cTipoTransaccion2;
    }

    public void setcTipoTransaccion2(int cTipoTransaccion2) {
        this.cTipoTransaccion2 = cTipoTransaccion2;
    }
    

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
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
        pago.setMontoPago(Double.valueOf(this.getMonto()));
        pago.setcTipoTransaccion(this.getcTipoTransaccion2());
         pago.setSaldoAnterior(cliente.getSaldo());
        pago.setNuevoSaldo(cliente.getSaldo()-Double.parseDouble(this.getMonto()));
        clientedao.updateSaldo(this.getcCliente(), cliente.getSaldo()-Double.parseDouble(this.getMonto()));
        pagodao.add(pago);
        getInicial();
        addActionMessage("Ingreso Satisfactorio");
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
