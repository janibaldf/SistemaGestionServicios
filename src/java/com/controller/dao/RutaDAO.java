package com.controller.dao;

import com.controller.dbConection.ConnectDB;
import com.interfaces.iControllerDAO;
import com.model.dto.eRuta;

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

public class RutaDAO implements iControllerDAO<eRuta> {

    ConnectDB estadoBD = ConnectDB.getEstadoBD();
    Connection cnn = estadoBD.getCnn();

    @Override
    public eRuta selectOne(int id) {
        String SELECT_ONE = "SELECT * FROM TB_RUTA WHERE CODIGO = ?;";
        eRuta ruta = new eRuta();

        try (PreparedStatement prepareStatement = cnn.prepareStatement(SELECT_ONE)) {
            prepareStatement.setInt(1, id);
            try (ResultSet rset = prepareStatement.executeQuery()) {
                if (rset.next()) {
                    ruta.setCodigo(rset.getInt("CODIGO"));
                    ruta.setPlaca(rset.getString("PLACA"));
                    ruta.setDescripcion(rset.getString("DESCRIPCION"));
                    ruta.setCorreo(rset.getString("CORREO"));
                    ruta.setComentario(rset.getString("COMENTARIO"));
                    ruta.setAutorizacion(rset.getString("AUTORIZACION"));
                    ruta.setTelefono(rset.getString("TELEFONO"));
                    ruta.setFirma(rset.getString("FIRMA"));
                    ruta.setEstado(rset.getString("ESTADO"));
                    Timestamp timestamp = rset.getTimestamp("FECHA_ACTUALIZACION");
                    Date date = new Date(timestamp.getTime());
                    ruta.setFechaActualizacion(date);
                    timestamp = rset.getTimestamp("FECHA_INGRESO");
                    date = new Date(timestamp.getTime());
                    ruta.setFechaIngreso(date);
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(RutaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ruta;
    }

    @Override
    public List<eRuta> selectAll() {
        String SELECT_ALL = "SELECT * FROM TB_RUTA WHERE ESTADO <>-1;";
        List<eRuta> rutas = new ArrayList<>();
        Timestamp timestamp;
        Date date;

        try (PreparedStatement prepareStatement = cnn.prepareStatement(SELECT_ALL)) {
            try (ResultSet rset = prepareStatement.executeQuery(SELECT_ALL)) {
                while (rset.next()) {
                    eRuta ruta = new eRuta();
                    ruta.setCodigo(rset.getInt("CODIGO"));
                    ruta.setPlaca(rset.getString("PLACA"));
                    ruta.setDescripcion(rset.getString("DESCRIPCION"));
                    ruta.setCorreo(rset.getString("CORREO"));
                    ruta.setComentario(rset.getString("COMENTARIO"));
                    ruta.setAutorizacion(rset.getString("AUTORIZACION"));
                    ruta.setTelefono(rset.getString("TELEFONO"));
                    ruta.setFirma(rset.getString("FIRMA"));
                    ruta.setEstado(rset.getString("ESTADO"));
                    timestamp = rset.getTimestamp("FECHA_ACTUALIZACION");
                    date = new Date(timestamp.getTime());
                    ruta.setFechaActualizacion(date);
                    timestamp = rset.getTimestamp("FECHA_INGRESO");
                    date = new Date(timestamp.getTime());
                    ruta.setFechaIngreso(date);
                    rutas.add(ruta);
                }
                      rset.close();
            }
      ;
        } catch (SQLException ex) {
            Logger.getLogger(RutaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rutas;
    }

    @Override
    public boolean add(eRuta ruta) {
        String SQL_INSERT = "INSERT INTO TB_RUTA (CODIGO,PLACA,DESCRIPCION,CORREO,TELEFONO,COMENTARIO,AUTORIZACION,FIRMA,ESTADO,FECHA_INGRESO,FECHA_ACTUALIZACION)"
                + "VALUES((SELECT MAX(RUTA.CODIGO)+1 FROM TB_RUTA RUTA),?,?,?,?,?,?,?,?,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);";

            try (PreparedStatement pstm = cnn.prepareStatement(SQL_INSERT)) {
                pstm.setString(1, ruta.getPlaca());
                pstm.setString(2, ruta.getDescripcion());
                pstm.setString(3, ruta.getCorreo());
                pstm.setString(4, ruta.getTelefono());
                pstm.setString(5, ruta.getComentario());
                pstm.setString(6, ruta.getAutorizacion());
                pstm.setString(7, "fima");
                pstm.setString(8, ruta.getEstado());
                int executeUpdate = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RutaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public boolean delete(int rcodigo) {
        String SQL_UPDATE_ESTADO = "UPDATE TB_RUTA SET  ESTADO = -1, FECHA_ACTUALIZACION = CURRENT_TIMESTAMP WHERE CODIGO=?;";
        
           try ( PreparedStatement pstm = cnn.prepareStatement(SQL_UPDATE_ESTADO)){
            pstm.setInt(1, rcodigo);
            int executeUpdate = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RutaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }

    @Override
    public boolean update(eRuta ruta) {
        String SQL_UPDATE = "UPDATE TB_RUTA SET PLACA = ? ,DESCRIPCION = ?, CORREO = ? ,TELEFONO = ?, COMENTARIO = ? ,"
                + "AUTORIZACION = ? ,FIRMA = ? , ESTADO = ?, FECHA_ACTUALIZACION = CURRENT_TIMESTAMP WHERE CODIGO=?;";
        System.out.println("***************************************************UPDATE TB_RUTA SET PLACA =" + ruta.getPlaca() + " DESCRIPCION = " + ruta.getDescripcion() + " CORREO = " + ruta.getCorreo() + " TELEFONO = " + ruta.getTelefono() + " COMENTARIO = " + ruta.getComentario()
                + " AUTORIZACION = " + ruta.getAutorizacion() + " FIRMA = 'FIRMA' ESTADO = " + ruta.getEstado() + " FECHA_ACTUALIZACION = CURRENT_TIMESTAMP WHERE CODIGO=" + ruta.getCodigo() + ";");
        
          try (  PreparedStatement pstm = cnn.prepareStatement(SQL_UPDATE)){
            pstm.setString(1, ruta.getPlaca());
            pstm.setString(2, ruta.getDescripcion());
            pstm.setString(3, ruta.getCorreo());
            pstm.setString(4, ruta.getTelefono());
            pstm.setString(5, ruta.getComentario());
            pstm.setString(6, ruta.getAutorizacion());
            pstm.setString(7, "firma");
            pstm.setString(8, ruta.getEstado());
            pstm.setInt(9, ruta.getCodigo());
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
