
package com.model.dto;

import java.util.Date;


public class ePermiso {
private Date fechaIngreso;
private Date fechaActualizacion;
private eRuta ruta;
private eRol rol;
private eUsuario usuario;
private int codigoRuta;
private int codigoRol;
private int codigoUsuario;

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

    public eRuta getRuta() {
        return ruta;
    }

    public void setRuta(eRuta ruta) {
        this.ruta = ruta;
    }

    public eRol getRol() {
        return rol;
    }

    public void setRol(eRol rol) {
        this.rol = rol;
    }

    public eUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(eUsuario usuario) {
        this.usuario = usuario;
    }

    public int getCodigoRuta() {
        return codigoRuta;
    }

    public void setCodigoRuta(int codigoRuta) {
        this.codigoRuta = codigoRuta;
    }

    public int getCodigoRol() {
        return codigoRol;
    }

    public void setCodigoRol(int codigoRol) {
        this.codigoRol = codigoRol;
    }

    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }



    
}
