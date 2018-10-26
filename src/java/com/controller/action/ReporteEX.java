
package com.controller.action;

import com.controller.dao.ReporteDAO;
import com.controller.dbConection.ConnectDB;
import com.model.dto.eCatalogo;
import com.model.dto.eCliente;
import com.model.dto.eCuentaCliente;
import com.model.dto.eRuta;
import java.sql.Connection;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ReporteEX {
    ReporteDAO reportedao = new ReporteDAO();
    eCliente cliente= new eCliente();
    eRuta ruta = new eRuta();
    eCuentaCliente cuenta= new eCuentaCliente();
    eCatalogo tipoCuenta= new eCatalogo();
    
    public void getReporteTodosRecibos(){

}
    
}
