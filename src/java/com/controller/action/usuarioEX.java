package com.controller.action;

import com.controller.dao.UsuarioDAO;
import com.model.dto.eUsuario;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import java.util.List;

public class usuarioEX extends ActionSupport implements ModelDriven<eUsuario> {

    private eUsuario usuario = new eUsuario();
    UsuarioDAO usuariodao = new UsuarioDAO();
    private List<eUsuario> usuarios = new ArrayList<>();
    private int cusuario;
    private String password1;
    private String password2;
    String mensaje;

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public eUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(eUsuario usuario) {
        this.usuario = usuario;
    }

    public List<eUsuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<eUsuario> usurios) {
        this.usuarios = usurios;
    }

    public int getCusuario() {
        return cusuario;
    }

    public void setCusuario(int cusuario) {
        this.cusuario = cusuario;
    }

    @Override
    public eUsuario getModel() {
        return this.usuario;
    }

    public String listAll() {
        setUsuarios(usuariodao.selectAll());
        return SUCCESS;
    }

    public String editusuario() {
        this.usuario = usuariodao.selectOne(getCusuario());
        return SUCCESS;
    }

    public String saveUsuario() {
        boolean response = false;

        if (usuario.getCodigo() == 0 || usuario.getCodigo() == null) {
            if (validarUsuario()) {
                response = usuariodao.add(usuario);
            }
        } else {
            response = usuariodao.update(usuario);
        }

        if (response) {
            addActionMessage("You are valid user!");
            return SUCCESS;
        } else {
            return INPUT;

        }
    }

    private boolean validarUsuario() {
        int countError = 0;

        if (usuario.getEstado() == null || usuario.getEstado().length() == 0) {
            addActionError("Campo Estado no puede estar vacio");
            countError++;
        }
        if (usuario.getNombre() == null || usuario.getNombre().length() == 0) {
            addActionError("Campo Nombre no puede estar vacio");
            countError++;
        }
        if (usuario.getApellido() == null || usuario.getApellido().length() == 0) {
            addActionError("Campo Apellido  no puede estar vacio");
            countError++;
        }
        if (usuario.getCuenta() == null || usuario.getCuenta().length() == 0) {
            addActionError("Campo Cuenta no puede estar vacio");
            countError++;
        }
        if (usuario.getPassword() == null || usuario.getPassword().length() == 0) {
            addActionError("Campo Password no puede estar vacio");
            countError++;
        }

        if (countError > 0) {
            return false;
        } else {
            return true;
        }
    }

    public String viewUsuario() {
        setUsuario(usuariodao.selectOne(getCusuario()));
        return SUCCESS;
    }

    public String deleteUsuario() {
        usuariodao.delete(getCusuario());
        usuariodao.selectAll();
        return SUCCESS;
    }

    public String dochangepass() {
        if (this.getPassword1().equalsIgnoreCase(this.getPassword2())) {
            usuariodao.updatePassword(usuariodao.selectOne(this.getCusuario()), this.getPassword1());
        }
          return SUCCESS;
    }
    
      public String changepass() {
               setUsuario(usuariodao.selectOne(getCusuario()));
          return SUCCESS;
    }
}
