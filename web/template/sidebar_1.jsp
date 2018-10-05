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
                            <a class="nav-link" href="base/breadcrumb.html"><i class="icon-puzzle"></i>Usuarios</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="base/breadcrumb.html"><i class="icon-puzzle"></i>Nuevo Usuario</a>
                        </li>
                         <li class="nav-item">
                            <a class="nav-link" href="base/breadcrumb.html"><i class="icon-puzzle"></i>Permisos</a>
                        </li>
                       </ul>
                    </li>
                       <li class="nav-item nav-dropdown">
                    <a href="#" class="nav-link nav-dropdown-toggle"><i class="icon-menu"></i>Catalogos</a>
                       <ul class="nav-dropdown-items">
                        <li class="nav-item">
                            <a class="nav-link" href="base/breadcrumb.html"><i class="icon-puzzle"></i>Tipo Servicio</a>
                        </li>
                         <li class="nav-item">
                            <a class="nav-link" href="base/breadcrumb.html"><i class="icon-puzzle"></i>Estados Genericos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="base/breadcrumb.html"><i class="icon-puzzle"></i>Estado Clientes</a>
                        </li>
                       </ul>
                    </li>            
                <li class="nav-title">
                    Components
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
                            <a class="nav-link" href="base/carousel.html"><i class="icon-puzzle"></i>Ruta-Servicios</a>
                        </li>                
                    </ul>
                </li>
                <li class="nav-item nav-dropdown">
                    <a class="nav-link nav-dropdown-toggle" href="#"><i class="icon-cursor"></i> Buttons</a>
                    <ul class="nav-dropdown-items">
                        <li class="nav-item">
                            <a class="nav-link" href="buttons/buttons.html"><i class="icon-cursor"></i> Buttons</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="buttons/button-group.html"><i class="icon-cursor"></i> Buttons Group</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="buttons/dropdowns.html"><i class="icon-cursor"></i> Dropdowns</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="buttons/loading-buttons.html"><i class="icon-cursor"></i> Loading Buttons</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="buttons/social-buttons.html"><i class="icon-cursor"></i> Social Buttons</a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="charts.html"><i class="icon-pie-chart"></i> Charts</a>
                </li>
                <li class="nav-item nav-dropdown">
                    <a class="nav-link nav-dropdown-toggle" href="#"><i class="fa fa-code"></i> Editors</a>
                    <ul class="nav-dropdown-items">
                        <li class="nav-item">
                            <a class="nav-link" href="editors/code-editor.html"><i class="icon-note"></i> Code Editor</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="editors/markdown-editor.html"><i class="fa fa-code"></i> Markdown Editor</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="editors/text-editors.html"><i class="icon-note"></i> Rich Text Editor</a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item nav-dropdown">
                    <a class="nav-link nav-dropdown-toggle" href="#"><i class="icon-note"></i> Forms</a>
                    <ul class="nav-dropdown-items">
                        <li class="nav-item">
                            <a class="nav-link" href="forms/basic-forms.html"><i class="icon-note"></i> Basic Forms</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="forms/advanced-forms.html"><i class="icon-note"></i> Advanced Forms</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="forms/validation.html"><i class="icon-note"></i> Validation</a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="google-maps.html"><i class="icon-map"></i> Google Maps <span class="badge badge-info">NEW</span></a>
                </li>
                <li class="nav-item nav-dropdown">
                    <a class="nav-link nav-dropdown-toggle" href="#"><i class="icon-star"></i> Icons</a>
                    <ul class="nav-dropdown-items">
                        <li class="nav-item">
                            <a class="nav-link" href="icons/flags.html"><i class="icon-star"></i> Flags <span class="badge badge-success">NEW</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="icons/font-awesome.html"><i class="icon-star"></i> Font Awesome <span class="badge badge-secondary">4.7</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="icons/simple-line-icons.html"><i class="icon-star"></i> Simple Line Icons</a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item nav-dropdown">
                    <a class="nav-link nav-dropdown-toggle" href="#"><i class="icon-bell"></i> Notifications</a>
                    <ul class="nav-dropdown-items">
                        <li class="nav-item">
                            <a class="nav-link" href="notifications/alerts.html"><i class="icon-bell"></i> Alerts</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="notifications/badge.html"><i class="icon-bell"></i> Badge</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="notifications/modals.html"><i class="icon-bell"></i> Modals</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="notifications/toastr.html"><i class="icon-bell"></i> Toastr</a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item nav-dropdown">
                    <a class="nav-link nav-dropdown-toggle" href="#"><i class="icon-energy"></i> Plugins</a>
                    <ul class="nav-dropdown-items">
                        <li class="nav-item">
                            <a class="nav-link" href="plugins/calendar.html"><i class="icon-calendar"></i> Calendar</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="plugins/draggable-cards.html"><i class="icon-cursor-move"></i> Draggable Cards</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="plugins/sliders.html"><i class="icon-equalizer"></i> Sliders</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="plugins/spinners.html"><i class="fa fa-spinner"></i> Spinners</a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item nav-dropdown">
                    <a class="nav-link nav-dropdown-toggle" href="#"><i class="icon-list"></i> Tables</a>
                    <ul class="nav-dropdown-items">
                        <li class="nav-item">
                            <a class="nav-link" href="tables/tables.html"><i class="icon-list"></i> Standard Tables</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="tables/datatables.html"><i class="icon-list"></i> DataTables</a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="widgets.html"><i class="icon-calculator"></i> Widgets <span class="badge badge-info">NEW</span></a>
                </li>
                <li class="divider"></li>
                <li class="nav-title">
                    Extras
                </li>
                <li class="nav-item nav-dropdown">
                    <a class="nav-link nav-dropdown-toggle" href="#"><i class="icon-star"></i> Pages</a>
                    <ul class="nav-dropdown-items">
                        <li class="nav-item">
                            <a class="nav-link" href="views/pages/login.html" target="_top"><i class="icon-star"></i> Login</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="views/pages/register.html" target="_top"><i class="icon-star"></i> Register</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="views/pages/404.html" target="_top"><i class="icon-star"></i> Error 404</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="views/pages/500.html" target="_top"><i class="icon-star"></i> Error 500</a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item nav-dropdown">
                    <a class="nav-link nav-dropdown-toggle" href="#"><i class="icon-layers"></i> UI Kits</a>
                    <ul class="nav-dropdown-items">
                        <li class="nav-item nav-dropdown">
                            <a class="nav-link nav-dropdown-toggle" href="#"><i class="icon-speech"></i> Invoicing</a>
                            <ul class="nav-dropdown-items">
                                <li class="nav-item">
                                    <a class="nav-link" href="UIkits/invoicing/invoice.html"><i class="icon-speech"></i> Invoice</a>
                                </li>
                            </ul>
                        </li>
                        <li class="nav-item nav-dropdown">
                            <a class="nav-link nav-dropdown-toggle" href="#"><i class="icon-speech"></i> Email</a>
                            <ul class="nav-dropdown-items">
                                <li class="nav-item">
                                    <a class="nav-link" href="UIkits/email/inbox.html"><i class="icon-speech"></i> Inbox</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="UIkits/email/message.html"><i class="icon-speech"></i> Message</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="UIkits/email/compose.html"><i class="icon-speech"></i> Compose</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </li>    
            </ul>
        </nav>
        <button class="sidebar-minimizer brand-minimizer" type="button"></button>
    </div>