<%@ taglib prefix="s" uri="/struts-tags" %>

<header class="app-header navbar">
    <button class="navbar-toggler mobile-sidebar-toggler d-lg-none" type="button">
    <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand" href="#"></a>
    <button class="navbar-toggler sidebar-toggler d-md-down-none" type="button">
    <span class="navbar-toggler-icon"></span>
    </button>
    <ul class="nav navbar-nav d-md-down-none mr-auto">
        <li> <b>Bienvenido, <s:property value="#session.userNombre" />.<s:property value="#session.userId" /> </b></li>
    <li class="nav-item px-3">
    <a class="nav-link" href="#">Inicio</a>
    </li>
    <li class="nav-item px-3">
    <a class="nav-link" href="#">Clientes</a>
    </li>
    <li class="nav-item px-3">
    <a class="nav-link" href="#">Pagos</a>
    </li>
        <li class="nav-item px-3">
    <a class="nav-link" href="#">Reportes</a>
    </li>
    
    </ul>
    
    
  </header>