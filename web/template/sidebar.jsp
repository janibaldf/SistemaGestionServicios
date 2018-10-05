<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="app-body">
    <div class="sidebar">
        <nav class="sidebar-nav">
            <ul class="nav">
                <li class="nav-item">

                    <a class="nav-link" href="../main/index.jsp"><i class="icon-speedometer"></i> Inicio</a>
                </li>
                <li class="nav-title">
                    Administracion 
                </li>
                <li class="nav-item nav-dropdown">
                    <a href="#" class="nav-link nav-dropdown-toggle"><i class="icon-lock"></i>Seguridad</a>
                    <ul class="nav-dropdown-items">
                        <li class="nav-item">
                            <a class="nav-link" href="../usuario/lista"><i class="icon-puzzle"></i>Usuarios</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="../usuario/nuevo"><i class="icon-puzzle"></i>Nuevo Usuario</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="../permisos/lista"><i class="icon-puzzle"></i>Permisos</a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item nav-dropdown">
                    <a href="#" class="nav-link nav-dropdown-toggle"><i class="icon-menu"></i>Catalogos</a>
                    <ul class="nav-dropdown-items">
                        <li class="nav-item">
                            <a class="nav-link" href="../catalogo/lista?tcatalogo=1"><i class="icon-puzzle"></i>Tipo Servicio</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="../catalogo/lista?tcatalogo=2"><i class="icon-puzzle"></i>Estados Genericos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="../catalogo/lista?tcatalogo=3"><i class="icon-puzzle"></i>Estado Clientes</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="../catalogo/lista?tcatalogo=4"><i class="icon-puzzle"></i>Tipos Transaccion</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="../catalogo/lista?tcatalogo=5"><i class="icon-puzzle"></i>Bancos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="../catalogo/lista?tcatalogo=6"><i class="icon-puzzle"></i>Tipos de Pagos</a>
                        </li>
                    </ul>
                </li>            

                <li class="nav-item nav-dropdown">
                    <a class="nav-link nav-dropdown-toggle" href="#"><i class="icon-directions"></i> Rutas</a>
                    <ul class="nav-dropdown-items">
                        <li class="nav-item">
                            <a class="nav-link" href="../ruta/lista"><i class="icon-puzzle"></i> Listado</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="../ruta/nuevo"><i class="icon-puzzle"></i>Nueva Ruta</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#"><i class="icon-puzzle"></i>Ruta-Servicios</a>
                        </li>                
                    </ul>
                </li>
                <li class="nav-title">
                    Mantenimiento
                </li>

                <li class="nav-item nav-dropdown">
                    <a class="nav-link nav-dropdown-toggle" href="#"><i class="icon-globe"></i> Clientes</a>
                    <ul class="nav-dropdown-items">
                        <li class="nav-item">
                            <a class="nav-link" href="../cliente/lista"><i class="icon-puzzle"></i> Listado</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="../cliente/nuevo"><i class="icon-puzzle"></i>Nuevo Cliente</a>
                        </li>
                    </ul>
                </li>
                           <li class="nav-item nav-dropdown">
                    <a class="nav-link nav-dropdown-toggle" href="#"><i class="icon-calculator"></i>Pagos</a>
                    <ul class="nav-dropdown-items">
                        <li class="nav-item">
                            <a class="nav-link" href="../pagos/lista"><i class="icon-puzzle"></i>Listado</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="../pagos/nuevo"><i class="icon-puzzle"></i>Nuevo Pago</a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="../logout"><i class="icon-close"></i>Salida</a>

                </li>
            </ul>  
        </nav>
        <button class="sidebar-minimizer brand-minimizer" type="button"></button>
    </div>