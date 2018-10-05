package com.controller.dao;

import com.controller.dbConection.ConnectDB;
import com.interfaces.iControllerDAO;
import com.model.dto.ePermiso;
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

public class PermisoDAO implements iControllerDAO<ePermiso> {

    private String SELECT_ALL = "SELECT * FROM tb_usuario_ruta_rol;";
    private String SQL_INSERT = "INSERT INTO TB_USUARIO_RUTA_ROL( CODIGO_RUTA, CODIGO_USUARIO, CODIGO_ROL, FECHA_INGRESO, FECHA_ACTUALIZACION)"
            + "VALUES(?,?,?,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP); ";
    ConnectDB estadoBD = ConnectDB.getEstadoBD();
    Connection cnn = estadoBD.getCnn();

    @Override
    public ePermiso selectOne(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ePermiso> selectAll() {
        List<ePermiso> permisos = new ArrayList<>();
        Date date;
        Timestamp timestamp;
        RutaDAO rutadoa = new RutaDAO();
        RolDAO roldoa = new RolDAO();
        UsuarioDAO usuariodao = new UsuarioDAO();
        try (PreparedStatement pstm = cnn.prepareStatement(SELECT_ALL)) {
            try (ResultSet rset = pstm.executeQuery()) {
                while (rset.next()) {
                    ePermiso permiso = new ePermiso();
                    permiso.setCodigoRol(rset.getInt("CODIGO_ROL"));
                    permiso.setCodigoRuta(rset.getInt("CODIGO_RUTA"));
                    permiso.setCodigoUsuario(rset.getInt("CODIGO_USUARIO"));
                    timestamp = rset.getTimestamp("FECHA_ACTUALIZACION");
                    date = new Date(timestamp.getTime());
                    permiso.setFechaActualizacion(date);
                    timestamp = rset.getTimestamp("FECHA_INGRESO");
                    date = new Date(timestamp.getTime());
                    permiso.setFechaIngreso(date);
                    permiso.setRol(roldoa.selectOne(rset.getInt("CODIGO_ROL")));
                    permiso.setRuta(rutadoa.selectOne(rset.getInt("CODIGO_RUTA")));
                    permiso.setUsuario(usuariodao.selectOne(rset.getInt("CODIGO_USUARIO")));
                    permisos.add(permiso);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return permisos;
    }

    @Override
    public boolean add(ePermiso element) {
        try (PreparedStatement pstm = cnn.prepareStatement(SQL_INSERT)) {

            pstm.setInt(1, element.getCodigoRuta());
            pstm.setInt(2, element.getCodigoUsuario());
            pstm.setInt(3, element.getCodigoRol());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RutaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean deletePermiso(int cUsuario, int cRol, int cRuta) {
        String SQL_DELETE = "DELETE FROM TB_USUARIO_RUTA_ROL WHERE CODIGO_RUTA=? AND CODIGO_USUARIO=? AND CODIGO_ROL=?;";

        try (PreparedStatement pstm = cnn.prepareStatement(SQL_DELETE)) {
            pstm.setInt(1, cRuta);
            pstm.setInt(2, cUsuario);
            pstm.setInt(3, cRol);
            int executeUpdate = pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RutaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }

    @Override
    public boolean update(ePermiso elemen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateAll(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
