<%@taglib prefix="s" uri="/struts-tags" %>

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
                <strong>Mantenimiento Rutas</strong>
                Ingreso
            </div>
            <div class="card-body">
                <s:form action="/ruta/guardar" cssClass="form-horizontal">
                    <div class="form-group row">
                        <label class="col-md-3 col-form-label" for="codigo">Codigo</label>
                        <div class="col-md-5">
                            <s:textfield type="text" name="codigo1" cssClass="form-control" placeholder="Codigo de la ruta" value="%{ruta.codigo}" disabled="true" />
                            <s:textfield type="hidden" name="codigo" cssClass="form-control"  value="%{ruta.codigo}"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-md-3 col-form-label" for="text-input">Placa</label>
                        <div class="col-md-5">
                            <s:textfield type="text" name="placa" cssClass="form-control" placeholder="Placa del Camion" value="%{ruta.placa}" requiredLabel="required"/>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-md-3 col-form-label" for="autorizacion">Autorizacion</label>
                        <div class="col-md-5">
                            <s:textfield type="text" name="autorizacion" cssClass="form-control" placeholder="No. de Autorizacion del camion" value="%{ruta.autorizacion}"/>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-md-3 col-form-label" for="descripcion">Decripcion</label>
                        <div class="col-md-5">
                            <s:textfield type="text" name="descripcion" cssClass="form-control" placeholder="Descripcion de la ruta" value="%{ruta.descripcion}"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-md-3 col-form-label" for="correo">Correo</label>
                        <div class="col-md-5">
                            <s:textfield type="text" name="correo" cssClass="form-control" placeholder="Correo de contacto para el cliente" value="%{ruta.correo}"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-md-3 col-form-label" for="telefono">Telefono</label>
                        <div class="col-md-5">
                            <s:textfield type="text" name="telefono" cssClass="form-control" placeholder="Telefono de contacto para el cliente" value="%{ruta.telefono}"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-md-3 col-form-label" for="comentario">Comentario</label>
                        <div class="col-md-5">
                            <s:textfield type="text" name="comentario" cssClass="form-control" placeholder="Comentario general para todos lo clentes de la ruta" value="%{ruta.comentario}"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-md-3 col-form-label" for="file-input">Firma</label>
                        <div class="col-md-9">
                            <input type="file" id="file-input" name="firma">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-md-3 col-form-label" for="estado">Estado</label>
                        <div class="col-md-5">
                            <s:textfield type="text" name="estado" cssClass="form-control" placeholder="Estado actual de la ruta" value="%{ruta.estado}"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-md-3 col-form-label" for="fechaActualizacion">Fecha Actualizado</label>
                        <div class="col-md-5">
                            <s:textfield type="text" name="fechaActualizacion" cssClass="form-control" placeholder="Fecha de ultima actualizacion" value="%{ruta.fechaActualizacion}" disabled="true"/>
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
