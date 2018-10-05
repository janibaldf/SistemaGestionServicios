package com.controller.action;

import com.controller.dao.PermisoDAO;
import com.controller.dao.RolDAO;
import com.controller.dao.RutaDAO;
import com.controller.dao.UsuarioDAO;
import com.model.dto.ePermiso;
import com.model.dto.eRol;
import com.model.dto.eRuta;
import com.model.dto.eUsuario;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.List;

public class PermisoEx extends ActionSupport implements ModelDriven<ePermiso> {

    private ePermiso permiso = new ePermiso();
    private List<eUsuario> usuarios1;
    private List<ePermiso> permisos;
    private List<eRol> roles1;
     private List<eRuta> rutas1;
    private PermisoDAO permisodao = new PermisoDAO();
    private RutaDAO rutadao = new RutaDAO();
    private UsuarioDAO usuariodao = new UsuarioDAO();
    private RolDAO roldao = new RolDAO();
    private int cUsuario;
    private int cRol;
    private int cRuta;
    
    
    public List<ePermiso> getPermisos() {
        return permisos;
    }

    public void setPermisos(List<ePermiso> permisos) {
        this.permisos = permisos;
    }
    
  

    public int getcRuta() {
        return cRuta;
    }

    public void setcRuta(int cRuta) {
        this.cRuta = cRuta;
    }

    public int getcUsuario() {
        return cUsuario;
    }

    public void setcUsuario(int cUsuario) {
        this.cUsuario = cUsuario;
    }

    public int getcRol() {
        return cRol;
    }

    public void setcRol(int cRol) {
        this.cRol = cRol;
    }

    public ePermiso getPermiso() {
        return permiso;
    }

    public void setPermiso(ePermiso permiso) {
        this.permiso = permiso;
    }

    public List<eUsuario> getUsuarios() {
        return usuarios1;
    }

    public void setUsuarios(List<eUsuario> usuarios) {
        this.usuarios1 = usuarios;
    }

    public List<eRol> getRoles() {
        return roles1;
    }

    public void setRoles(List<eRol> roles) {
        this.roles1 = roles;
    }

    public List<eRuta> getRutas() {
        return rutas1;
    }

    public void setRutas(List<eRuta> rutas) {
        this.rutas1 = rutas;
    }

    public String getInicial() {
        setRoles(roldao.selectAll());
        setRutas(rutadao.selectAll());
        setUsuarios(usuariodao.selectAll());
        return SUCCESS;
    }

    @Override
    public ePermiso getModel() {
        return this.permiso;
    }

    public String savePermisos() {
        permiso.setCodigoRol(getcRol());
        permiso.setCodigoRuta(getcRuta());
        permiso.setCodigoUsuario(getcUsuario());

        permisodao.add(permiso);
        getInicial();
        addActionMessage("Ingreso Satisfactorio");
        
        return SUCCESS;
    }

    public String listaPermisos() {
        setPermisos(permisodao.selectAll());
        return SUCCESS;
    }
    
    
    public String eliminar(){
        permisodao.deletePermiso(getcUsuario(), getcRol(), getcRuta());
        listaPermisos();
        return SUCCESS;
    }
}
