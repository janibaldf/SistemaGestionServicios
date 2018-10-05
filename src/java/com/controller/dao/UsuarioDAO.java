package com.controller.dao;

import com.controller.dbConection.ConnectDB;
import com.interfaces.iControllerDAO;

import com.model.dto.eUsuario;
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
import org.apache.commons.codec.digest.DigestUtils;

public class UsuarioDAO implements iControllerDAO<eUsuario> {

    ConnectDB estadoBD = ConnectDB.getEstadoBD();
    Connection cnn = estadoBD.getCnn();

    public int validateLogin(String user, String pass) {
        int codUser = -1;
        String SELECT_USERPASS = "SELECT CODIGO FROM TB_USUARIO WHERE CUENTA=? AND PASSWORD=? AND ESTADO>0;";

        try (PreparedStatement pstm = cnn.prepareStatement(SELECT_USERPASS)) {
            pstm.setString(1, user);
            pstm.setString(2, encryptPassword(pass));
            try (ResultSet rset = pstm.executeQuery()) {
                if (rset.next()) {
                    codUser = rset.getInt("CODIGO");
                }
                pstm.close();
                rset.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(RutaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return codUser;
    }

    @Override
    public eUsuario selectOne(int id) {
        String SELECT_ONE = "SELECT * FROM TB_USUARIO WHERE CODIGO = ?;";
        eUsuario usuario = new eUsuario();
        Date date;
        Timestamp timestamp;

        try (PreparedStatement prepareStatement = cnn.prepareStatement(SELECT_ONE)) {
            prepareStatement.setInt(1, id);
            try (ResultSet rset = prepareStatement.executeQuery()) {
                if (rset.next()) {
                    usuario.setCodigo(rset.getInt("CODIGO"));
                    usuario.setCuenta(rset.getString("CUENTA"));
                    usuario.setPassword(rset.getString("PASSWORD"));
                    usuario.setNombre(rset.getString("NOMBRE"));
                    usuario.setApellido(rset.getString("APELLIDO"));
                    usuario.setApellido(rset.getString("APELLIDO"));
                    usuario.setEstado(rset.getString("ESTADO"));
                    timestamp = rset.getTimestamp("FECHA_ACTUALIZACION");
                    date = new Date(timestamp.getTime());
                    usuario.setFechaActualizacion(date);
                    timestamp = rset.getTimestamp("FECHA_INGRESO");
                    date = new Date(timestamp.getTime());
                    usuario.setFechaIngreso(date);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RutaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;

    }

    @Override
    public List<eUsuario> selectAll() {
        String SELECT_ALL = "SELECT * FROM TB_USUARIO WHERE ESTADO >0";

        Date date;
        Timestamp timestamp;
        List<eUsuario> usuarios = new ArrayList<>();

        try (PreparedStatement prepareStatement = cnn.prepareStatement(SELECT_ALL)) {

            try (ResultSet rset = prepareStatement.executeQuery()){;
            while (rset.next()) {
                eUsuario usuario = new eUsuario();
                usuario.setCodigo(rset.getInt("CODIGO"));
                usuario.setCuenta(rset.getString("CUENTA"));
                usuario.setPassword(rset.getString("PASSWORD"));
                usuario.setNombre(rset.getString("NOMBRE"));
                usuario.setApellido(rset.getString("APELLIDO"));
                usuario.setEstado(rset.getString("ESTADO"));
                timestamp = rset.getTimestamp("FECHA_ACTUALIZACION");
                date = new Date(timestamp.getTime());
                usuario.setFechaActualizacion(date);
                timestamp = rset.getTimestamp("FECHA_INGRESO");
                date = new Date(timestamp.getTime());
                usuario.setFechaIngreso(date);
                usuarios.add(usuario);
            }
            prepareStatement.close();
            rset.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(RutaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }

    @Override
    public boolean add(eUsuario element) {
        String SQL_INSERT = "INSERT INTO TB_USUARIO (CODIGO,CUENTA,PASSWORD,NOMBRE,APELLIDO,ESTADO,FECHA_INGRESO,FECHA_ACTUALIZACION)"
                + "VALUES((SELECT MAX(USUARIO.CODIGO)+1 FROM TB_USUARIO USUARIO),?,?,?,?,?,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);";
       
            try ( PreparedStatement pstm = cnn.prepareStatement(SQL_INSERT)){
            pstm.setString(1, element.getCuenta());
            pstm.setString(2, element.getPassword());
            pstm.setString(3, element.getNombre());
            pstm.setString(4, element.getApellido());
            pstm.setString(5, element.getEstado());
            int executeUpdate = pstm.executeUpdate();
                       pstm.close();
           
        } catch (SQLException ex) {
            Logger.getLogger(RutaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;

    }

    @Override
    public boolean delete(int id) {
        String SQL_UPDATE_ESTADO = "UPDATE TB_USUARIO SET  ESTADO = -1, FECHA_ACTUALIZACION = CURRENT_TIMESTAMP WHERE CODIGO=?;";
       
           try (  PreparedStatement pstm = cnn.prepareStatement(SQL_UPDATE_ESTADO)){
            pstm.setInt(1, id);
            int executeUpdate = pstm.executeUpdate();
                    pstm.close();
        } catch (SQLException ex) {
            Logger.getLogger(RutaDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return true;
    }

    @Override
    public boolean update(eUsuario elemen) {
        String SQL_UPDATE = "UPDATE TB_USUARIO SET NOMBRE = ? ,APELLIDO = ?, FECHA_ACTUALIZACION = CURRENT_TIMESTAMP WHERE CODIGO=?;";

        
         try (  PreparedStatement pstm = cnn.prepareStatement(SQL_UPDATE)){
            pstm.setString(1, elemen.getNombre());
            pstm.setString(2, elemen.getApellido());
            pstm.setInt(3, elemen.getCodigo());
            int executeUpdate = pstm.executeUpdate();
        pstm.close();
        } catch (SQLException ex) {
            Logger.getLogger(RutaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public boolean updatePassword(eUsuario elemen, String newPassword) {
        String SQL_UPDATE = "UPDATE TB_USUARIO SET PASSWORD = ? , FECHA_ACTUALIZACION = CURRENT_TIMESTAMP WHERE CODIGO=?;";

      
            try (  PreparedStatement pstm = cnn.prepareStatement(SQL_UPDATE)){
            pstm.setString(1, encryptPassword(newPassword));
            pstm.setInt(2, elemen.getCodigo());
            int executeUpdate = pstm.executeUpdate();
        pstm.close();
        } catch (SQLException ex) {
            Logger.getLogger(RutaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public String encryptPassword(String newpassword) {
        String sha256hex;
        sha256hex = DigestUtils.sha256Hex(newpassword + "L");
        return sha256hex;
    }

    @Override
    public boolean updateAll(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
