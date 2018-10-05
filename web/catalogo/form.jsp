
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
                    <strong>Mantenimiento</strong>
                </div>
                <div class="card-body">
                    <s:form action="/catalogo/guardar" cssClass="form-horizontal">
                        <div class="form-group row">
                            <label class="col-md-3 col-form-label" for="codigo">Codigo</label>
                            <div class="col-md-5">
                                <s:textfield type="text" name="codigo1" cssClass="form-control" placeholder="Codigo autogenerado del catalogo" value="%{catalogo.codigo}" disabled="true" />
                                <s:textfield type="hidden" name="codigo" cssClass="form-control"  value="%{catalogo.codigo}"/>
                                <input type="hidden" name="tipoCatalogo" value="<%= request.getParameter("tcatalogo") %>">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-md-3 col-form-label" for="text-input">Descripion</label>
                            <div class="col-md-5">
                                <s:textfield type="text" name="descripcion" cssClass="form-control" placeholder="Texto como se mostrara" value="%{catalogo.descripcion}" requiredLabel="required"/>
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