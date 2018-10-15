package com.controller.action;

import com.controller.dao.UsuarioDAO;
import com.model.dto.eUsuario;
    import java.util.Map ;
    import javax.servlet.http.HttpSession ;
    import org.apache.struts2.ServletActionContext ;
    import org.apache.struts2.dispatcher.SessionMap ;
    import org.apache.struts2.interceptor.SessionAware ;
    import com.opensymphony.xwork2.ActionSupport ;

public class loginAction  extends ActionSupport implements SessionAware {
  private String IDuser = "userId";
        private static final long serialVersionUID = -3434561352924343132L;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public SessionMap<String, Object> getSessionMap() {
        return sessionMap;
    }

    public void setSessionMap(SessionMap<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

        
        private String userId, userPass, msg;
      
        private SessionMap<String, Object> sessionMap;

        @Override
        public void setSession(Map<String, Object> map) {
            sessionMap = (SessionMap<String, Object>) map;
        }

        @Override
        public String execute() {
            HttpSession session = ServletActionContext.getRequest().getSession(true);
            UsuarioDAO usuariodao=new UsuarioDAO();
            if (userId != null) {
                int validateLogin = usuariodao.validateLogin(userId, userPass);
                if (validateLogin>=0) {
                    eUsuario usuario = usuariodao.selectOne(validateLogin);
                    sessionMap.put(IDuser, usuario.getCuenta());
                    sessionMap.put("userNombre", usuario.getNombre());

                    return "SUCCESS";
                } else {
                    
                         addActionError("Usuario/Contraseña invalidos");
                    return "LOGIN";
                }
            } else {
                String getSessionAttr = (String) session.getAttribute(IDuser);
                if (getSessionAttr != null) {
                    return "SUCCESS";
                } else {
                    return "LOGIN";
                }
            }
        }

        public String logout() {
            sessionMap.remove(IDuser);
            sessionMap.invalidate();
            return "LOGOUT";
        }
    }
