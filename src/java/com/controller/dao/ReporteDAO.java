
package com.controller.dao;

import com.controller.dbConection.ConnectDB;
import java.sql.Connection;


public class ReporteDAO {
    private ConnectDB estadoBD = ConnectDB.getEstadoBD();
    private Connection cnn = estadoBD.getCnn();
}
