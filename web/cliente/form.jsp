 
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
                    <strong>Mantenimiento Clientes</strong>

                </div>
                <div class="card-body">
                    <s:form action="/cliente/guardar" cssClass="form-horizontal" method="get">
                        <div class="row">

                            <div class="form-group col-sm-6">
                                <label for="codigo">Codigo</label>
                                <s:textfield type="text" name="codigo1" cssClass="form-control" placeholder="Codigo autogenerado del usuario" value="%{cliente.codigo}" disabled="true" />
                                <s:textfield type="hidden" name="codigo" cssClass="form-control"  value="%{cliente.codigo}"/>
                            </div>
                            <div class="form-group col-sm-6">
                                <label for="ordenServicio">Correlativo</label>
                                <s:textfield type="text" name="ordenServicio" cssClass="form-control" placeholder="No. de orden de la ruta" value="%{cliente.ordenServicio}" />
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label" for="text-input">Referencia</label>
                            <div class="col-md-6">
                                <s:textfield type="text" name="referencia" cssClass="form-control" placeholder="Referencia del servicio" value="%{cliente.referencia}" />
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label" for="text-input">Direccion Impresion</label>
                            <div class="col-md-8">
                                <s:textfield type="text" name="direccionImpresion" cssClass="form-control" placeholder="Direccion para imprimir en el recibo" value="%{cliente.direccionImpresion}" />
                            </div>
                        </div>


                        <div class="row">
                            <div class="form-group col-sm-6">
                                <label for="costoServicio">Costo Servicio</label>
                                <s:textfield type="text" name="costoServicio" cssClass="form-control" placeholder="Costo del Servicio" value="%{cliente.costoServicio}" />
                            </div>
                            <div class="form-group col-sm-6">
                                <b><label for="saldo">Saldo</label></b>
                                <s:textfield type="text" name="saldo" cssClass="form-control" placeholder="Saldo del Cliente" value="%{cliente.saldo}" />
                            </div>
                        </div>
                        <div class="row">

                            <div  class=" form-group col-sm-6">
                                <label for="rutas">Ruta</label>
                                <select id="rutas" name="cRuta" class="form-control">

                                    <option value="0">Seleccione</option>

                                    <s:iterator value="rutas" status="rutasStatus">

                                        <s:if test="cliente.cRuta==codigo">
                                            <option selected="selected" value="<s:property value="codigo" />"><s:property value="autorizacion" /></option>  
                                        </s:if>
                                        <s:else>
                                            <option value="<s:property value="codigo" />"><s:property value="autorizacion" /></option>  
                                        </s:else>
                                    </s:iterator>

                                </select>
                            </div>

                            <div  class=" form-group col-sm-6">
                                <label for="rutas">Estado</label>
                                <select id="rol" name="cEstado" class="form-control">
                                    <option value="-1">Seleccione</option>
                                    <s:iterator value="tipoEstados" status="estadoStatus">
                                        <s:if test="cliente.cEstado==codigo">
                                            <option selected="selected" value="<s:property value="codigo" />"><s:property value="descripcion" /></option>
                                        </s:if>
                                        <s:else>
                                            <option value="<s:property value="codigo" />"><s:property value="descripcion" /></option>
                                        </s:else>
                                    </s:iterator>
                                </select>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label" for="text-input">Motivo Estado</label>
                            <div class="col-md-8">
                                <s:textfield type="text" name="motivoEstado" cssClass="form-control" placeholder="Motivo del estado actual del Cliente" value="%{cliente.motivoEstado}" />
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label" for="text-input">Comentario</label>
                            <div class="col-md-8">
                                <s:textfield type="text" name="comentario" cssClass="form-control" placeholder="Nombre del usuario" value="%{cliente.comentario}" />
                            </div>
                        </div>
                        <div class="row">

                            <div  class=" form-group col-sm-6">
                                <label for="rutas">Tipo de Pago</label>
                                <select id="rol" name="cTipoPago" class="form-control">

                                    <option value="-1">Seleccione</option>

                                    <s:iterator value="tipoPagos" status="tipoPagosStatus">
                                        <s:if test="cliente.cTipoPago==codigo">
                                            <option selected="selected" value="<s:property   value="codigo" />"><s:property value="Descripcion" /></option>
                                        </s:if>
                                        <s:else>
                                            <option value="<s:property value="codigo" />"><s:property value="Descripcion" /></option>
                                        </s:else>
                                    </s:iterator>
                                </select>
                            </div>

                            <div  class=" form-group col-sm-6">
                                <label for="diaPago">Dia de Pago</label>
                                <select id="diaPago" name="diaPago" class="form-control">
                                    <option value="0">Seleccione</option>

                                    <s:iterator begin="1" end="31" var="dia">
                                        <option value="<s:property value="dia" />"><s:property value="dia" />
                                        </s:iterator>
                                </select>
                            </div>
                        </div>



                        <div class="card-footer">
                            Datos Secundarios
                        </div>


                        <div class="row">
                            <div class="form-group col-sm-6">
                                <label for="nombre">Nombre</label>
                                <s:textfield type="text" name="nombre" cssClass="form-control" placeholder="Nombre del Servicio" value="%{cliente.nombre}"  />

                            </div>
                            <div class="form-group col-sm-6">
                                <label for="telefono">Telefono</label>
                                <s:textfield type="text" name="telefono" cssClass="form-control" placeholder="Telefono de contacto del Cliente" value="%{cliente.telefono}" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-sm-6">
                                <label for="nit">NIT</label>
                                <s:textfield type="text" name="nit" cssClass="form-control" placeholder="Numero de NIT del Cliente" value="%{cliente.nit}"  />
                            </div>
                            <div class="form-group col-sm-6">

                                <label for="comprobante">Comprobante</label>
                                <select id="rol" name="comprobante" class="form-control">
                                    <option value="0">Seleccione</option>
                                    <s:if test="cliente.comprobante=='F'">
                                        <option selected="selected" value="F">Factura</option>
                                        <option value="R">Recibo</option>
                                    </s:if>
                                    <s:else>
                                        <option value="F">Factura</option>
                                        <option  selected="selected"  value="R">Recibo</option>
                                    </s:else>
                                </select>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-sm-6">
                                <label for="zona">Zona</label>
                                <select id="rol" name="zona" class="form-control">
                                    <option value="<s:property value="cliente.zona" />" ><s:property value="cliente.zona" /></option>
                                    <option value="0">Seleccione</option>
                                    <s:iterator begin="1" end="25" var="zona0" value="zona0">
                                        <option  value="<s:property value="zona0" />"><s:property value="zona0" />
                                        </s:iterator>

                                </select>
                            </div>
                            <div class="form-group col-sm-6">
                                <label for="colonia">Colonia</label>
                                <s:textfield type="text" name="colonia" cssClass="form-control" placeholder="Colonia del Servicio" value="%{cliente.colonia}" />                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-sm-6">
                                <label for="codigo">Avenida</label>
                                <s:textfield type="text" name="avenida" cssClass="form-control" placeholder="Avenida del Servicio" value="%{cliente.avenida}"  />
                            </div>
                            <div class="form-group col-sm-6">
                                <label for="codigo">Calle</label>
                                <s:textfield type="text" name="calle" cssClass="form-control" placeholder="Calle del Servicio" value="%{cliente.calle}" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-sm-6">
                                <label for="numeroCasa">Numero Casa</label>
                                <s:textfield type="text" name="numeroCasa" cssClass="form-control" placeholder="Numero de casa " value="%{cliente.numeroCasa}"  />
                            </div>
                            <div class="form-group col-sm-6">
                                <label for="apartamento">Apartamento</label>
                                <s:textfield type="text" name="apartamento" cssClass="form-control" placeholder="Apartamento del Servicio" value="%{cliente.apartamento}" />
                            </div>
                        </div>
                        <div class="row">
                            <div  class=" form-group col-sm-6">
                                <label for="tipoServicio">Tipo Servicio</label>
                                <select id="rol" name="cTipoServicio" class="form-control">
                                    <option value="-1">Seleccione</option>
                                    <s:iterator value="tipoServicios" status="tiposServiciosStatus">
                                        <s:if test="cliente.cTipoServicio==codigo">
                                            <option  selected="selected" value="<s:property value="codigo" />"><s:property value="descripcion" /></option>
                                        </s:if>
                                        <s:else>
                                            <option value="<s:property value="codigo" />"><s:property value="descripcion" /></option>
                                        </s:else>
                                    </s:iterator>
                                </select>
                            </div>
                            <div  class=" form-group col-sm-6">

                            </div>
                        </div>
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