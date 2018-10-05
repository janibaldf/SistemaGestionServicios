<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Ingreso</title>

        <link href="vendors/css/flag-icon.min.css" rel="stylesheet">
        <link href="vendors/css/font-awesome.min.css" rel="stylesheet">
        <link href="vendors/css/simple-line-icons.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
    </head>

    <body class="app flex-row align-items-center">
        <div class="container">
             <s:if test="hasActionErrors()">

                <div class="alert alert-danger" role="alert">
                    <p>Error</p>
                  <s:actionerror/>
                </div>
            </s:if>
            <div class="row justify-content-center">
                <div class="col-md-4">
                    <div class="card-group">
                        <div class="card p-4">
                            <div class="card-body">
                                <h3>Gestion de Servicios</h3>
                                <p class="text-muted">Ingreso al Sistema</p>
                                <s:form action="loginSession" method="post">
                                    <div class="input-group mb-3">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">
                                                <i class="icon-user"></i>
                                            </span>
                                        </div>
                                        <s:textfield type="text" cssClass="form-control" name="userId"></s:textfield>
                                            <!--<input type="text" class="form-control" placeholder="Usuario" name="user">-->
                                        </div>
                                        <div class="input-group mb-4">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text">
                                                    <i class="icon-lock"></i>
                                                </span>
                                            </div>
                                           <!-- <input type="password" class="form-control" placeholder="Contraseña" name="pwd">-->
                                           <s:textfield type="password" cssClass="form-control" name="userPass"></s:textfield>     
                                        </div>
                                        <div class="row-4">
                                            <div class="col-4">
                                                <button type="submit" class="btn btn-primary px-4" >Login</button>
                                            </div>

                                        </div>
                                </s:form>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>

        <script src="vendors/js/jquery.min.js"></script>

        <script src="vendors/js/popper.min.js"></script>
        <script src="vendors/js/bootstrap.min.js"></script>
        <script src="vendors/js/pace.min.js"></script>
        <script src="vendors/js/Chart.min.js"></script>
        <script src="js/app.js"></script>
        <!--<script src="../vendors/js/toastr.min.js"></script>-->
        <script src="vendors/js/gauge.min.js"></script>
        <script src="vendors/js/moment.min.js"></script>
        <script src="vendors/js/daterangepicker.min.js"></script>
        <script src="vendors/js/perfect-scrollbar.min.js"></script>
        <script src="vendors/js/coreui.min.js"></script>
        <script type="text/javascript" src="js/views/main.js"></script>

    </body>
</html>
