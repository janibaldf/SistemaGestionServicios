package com.controller.dbConection;

import com.model.dto.ConfigBean;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.util.LoadConfig;

public class ConnectDB {

    private static ConnectDB instance;
    private Connection cnn;

    private ConnectDB() {
        try {
            LoadConfig param = LoadConfig.getInstance();
            ConfigBean config = param.getConfiguration();

            Class.forName("com.mysql.jdbc.Driver");

          //  Logger.getLogger("logger" + config.getDBURL() + "+" + config.getDBUser() + "+" + config.getDBPassword());
            cnn = DriverManager.getConnection(config.getDBURL(), config.getDBUser(), config.getDBPassword());

        } catch (Exception ex) {
          //  Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
          System.out.println(ex);
        }
    }

    public static synchronized ConnectDB getEstadoBD() {
        if (instance == null) {
            instance = new ConnectDB();
        }
        return instance;

    }

    public Connection getCnn() {
        return cnn;
    }

    public static void closeConexion() {
        instance = null;
    }

}
