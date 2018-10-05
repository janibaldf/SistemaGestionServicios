
package com.model.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


public class eCliente {

    private static final long serialVersionUID = 1L; 
    private int codigo=0;
    private int ordenServicio;
    private String nombre;
    private String telefono;
    private String nit;
    private String comprobante;
    private String zona;
    private String colonia;
    private String avenida;
    private String calle;
    private String numeroCasa;
    private String apartamento;
    private String direccionImpresion;
    private String referencia;
    private String motivoEstado;
    private String comentario;
    private Double  costoServicio;
    private Double saldo;
    private Date fechaIngreso;
    private Date fechaActualizacion;
    private List<eCuentaCliente> eCuentaClienteList;
    private eCatalogo codigoEstado;
    private eRuta codigoRuta;
    private eCatalogo tipoPago; 
    private eCatalogo tipoServicio;
    private int cRuta;
    private int cTipoPago;
    private int cTipoServicio;
    private int cEstado;
    private int diaPago=0;

    public int getDiaPago() {
        return diaPago;
    }

    public void setDiaPago(int diaPago) {
        this.diaPago = diaPago;
    }

    public int getcEstado() {
        return cEstado;
    }

    public void setcEstado(int cEstado) {
        this.cEstado = cEstado;
    }

    public int getcRuta() {
        return cRuta;
    }

    public void setcRuta(int cRuta) {

        this.cRuta = cRuta;
    }

    public int getcTipoPago() {
        return cTipoPago;
    }

    public void setcTipoPago(int cTipoPago) {
        this.cTipoPago = cTipoPago;
    }

    public int getcTipoServicio() {
        return cTipoServicio;
    }

    public void setcTipoServicio(int cTipoServicio) {
        this.cTipoServicio = cTipoServicio;
    }
    
    public eCliente() {
    }

    public eCliente(Integer codigo) {
        this.codigo = codigo;
    }

    public eCliente(Integer codigo, String direccionImpresion, String referencia, Double costoServicio, Date fechaIngreso, Date fechaActualizacion) {
        this.codigo = codigo;
        this.direccionImpresion = direccionImpresion;
        this.referencia = referencia;
        this.costoServicio = costoServicio;
        this.fechaIngreso = fechaIngreso;
        this.fechaActualizacion = fechaActualizacion;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getOrdenServicio() {
        return ordenServicio;
    }

    public void setOrdenServicio(Integer ordenServicio) {
        this.ordenServicio = ordenServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getComprobante() {
        return comprobante;
    }

    public void setComprobante(String comprobante) {
        this.comprobante = comprobante;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getAvenida() {
        return avenida;
    }

    public void setAvenida(String avenida) {
        this.avenida = avenida;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(String numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getApartamento() {
        return apartamento;
    }

    public void setApartamento(String apartamento) {
        this.apartamento = apartamento;
    }

    public String getDireccionImpresion() {
        return direccionImpresion;
    }

    public void setDireccionImpresion(String direccionImpresion) {
        this.direccionImpresion = direccionImpresion;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getMotivoEstado() {
        return motivoEstado;
    }

    public void setMotivoEstado(String motivoEstado) {
        this.motivoEstado = motivoEstado;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Double getCostoServicio() {
        return costoServicio;
    }

    public void setCostoServicio(Double costoServicio) {
        this.costoServicio = costoServicio;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
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


    public List<eCuentaCliente> geteCuentaClienteList() {
        return eCuentaClienteList;
    }

    public void seteCuentaClienteList(List<eCuentaCliente> eCuentaClienteList) {
        this.eCuentaClienteList = eCuentaClienteList;
    }

    public eCatalogo getCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(eCatalogo codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    public eRuta getCodigoRuta() {
        return codigoRuta;
    }

    public void setCodigoRuta(eRuta codigoRuta) {
        this.codigoRuta = codigoRuta;
    }

    public eCatalogo getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(eCatalogo tipoPago) {
        this.tipoPago = tipoPago;
    }

    public eCatalogo getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(eCatalogo tipoServicio) {
        this.tipoServicio = tipoServicio;
    }




  

    @Override
    public String toString() {
        return "a.TbCliente[ codigo=" + codigo + " ]";
    }


}
