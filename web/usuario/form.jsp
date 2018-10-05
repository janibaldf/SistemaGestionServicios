
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
                    <strong>Mantenimiento de Usuario</strong>
                </div>
                <div class="card-body">
                    <s:form action="/usuario/guardar" cssClass="form-horizontal">
                        <div class="form-group row">
                            <label class="col-md-3 col-form-label" for="codigo">Codigo</label>
                            <div class="col-md-5">
                                <s:textfield type="text" name="codigo1" cssClass="form-control" placeholder="Codigo autogenerado del usuario" value="%{usuario.codigo}" disabled="true" />
                                <s:textfield type="hidden" name="codigo" cssClass="form-control"  value="%{usuario.codigo}"/>

                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-md-3 col-form-label" for="text-input">Cuenta</label>
                            <div class="col-md-5">
                                <s:textfield type="text" name="cuenta" cssClass="form-control" placeholder="Cuenta de ingreso del usuario" value="%{usuario.cuenta}" requiredLabel="required"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-md-3 col-form-label" for="text-input">Password</label>
                            <div class="col-md-5">
                                <s:textfield type="password" name="password" cssClass="form-control" placeholder="Password de ingreso del usuario" value="%{usuario.password}" requiredLabel="required"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-md-3 col-form-label" for="text-input">Nombre</label>
                            <div class="col-md-5">
                                <s:textfield type="text" name="nombre" cssClass="form-control" placeholder="Nombre del usuario" value="%{usuario.nombre}" requiredLabel="required"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-md-3 col-form-label" for="text-input">Apellido</label>
                            <div class="col-md-5">
                                <s:textfield type="text" name="apellido" cssClass="form-control" placeholder="Apellido del usuario" value="%{usuario.apellido}" requiredLabel="required"/>
                            </div>
                        </div>
                                                <div class="form-group row">
                        <label class="col-md-3 col-form-label" for="estado">Estado</label>
                        <div class="col-md-5">
                            <select id="estado" name="estado" class="form-control">
                                <option value="0">Seleccione</option>
                                <option value="1">Activo</option>
                                <option value="2">Inactivo</option>
                            
                            </select>
                        </div>
                    </div>
                            
                              <div class="form-group row">
                            <label class="col-md-3 col-form-label" for="text-input">Fecha Actualizacion</label>
                            <div class="col-md-5">
                                <s:textfield type="text" name="fechaActualizacion" cssClass="form-control" placeholder="Fecha de Actualiacion" value="%{usuario.fechaActualizacion}" requiredLabel="required" disabled="true"/>
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