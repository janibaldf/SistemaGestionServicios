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
                <s:form action="/pago/guardar" cssClass="form-horizontal" method="get">

                        <div class="form-group row">
                            <label class="col-md-3 col-form- label" for="pago">Cliente</label>
                            <div class="col-md-5">
                                <select id="cCliente" name="cCliente" class="form-control">
                                    <option value="-1">Seleccione</option>
                                    <s:iterator value="clientes" status="clienteStatus">
                                    <option value="<s:property value="codigo" />"><s:property value="codigo"/>-<s:property value="direccionImpresion"/></option>
                                    </s:iterator>
                                </select>
                            </div>
                        </div>

                    
                        <div class="form-group row">
                            <label class="col-md-3 col-form-label" for="pagos">Mes de Pago</label>
                            <div class="col-md-5">
                                <select id="cMes" name="cMes" class="form-control">
                                    <option value="-1">Seleccione</option>
                                    <option value="1">1-Enero</option>
                                    <option value="2">2-Febreo</option>
                                    <option value="3">3-Marzo</option>
                                    <option value="4">4-Abril</option>
                                    <option value="5">5-Mayo</option>
                                    <option value="6">6-Junio</option>
                                    <option value="7">7-Julio</option>
                                    <option value="8">8-Agosto</option>
                                    <option value="9">9-Septiembre</option>
                                    <option value="10">10-Octubre</option>
                                    <option value="11">11-Noviembre</option>
                                    <option value="12">12-Diciembre</option>
                                </select>
                                
                            </div>
                        </div>
                    
                    <div class="form-group row">
                            <label class="col-md-3 col-form- label" for="cTipoTransaccion">Transaccion</label>
                            <div class="col-md-5">         
                                <select id="cTipoTransaccion" name="cTipoTransaccion" class="form-control">
                                    <option value="-1">Seleccione</option>
                                    <s:iterator value="transacciones" status="transaccioneStatus">
                                    <option value="<s:property value="codigo" />"><s:property value="descripcion"/></option>
                                    </s:iterator>
                                </select>
                            </div>
                        </div>
                   <div class="form-group row">
                        <label class="col-md-3 col-form-label" for="text-input">Monto</label>
                        <div class="col-md-5">
                            <s:textfield type="text" name="monto" cssClass="form-control" placeholder="Monto del pago"  requiredLabel="required"/>
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