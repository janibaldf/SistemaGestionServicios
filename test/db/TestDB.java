package db;
/*
import com.controller.dao.ClienteDAO;
import com.controller.dao.RutaDAO;
import org.junit.Test;
import static org.junit.Assert.*;
import com.controller.dbConection.ConnectDB;
import com.model.dto.eCliente;
import com.model.dto.eRuta;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
*/
public class TestDB {
/*
    //@Test
    public void ConexionDB_Test() throws SQLException {
        ConnectDB estadoBD = ConnectDB.getEstadoBD();
        Connection cnn = estadoBD.getCnn();
        System.out.println("Conectado a:" + cnn.getCatalog());
        assertNotNull(cnn);
    }
    // @Test

    public void sqlRuta_Test_SelectAll() throws SQLException {
        RutaDAO rdao = new RutaDAO();
        List<eRuta> selectAll = rdao.selectAll();

    }
   
    
    
           @Test
    public void sqlCliente_Insert_UpdateEstado(){
          eCliente cliente = new eCliente();
        ClienteDAO clientedao = new ClienteDAO();
            clientedao.delete(1);
       
    }
    
   // @Test
       public void sqlCliente_SelectClientes(){
          eCliente cliente = new eCliente();
        ClienteDAO clientedao = new ClienteDAO();
        List<eCliente> selectAll = clientedao.selectAll();
        System.out.print(selectAll.get(0).getComentario());
        
    }
       
      
       public void sqlCliente_SelectCliente(){
          eCliente cliente = new eCliente();
        ClienteDAO clientedao = new ClienteDAO();
        
       eCliente selectAll = clientedao.selectOne(1);
        System.out.print(selectAll.getComentario());
        
    }
   // @Test
    public void sqlCliente_Insert_Update(){
        
          eCliente cliente = new eCliente();
        ClienteDAO clientedao = new ClienteDAO();
        cliente.setCodigo(1);
  
       cliente.setCalle("calle");
        cliente.setColonia("colonia");
        cliente.setApartamento("apartamento");
        cliente.setAvenida("avenida");
        cliente.setComentario("comentario actualizado");
        cliente.setComprobante("R");
        cliente.setCostoServicio(100.00);
        cliente.setDireccionImpresion("direccionImpresion");
        cliente.setFechaActualizacion(new Date());
        cliente.setFechaIngreso(new Date());
        cliente.setMotivoEstado("motivoEstado");
        cliente.setNit("nit");
        cliente.setNombre("nombre");
        cliente.setNumeroCasa("20-40");
        cliente.setOrdenServicio(1);
        cliente.setReferencia("referencia");
        cliente.setSaldo(BigDecimal.valueOf(0.00));
        cliente.setTelefono("telefono");
        cliente.setZona("1");
        cliente.setcEstado(1);
        cliente.setcRuta(1);
        cliente.setcTipoPago(1);
        cliente.setcTipoServicio(1);
        clientedao.update(cliente);
        
    }
    //@Test
    public void sqlCliente_Insert_Test() {
        eCliente cliente = new eCliente();
        ClienteDAO clientedao = new ClienteDAO();
        cliente.setCodigo(0);
        cliente.setCalle("calle");
        cliente.setColonia("colonia");
        cliente.setApartamento("apartamento");
        cliente.setAvenida("avenida");
        cliente.setComentario("comentario");
        cliente.setComprobante("R");
        cliente.setCostoServicio(BigDecimal.valueOf(100.00));
        cliente.setDireccionImpresion("direccionImpresion");
        cliente.setFechaActualizacion(new Date());
        cliente.setFechaIngreso(new Date());
        cliente.setMotivoEstado("motivoEstado");
        cliente.setNit("nit");
        cliente.setNombre("nombre");
        cliente.setNumeroCasa("20-40");
        cliente.setOrdenServicio(1);
        cliente.setReferencia("referencia");
        cliente.setSaldo(BigDecimal.valueOf(0.00));
        cliente.setTelefono("telefono");
        cliente.setZona("1");
        cliente.setcEstado(1);
        cliente.setcRuta(1);
        cliente.setcTipoPago(1);
        cliente.setcTipoServicio(1);

        clientedao.add(cliente);

    }
*/
}