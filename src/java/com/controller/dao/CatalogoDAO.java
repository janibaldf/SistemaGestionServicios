package com.controller.dao;

import com.controller.dbConection.ConnectDB;
import com.interfaces.iControllerDAO;
import com.model.dto.eCatalogo;
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

public class CatalogoDAO implements iControllerDAO<eCatalogo> {

    ConnectDB estadoBD = ConnectDB.getEstadoBD();
    Connection cnn = estadoBD.getCnn();
    private static String  SELECT_ONE = "SELECT * FROM TB_CATALOGO WHERE CODIGO = ?;";
    private static String CODIGO="CODIGO";
    private static String DESCRIPCION="DESCRIPCION";
    private static String TIPOCATALOGO="TIPO_CATALOGO";
    private static String FECHAACTUALIZACION="FECHA_ACTUALIZACION";
    private static String FECHAINGRESO="FECHA_INGRESO";
    
    @Override
    public eCatalogo selectOne(int id) {
       
        eCatalogo cat = new eCatalogo();
        try {

            try (PreparedStatement prepareStatement = cnn.prepareStatement(SELECT_ONE)) {
                prepareStatement.setInt(1, id);
                try (ResultSet rset = prepareStatement.executeQuery()) {
                    if (rset.next()) {
                        cat.setCodigo(rset.getInt(CODIGO));
                        cat.setDescripcion(rset.getString(DESCRIPCION));
                        cat.setTipoCatalogo(rset.getInt(TIPOCATALOGO));
                        Timestamp timestamp = rset.getTimestamp(FECHAACTUALIZACION);
                        Date date = new Date(timestamp.getTime());
                        cat.setFechaActualizacion(date);
                        timestamp = rset.getTimestamp(FECHAINGRESO);
                        date = new Date(timestamp.getTime());
                        cat.setFechaIngreso(date);
                    }
                    prepareStatement.close();
                    rset.close();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(RutaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cat;
    }

    @Override
    public List<eCatalogo> selectAll() {
        String SELECT_ALL = "SELECT * FROM TB_CATALOGO;";
        List<eCatalogo> lista = new ArrayList<>();
        Timestamp timestamp;
        Date date;
        try {

            try (PreparedStatement prepareStatement = cnn.prepareStatement(SELECT_ALL)) {
                try (ResultSet rset = prepareStatement.executeQuery(SELECT_ALL)) {
                    while (rset.next()) {
                        eCatalogo cat = new eCatalogo();
                        cat.setCodigo(rset.getInt(CODIGO));
                        cat.setDescripcion(rset.getString(DESCRIPCION));
                        cat.setTipoCatalogo(rset.getInt(TIPOCATALOGO));
                        timestamp = rset.getTimestamp(FECHAACTUALIZACION);
                        date = new Date(timestamp.getTime());
                        cat.setFechaActualizacion(date);
                        timestamp = rset.getTimestamp(FECHAINGRESO);
                        date = new Date(timestamp.getTime());
                        cat.setFechaIngreso(date);
                        lista.add(cat);
                    }
                    prepareStatement.close();
                    rset.close();
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(RutaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public List<eCatalogo> selectAllTipo(int id) {
        String SELECT_ALL = "SELECT * FROM TB_CATALOGO WHERE TIPO_CATALOGO = ?;";
        List<eCatalogo> lista = new ArrayList<>();
        Timestamp timestamp;
        Date date;

        try (PreparedStatement pstm = cnn.prepareStatement(SELECT_ALL)) {
            pstm.setInt(1, id);
            try (ResultSet rset = pstm.executeQuery()) {
                while (rset.next()) {
                    eCatalogo cat = new eCatalogo();
                    cat.setCodigo(rset.getInt(CODIGO));
                    cat.setDescripcion(rset.getString(DESCRIPCION));
                    cat.setTipoCatalogo(rset.getInt(TIPOCATALOGO));
                    timestamp = rset.getTimestamp(FECHAACTUALIZACION);
                    date = new Date(timestamp.getTime());
                    cat.setFechaActualizacion(date);
                    timestamp = rset.getTimestamp(FECHAINGRESO);
                    date = new Date(timestamp.getTime());
                    cat.setFechaIngreso(date);
                    lista.add(cat);
                }
                rset.close();
                pstm.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(RutaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    @Override
    public boolean add(eCatalogo element) {
        String SQL_INSERT = "INSERT INTO TB_CATALOGO (CODIGO,TIPO_CATALOGO,DESCRIPCION,FECHA_INGRESO,FECHA_ACTUALIZACION)"
                + "VALUES((SELECT MAX(CATALOGO.CODIGO)+1 FROM TB_CATALOGO CATALOGO),?,?,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);";
        try {

           try ( PreparedStatement pstm = cnn.prepareStatement(SQL_INSERT)){
            pstm.setInt(1, element.getTipoCatalogo());
            pstm.setString(2, element.getDescripcion());

            int executeUpdate = pstm.executeUpdate();
           }
        } catch (SQLException ex) {
            Logger.getLogger(RutaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(eCatalogo elemen) {
        String SQL_UPDATE = "UPDATE TB_CATALOGO SET DESCRIPCION = ?, FECHA_ACTUALIZACION = CURRENT_TIMESTAMP WHERE CODIGO=?;";
     
           try ( PreparedStatement pstm = cnn.prepareStatement(SQL_UPDATE)){
            pstm.setString(1, elemen.getDescripcion());
            pstm.setInt(2, elemen.getCodigo());
            int executeUpdate = pstm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(RutaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public boolean updateAll(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
