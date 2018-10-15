
package com.controller.action;

import com.controller.dao.CuentaClienteDAO;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


public class CuentaClienteEX extends ActionSupport implements ModelDriven<CuentaClienteDAO>  {

    @Override
    public CuentaClienteDAO getModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
