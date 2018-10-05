
package com.model.dto;

import java.math.BigDecimal;
import java.util.Date;


public class eCuentaCliente {


    private int codigoCuentaCliente;
    private Double costoServicio;
    private Double montoPago;
    private Double saldoAnterior;
    private Double nuevoSaldo;
    private String mes;
    private Date fechaIngreso;
    private Date fechaActualizacion;
    private eCliente cliente;
    private eCatalogo tipoTransaccion;
    private int ccliente;
     private int cTipoTransaccion;

    public int getcTipoTransaccion() {
        return cTipoTransaccion;
    }

    public void setcTipoTransaccion(int cTipoTransaccion) {
        this.cTipoTransaccion = cTipoTransaccion;
    }
     
     
    public eCuentaCliente() {
    }

    public int getCodigoCuentaCliente() {
        return codigoCuentaCliente;
    }

    public void setCodigoCuentaCliente(int codigoCuentaCliente) {
        this.codigoCuentaCliente = codigoCuentaCliente;
    }

    public Double getCostoServicio() {
        return costoServicio;
    }

    public void setCostoServicio(Double costoServicio) {
        this.costoServicio = costoServicio;
    }

    public Double getMontoPago() {
        return montoPago;
    }

    public void setMontoPago(Double montoPago) {
        this.montoPago = montoPago;
    }

    public Double getSaldoAnterior() {
        return saldoAnterior;
    }

    public void setSaldoAnterior(Double saldoAnterior) {
        this.saldoAnterior = saldoAnterior;
    }

    public Double getNuevoSaldo() {
        return nuevoSaldo;
    }

    public void setNuevoSaldo(Double nuevoSaldo) {
        this.nuevoSaldo = nuevoSaldo;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public eCliente getCliente() {
        return cliente;
    }

    public void setCliente(eCliente cliente) {
        this.cliente = cliente;
    }

    public eCatalogo getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(eCatalogo tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public int getCcliente() {
        return ccliente;
    }

    public void setCcliente(int ccliente) {
        this.ccliente = ccliente;
    }


    
    @Override
    public String toString() {
        return "a.TbCuentaCliente[ codigoCuentaCliente=" + codigoCuentaCliente + " ]";
    }

}
