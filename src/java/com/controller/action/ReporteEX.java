
package com.controller.action;

import com.controller.dao.ReporteDAO;
import com.model.dto.eCatalogo;
import com.model.dto.eCliente;
import com.model.dto.eCuentaCliente;
import com.model.dto.eRuta;

public class ReporteEX {
    ReporteDAO reportedao = new ReporteDAO();
    eCliente cliente= new eCliente();
    eRuta ruta = new eRuta();
    eCuentaCliente cuenta= new eCuentaCliente();
    eCatalogo tipoCuenta= new eCatalogo();
}
