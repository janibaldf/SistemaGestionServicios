package com.controller.dao;

import com.controller.dbConection.ConnectDB;
import com.interfaces.iControllerDAO;
import com.model.dto.eCatalogo;
import com.model.dto.eCuentaCliente;
import java.sql.Array;
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

public class CuentaClienteDAO implements iControllerDAO<eCuentaCliente> {

    private ConnectDB estadoBD = ConnectDB.getEstadoBD();
    private Connection cnn = estadoBD.getCnn();

    @Override
    public eCuentaCliente selectOne(int id) {
        String sqlSelectAll = "SELECT * FROM TB_CUENTA_CLIENTE WHERE CODIGO=?";
        Timestamp timestamp;
        Date date;
        eCuentaCliente cuentaCliente = new eCuentaCliente();
        CatalogoDAO catalogodao = new CatalogoDAO();
        ClienteDAO clientedao = new ClienteDAO();
        try (PreparedStatement pstm = cnn.prepareStatement(sqlSelectAll)) {
            pstm.setInt(1, id);
            try (ResultSet rset = pstm.executeQuery()) {

                cuentaCliente.setCodigoCuentaCliente(rset.getInt("CODIGO_CUENTA_CLIENTE"));
                cuentaCliente.setCcliente(rset.getInt("CODIGO_CLIENTE"));
                cuentaCliente.setCostoServicio(rset.getDouble("COSTO_SERVICIO"));
                cuentaCliente.setMontoPago(rset.getDouble("MONTO_PAGO"));
                cuentaCliente.setSaldoAnterior(rset.getDouble("SALDO_ANTERIOR"));
                cuentaCliente.setNuevoSaldo(rset.getDouble("NUEVO_SALDO"));
                cuentaCliente.setMes(rset.getString("MES"));
                cuentaCliente.setcTipoTransaccion(rset.getInt("TIPO_TRANSACCION"));
                timestamp = rset.getTimestamp("FECHA_ACTUALIZACION");
                date = new Date(timestamp.getTime());
                cuentaCliente.setFechaActualizacion(date);
                timestamp = rset.getTimestamp("FECHA_INGRESO");
                date = new Date(timestamp.getTime());
                cuentaCliente.setFechaIngreso(date);
                cuentaCliente.setTipoTransaccion(catalogodao.selectOne(cuentaCliente.getcTipoTransaccion()));
                cuentaCliente.setCliente(clientedao.selectOne(cuentaCliente.getCcliente()));
                pstm.close();
                rset.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(CuentaClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cuentaCliente;
    }

    @Override
    public List<eCuentaCliente> selectAll() {
        String sqlSelectAll = "SELECT * FROM TB_CUENTA_CLIENTE";
        Timestamp timestamp;
        Date date;

        List<eCuentaCliente> cuentas = new ArrayList<>();
        CatalogoDAO catalogodao = new CatalogoDAO();
        ClienteDAO clientedao = new ClienteDAO();
        try (PreparedStatement pstm = cnn.prepareStatement(sqlSelectAll)) {

            try (ResultSet rset = pstm.executeQuery()) {
                while (rset.next()) {
                    eCuentaCliente cuentaCliente = new eCuentaCliente();
                    cuentaCliente.setCodigoCuentaCliente(rset.getInt("CODIGO_CUENTA_CLIENTE"));
                    cuentaCliente.setCcliente(rset.getInt("CODIGO_CLIENTE"));
                    cuentaCliente.setCostoServicio(rset.getDouble("COSTO_SERVICIO"));
                    cuentaCliente.setMontoPago(rset.getDouble("MONTO_PAGO"));
                    cuentaCliente.setSaldoAnterior(rset.getDouble("SALDO_ANTERIOR"));
                    cuentaCliente.setNuevoSaldo(rset.getDouble("NUEVO_SALDO"));
                    cuentaCliente.setMes(rset.getString("MES"));
                    cuentaCliente.setcTipoTransaccion(rset.getInt("TIPO_TRANSACCION"));
                    timestamp = rset.getTimestamp("FECHA_ACTUALIZACION");
                    date = new Date(timestamp.getTime());
                    cuentaCliente.setFechaActualizacion(date);
                    timestamp = rset.getTimestamp("FECHA_INGRESO");
                    date = new Date(timestamp.getTime());
                    cuentaCliente.setFechaIngreso(date);
                    cuentaCliente.setTipoTransaccion(catalogodao.selectOne(cuentaCliente.getcTipoTransaccion()));
                    cuentaCliente.setCliente(clientedao.selectOne(cuentaCliente.getCcliente()));
                    cuentas.add(cuentaCliente);
                }
                pstm.close();
                rset.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(CuentaClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cuentas;
    }

    @Override
    public boolean add(eCuentaCliente e) {
        String sqlInsert = "INSERT INTO TB_CUENTA_CLIENTE(CODIGO_CUENTA_CLIENTE,CODIGO_CLIENTE,COSTO_SERVICIO,MONTO_PAGO,SALDO_ANTERIOR,"
                + "NUEVO_SALDO,MES,TIPO_TRANSACCION,FECHA_INGRESO,FECHA_ACTUALIZACION)"
                + "VALUES ((SELECT IF (MAX(CUENTA.CODIGO_CUENTA_CLIENTE) IS NULL,1, MAX(CUENTA.CODIGO_CUENTA_CLIENTE)+1) FROM TB_CUENTA_CLIENTE CUENTA),"
                + "?,?,?,?,?,?,?,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);";
         int executeUpdate=-1;
         try (PreparedStatement pstm = cnn.prepareStatement(sqlInsert)) {
             pstm.setInt(1, e.getCcliente());
             pstm.setDouble(2, e.getCostoServicio());
             pstm.setDouble(3, e.getMontoPago());
             pstm.setDouble(4, e.getSaldoAnterior());
             pstm.setDouble(5, e.getNuevoSaldo());
             pstm.setString(6, e.getMes());
             pstm.setInt(7, e.getcTipoTransaccion() );
            executeUpdate = pstm.executeUpdate();
            pstm.close();
         } catch (SQLException ex) {
            Logger.getLogger(CuentaClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         if (executeUpdate > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(eCuentaCliente elemen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateAll(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
