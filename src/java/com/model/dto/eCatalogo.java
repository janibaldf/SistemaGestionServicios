package com.model.dto;

import java.util.Date;

public class eCatalogo {

    private static final long serialVersionUID = 1L;

    private Integer codigo = 0;

    private String descripcion;

    private Date fechaIngreso;

    private Date fechaActualizacion;

    private int tipoCatalogo;

    public eCatalogo() {
    }

    public eCatalogo(Integer codigo) {
        this.codigo = codigo;
    }

    public eCatalogo(Integer codigo, String descripcion, Date fechaIngreso, Date fechaActualizacion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.fechaIngreso = fechaIngreso;
        this.fechaActualizacion = fechaActualizacion;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public int getTipoCatalogo() {
        return tipoCatalogo;
    }

    public void setTipoCatalogo(int tipoCatalogo) {
        this.tipoCatalogo = tipoCatalogo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof eCatalogo)) {
            return false;
        }
        eCatalogo other = (eCatalogo) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.dto.TbCatalogo[ codigo=" + codigo + " ]";
    }

}
