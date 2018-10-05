package com.controller.dao;

import com.controller.dbConection.ConnectDB;
import com.interfaces.iControllerDAO;
import com.model.dto.eRol;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RolDAO implements iControllerDAO<eRol> {


    private static String SELECT_ALL = "SELECT * FROM TB_ROL;";

    ConnectDB estadoBD = ConnectDB.getEstadoBD();
    Connection cnn = estadoBD.getCnn();

    @Override
    public eRol selectOne(int id) {
        eRol rol = new eRol();
        Date date;
        Timestamp timestamp;
            String SELECT_ONE = "SELECT * FROM TB_ROL WHERE CODIGO = ?;";
        try (PreparedStatement pstm = cnn.prepareStatement(SELECT_ONE)) {
            pstm.setInt(1, id);
            
            try (ResultSet rset = pstm.executeQuery()) {
                if (rset.next()){
                rol.setCodigo(rset.getInt("CODIGO"));
                rol.setNombre(rset.getString("NOMBRE"));
                timestamp = rset.getTimestamp("FECHA_ACTUALIZACION");
                date = new Date(timestamp.getTime());
                rol.setFechaActualizacion(date);
                timestamp = rset.getTimestamp("FECHA_INGRESO");
                date = new Date(timestamp.getTime());
                rol.setFechaIngreso(date);
            }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rol;
    }

    @Override
    public List<eRol> selectAll() {
        List<eRol> roles = new ArrayList<>();
        Date date;
        Timestamp timestamp;
        try (PreparedStatement pstm = cnn.prepareStatement(SELECT_ALL)) {
            try (ResultSet rset = pstm.executeQuery()) {
                while (rset.next()) {
                    eRol rol = new eRol();
                    rol.setCodigo(rset.getInt("CODIGO"));
                    rol.setNombre(rset.getString("NOMBRE"));
                    timestamp = rset.getTimestamp("FECHA_ACTUALIZACION");
                    date = new Date(timestamp.getTime());
                    rol.setFechaActualizacion(date);
                    timestamp = rset.getTimestamp("FECHA_INGRESO");
                    date = new Date(timestamp.getTime());
                    rol.setFechaIngreso(date);
                    roles.add(rol);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return roles;
    }

    @Override
    public boolean add(eRol element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(eRol elemen
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateAll(int id
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
