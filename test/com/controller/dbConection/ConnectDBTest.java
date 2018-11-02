/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller.dbConection;

import com.controller.dao.RutaDAO;
import com.model.dto.eCatalogo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ConnectDBTest {
    
    public ConnectDBTest() {
    }

    /**
     * Test of getEstadoBD method, of class ConnectDB.
     */
    
    ConnectDB estadoBD = ConnectDB.getEstadoBD();
    Connection cnn = estadoBD.getCnn();
    @Test
    public void testGetEstadoBD() {
        System.out.println("getEstadoBD");
        ConnectDB expResult = null;
        ConnectDB result = ConnectDB.getEstadoBD();
         assertNotNull(result);
    }

        @Test
    public void testLecturaDB() {
        System.out.println("testLecturaDB");
        ConnectDB expResult = null;
        ConnectDB result = ConnectDB.getEstadoBD();
        eCatalogo cat = new eCatalogo();
        try {

            try (PreparedStatement prepareStatement = cnn.prepareStatement("SELECT * FROM TB_USUARIO")){
                try (ResultSet rset = prepareStatement.executeQuery()) {
                       System.out.println("ENTRO");
                    if (rset.next()) {
                        System.out.println(rset.getInt("CODIGO"));
                          System.out.println("NO ENTRO");
                       assertNotNull(result); 
                       assertNotEquals(rset.getRow(),0);
                    }
                    prepareStatement.close();
                    rset.close();
                }
            }

        } catch (SQLException ex) {
            
        }

         
    }

    
}
