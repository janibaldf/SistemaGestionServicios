package com.controller.dao;

import com.controller.dbConection.ConnectDB;
import com.interfaces.iControllerDAO;
import com.model.dto.eCliente;
import java.math.BigDecimal;
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

public class ClienteDAO implements iControllerDAO<eCliente> {

    ConnectDB estadoBD = ConnectDB.getEstadoBD();
    Connection cnn = estadoBD.getCnn();

    @Override
    public eCliente selectOne(int id) {
        String sqlSelectAll = "SELECT * FROM TB_CLIENTE WHERE CODIGO=?";
        eCliente cliente = new eCliente();
        Timestamp timestamp;
        Date date;
        RutaDAO rutadao = new RutaDAO();
        CatalogoDAO catalogodao = new CatalogoDAO();
        try (PreparedStatement pstm = cnn.prepareStatement(sqlSelectAll)) {
            pstm.setInt(1, id);
            try (ResultSet rset = pstm.executeQuery()) {
                while (rset.next()) {
                    cliente.setCodigo(rset.getInt("CODIGO"));
                    cliente.setcRuta(rset.getInt("CODIGO_RUTA"));
                    cliente.setOrdenServicio(rset.getInt("ORDEN_SERVICIO"));
                    cliente.setcTipoPago(rset.getInt("TIPO_PAGO"));
                    cliente.setcTipoServicio(rset.getInt("TIPO_SERVICIO"));
                    cliente.setNombre(rset.getString("NOMBRE"));
                    cliente.setTelefono(rset.getString("TELEFONO"));
                    cliente.setNit(rset.getString("NIT"));
                    cliente.setComprobante(rset.getString("COMPROBANTE"));
                    cliente.setZona(rset.getString("ZONA"));
                    cliente.setColonia(rset.getString("COLONIA"));
                    cliente.setAvenida(rset.getString("AVENIDA"));
                    cliente.setCalle(rset.getString("CALLE"));
                    cliente.setNumeroCasa(rset.getString("NUMERO_CASA"));
                    cliente.setApartamento(rset.getString("APARTAMENTO"));
                    cliente.setDireccionImpresion(rset.getString("DIRECCION_IMPRESION"));
                    cliente.setReferencia(rset.getString("REFERENCIA"));
                    cliente.setcEstado(rset.getInt("CODIGO_ESTADO"));
                    cliente.setMotivoEstado(rset.getString("MOTIVO_ESTADO"));
                    cliente.setComentario(rset.getString("COMENTARIO"));
                    cliente.setCostoServicio(rset.getDouble("COSTO_SERVICIO"));
                    cliente.setSaldo(rset.getDouble("SALDO"));
                    timestamp = rset.getTimestamp("FECHA_ACTUALIZACION");
                    date = new Date(timestamp.getTime());
                    cliente.setFechaActualizacion(date);
                    timestamp = rset.getTimestamp("FECHA_INGRESO");
                    date = new Date(timestamp.getTime());
                    cliente.setFechaIngreso(date);
                    cliente.setCodigoRuta(rutadao.selectOne(cliente.getcRuta()));
                    cliente.setTipoPago(catalogodao.selectOne(cliente.getcTipoPago()));
                    cliente.setTipoServicio(catalogodao.selectOne(cliente.getcTipoServicio()));
                    cliente.setCodigoEstado((catalogodao.selectOne(cliente.getcEstado())));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cliente;
    }

    @Override
    public List<eCliente> selectAll() {
        String sqlSelectAll = "SELECT * FROM TB_CLIENTE WHERE CODIGO_ESTADO>0";
        List<eCliente> clientes = new ArrayList<>();
        Timestamp timestamp;
        Date date;
        RutaDAO rutadao = new RutaDAO();
        CatalogoDAO catalogodao = new CatalogoDAO();
        try (PreparedStatement pstm = cnn.prepareStatement(sqlSelectAll)) {
            try (ResultSet rset = pstm.executeQuery()) {
                while (rset.next()) {
                    eCliente cliente = new eCliente();
                    cliente.setCodigo(rset.getInt("CODIGO"));
                    cliente.setcRuta(rset.getInt("CODIGO_RUTA"));
                    cliente.setOrdenServicio(rset.getInt("ORDEN_SERVICIO"));
                    cliente.setcTipoPago(rset.getInt("TIPO_PAGO"));
                    cliente.setcTipoServicio(rset.getInt("TIPO_SERVICIO"));
                    cliente.setNombre(rset.getString("NOMBRE"));
                    cliente.setTelefono(rset.getString("TELEFONO"));
                    cliente.setNit(rset.getString("NIT"));
                    cliente.setComprobante(rset.getString("COMPROBANTE"));
                    cliente.setZona(rset.getString("ZONA"));
                    cliente.setColonia(rset.getString("COLONIA"));
                    cliente.setAvenida(rset.getString("AVENIDA"));
                    cliente.setCalle(rset.getString("CALLE"));
                    cliente.setNumeroCasa(rset.getString("NUMERO_CASA"));
                    cliente.setApartamento(rset.getString("APARTAMENTO"));
                    cliente.setDireccionImpresion(rset.getString("DIRECCION_IMPRESION"));
                    cliente.setReferencia(rset.getString("REFERENCIA"));
                    cliente.setcEstado(rset.getInt("CODIGO_ESTADO"));
                    cliente.setMotivoEstado(rset.getString("MOTIVO_ESTADO"));
                    cliente.setComentario(rset.getString("COMENTARIO"));
                    cliente.setCostoServicio(rset.getDouble("COSTO_SERVICIO"));
                    cliente.setSaldo(rset.getDouble("COSTO_SERVICIO"));
                    timestamp = rset.getTimestamp("FECHA_ACTUALIZACION");
                    date = new Date(timestamp.getTime());
                    cliente.setFechaActualizacion(date);
                    timestamp = rset.getTimestamp("FECHA_INGRESO");
                    date = new Date(timestamp.getTime());
                    cliente.setFechaIngreso(date);
                    cliente.setCodigoRuta(rutadao.selectOne(cliente.getcRuta()));
                    cliente.setTipoPago(catalogodao.selectOne(cliente.getcTipoPago()));
                    cliente.setTipoServicio(catalogodao.selectOne(cliente.getcTipoServicio()));
                    cliente.setCodigoEstado((catalogodao.selectOne(cliente.getcEstado())));
                    clientes.add(cliente);
                }
                rset.close();
                pstm.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return clientes;
    }

    @Override
    public boolean add(eCliente c) {
        int executeUpdate = -1;
        String sql_insert = "INSERT INTO TB_CLIENTE(CODIGO,CODIGO_RUTA,ORDEN_SERVICIO,TIPO_PAGO,TIPO_SERVICIO,NOMBRE,TELEFONO,NIT,COMPROBANTE,ZONA,COLONIA,AVENIDA,CALLE,"
                + "NUMERO_CASA,APARTAMENTO,DIRECCION_IMPRESION,REFERENCIA,CODIGO_ESTADO,MOTIVO_ESTADO,COMENTARIO,COSTO_SERVICIO,SALDO,FECHA_INGRESO,FECHA_ACTUALIZACION)VALUES"
                + "((SELECT IF (MAX(CLIENTE.CODIGO) IS NULL,1, MAX(CLIENTE.CODIGO)+1) FROM TB_CLIENTE CLIENTE),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,0,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);";
        try (PreparedStatement pstm = cnn.prepareStatement(sql_insert)) {
            pstm.setInt(1, c.getcRuta());
            pstm.setInt(2, c.getOrdenServicio());
            pstm.setInt(3, c.getcTipoPago());
            pstm.setInt(4, c.getcTipoServicio());
            pstm.setString(5, c.getNombre());
            pstm.setString(6, c.getTelefono());
            pstm.setString(7, c.getNit());
            pstm.setString(8, c.getComprobante());
            pstm.setString(9, c.getZona());
            pstm.setString(10, c.getColonia());
            pstm.setString(11, c.getAvenida());
            pstm.setString(12, c.getCalle());
            pstm.setString(13, c.getNumeroCasa());
            pstm.setString(14, c.getApartamento());
            pstm.setString(15, c.getDireccionImpresion());
            pstm.setString(16, c.getReferencia());
            pstm.setInt(17, c.getcEstado());
            pstm.setString(18, c.getMotivoEstado());
            pstm.setString(19, c.getComentario());
            pstm.setDouble(20, c.getCostoServicio());
            executeUpdate = pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (executeUpdate > 0) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean delete(int id) {
        String SQL_UPDATE_ESTADO = "UPDATE TB_CLIENTE SET  CODIGO_ESTADO =0, FECHA_ACTUALIZACION = CURRENT_TIMESTAMP WHERE CODIGO=?;";

        try (PreparedStatement pstm = cnn.prepareStatement(SQL_UPDATE_ESTADO)) {
            pstm.setInt(1, id);
            int executeUpdate = pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            Logger.getLogger(RutaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }

    public boolean updateSaldo(int codigoCliente, BigDecimal nuevoSaldo) {
        String SQL_UPDATE_SALDO = "UPDATE TB_CLIENTE SET  SALDO = ?, FECHA_ACTUALIZACION = CURRENT_TIMESTAMP WHERE CODIGO=?;";

        try (PreparedStatement pstm = cnn.prepareStatement(SQL_UPDATE_SALDO)) {
            pstm.setInt(2, codigoCliente);
            pstm.setBigDecimal(1, nuevoSaldo);
            int executeUpdate = pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            Logger.getLogger(RutaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }

    @Override
    public boolean update(eCliente c) {
        String sql_update = "UPDATE TB_CLIENTE SET CODIGO_RUTA=?,ORDEN_SERVICIO =?,TIPO_PAGO=?,TIPO_SERVICIO=?,NOMBRE=?,TELEFONO=?,NIT=?,COMPROBANTE=?,ZONA=?,COLONIA=?,AVENIDA=?,CALLE=?,"
                + "NUMERO_CASA =?,APARTAMENTO=?,DIRECCION_IMPRESION=?,REFERENCIA=?,CODIGO_ESTADO=?,MOTIVO_ESTADO=?,COMENTARIO =?,COSTO_SERVICIO=?,FECHA_ACTUALIZACION=CURRENT_TIMESTAMP"
                + " WHERE CODIGO=?";
        try (PreparedStatement pstm = cnn.prepareStatement(sql_update)) {
            pstm.setInt(1, c.getcRuta());
            pstm.setInt(2, c.getOrdenServicio());
            pstm.setInt(3, c.getcTipoPago());
            pstm.setInt(4, c.getcTipoServicio());
            pstm.setString(5, c.getNombre());
            pstm.setString(6, c.getTelefono());
            pstm.setString(7, c.getNit());
            pstm.setString(8, c.getComprobante());
            pstm.setString(9, c.getZona());
            pstm.setString(10, c.getColonia());
            pstm.setString(11, c.getAvenida());
            pstm.setString(12, c.getCalle());
            pstm.setString(13, c.getNumeroCasa());
            pstm.setString(14, c.getApartamento());
            pstm.setString(15, c.getDireccionImpresion());
            pstm.setString(16, c.getReferencia());
            pstm.setInt(17, c.getcEstado());
            pstm.setString(18, c.getMotivoEstado());
            pstm.setString(19, c.getComentario());
            pstm.setDouble(20, c.getCostoServicio());
            pstm.setInt(21, c.getCodigo());
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public boolean updateAll(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
