<%@ taglib prefix="s" uri="/struts-tags" %>
<s:if test="#session.userId>''">    
    <s:include  value="/template/header.jsp"></s:include>
    <s:include  value="/template/navbar.jsp"></s:include>
    <s:include  value="/template/sidebar.jsp"></s:include>
    <s:include   value="/template/main.jsp"></s:include>

        <div class="row">

            <div class="col">
            <s:if test="hasActionMessages()">
                <div>
                    <script>
                        toastr["success"]("Registro ingresado/actualizado correctamente")
                        toastr.options = {
                            "closeButton": false,
                            "debug": false,
                            "newestOnTop": false,
                            "progressBar": false,
                            "positionClass": "toast-top-center",
                            "preventDuplicates": false,
                            "onclick": null,
                            "showDuration": "300",
                            "hideDuration": "1000",
                            "timeOut": "5000",
                            "extendedTimeOut": "1000",
                            "showEasing": "swing",
                            "hideEasing": "linear",
                            "showMethod": "fadeIn",
                            "hideMethod": "fadeOut"
                        }
                    </script>
                </div>

            </s:if>
            <s:if test="hasActionErrors()">

                <div class="alert alert-danger" role="alert">
                    <p>Error</p>
                    <s:actionerror/>
                </div>
            </s:if>
            <div class="card">
                <div class="card-header">
                   
                </div>
                <div class="card-body">
                <s:form action="/permisos/guardar" cssClass="form-horizontal" method="get">

                        <div class="form-group row">
                            <label class="col-md-3 col-form-label" for="usuarios">Usuarios</label>
                            <div class="col-md-5">
                                <select id="usuario" name="cUsuario" class="form-control">
                                    <option value="-1">Seleccione</option>
                                    <s:iterator value="usuarios" status="usuariosStatus">
                                        <option value="<s:property value="codigo" />"><s:property value="cuenta" /></option>
                                    </s:iterator>
                                </select>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-md-3 col-form-label" for="roles">Roles</label>
                            <div class="col-md-5">
                                <select id="rol" name="cRol" class="form-control">
                                    <option value="-1">Seleccione</option>
                                    <s:iterator value="roles" status="rolStatus">

                                        <option value="<s:property value="codigo" />"><s:property value="nombre" /></option>
                                    </s:iterator>
                                </select>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-md-3 col-form-label" for="rutas">Roles</label>
                            <div class="col-md-5">
                                <select id="rol" name="cRuta" class="form-control">
                                    <option value="-1">Seleccione</option>
                                    <s:iterator value="rutas" status="rolStatus">

                                        <option value="<s:property value="codigo" />"><s:property value="autorizacion" /></option>
                                    </s:iterator>
                                </select>
                            </div>
                        </div>
                        <!--</form>-->
                    </div>
                    <div class="card-footer">
                        <button type="submit" class="btn btn-sm btn-primary">
                            <i class="fa fa-dot-circle-o"></i> Guardar</button>
                        <button type="reset" class="btn btn-sm btn-danger">
                            <i class="fa fa-ban"></i>Cancelar</button>
                    </div>
                </s:form>   





            </div>
        </div>
        <s:include value="/template/footer.jsp"></s:include>
    </s:if>
    <s:else>
        <script>

            location.replace("../")


        </script>
    </s:else>