<%@ taglib prefix="s" uri="/struts-tags" %>
<s:if test="#session.userId>''">
    <s:include  value="/template/header.jsp"></s:include>
    <s:include   value="/template/navbar.jsp"></s:include>
    <s:include   value="/template/sidebar.jsp"></s:include>
    <s:include   value="/template/main.jsp"></s:include>
        <script type="text/javascript" src="../vendors/js/jquery.dataTables.js"></script>
        <script type="text/javascript" src="../vendors/js/dataTables.bootstrap4.js"></script>
        <link href="../vendors/css/dataTables.bootstrap4.css" rel="stylesheet">
        <script type="text/javascript">
            $(document).ready(function () {
                $('.datatable').DataTable();
                $('.datatable').attr('style', 'border-collapse: collapse !important');
            });
        </script>
        <div class="card">
            <div class="card-header">
                <i class="fa fa-edit"></i> Detalle del Registro
                                
            <a class="btn btn-blue" href="../pago/nuevo"><i class="fa fa-arrow-circle-up "></i> Nuevo</a>
            </div>
            <div class="card-body">
                <div id="DataTables_Table_0_wrapper" class="dataTables_wrapper container-fluid dt-bootstrap4 no-footer">
                    <div class="row">
                        <div class="col-sm-12 col-md-4">
                            <div class="dataTables_length" id="DataTables_Table_0_length">

                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <table class="table table-striped table-bordered datatable dataTable no-footer" id="DataTables_Table_0" role="grid" aria-describedby="DataTables_Table_0_info" style="border-collapse: collapse !important">
                                    <thead>
                                        <tr role="row">
                                            <th class="sorting" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="Date registered: activate to sort column ascending" style="width: auto;">Codigo Cliente</th>
                                            <th class="sorting" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="Role: activate to sort column ascending" style="width: auto;">Direccion</th>
                                            <th class="sorting" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="Status: activate to sort column ascending" style="width: auto;">Referencia</th>
                                            <th class="sorting" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="Status: activate to sort column ascending" style="width: auto;">Servicio</th>
                                            <th class="sorting" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="Actions: activate to sort column ascending" style="width: auto;">Forma Pago</th>
                                            <th class="sorting" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="Actions: activate to sort column ascending" style="width: auto;">Transasccion</th>
                                            <th class="sorting" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="Actions: activate to sort column ascending" style="width: auto;">Monto</th>
                                            <th class="sorting" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="Actions: activate to sort column ascending" style="width: auto;">Saldo</th>
                                            <th class="sorting" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="Actions: activate to sort column ascending" style="width: auto;">Fecha  </th>
                                    </thead>
                                    <tbody>
                                    <s:iterator value="pagos" status="pago">
                                        <tr role="row" class="even">
                                            <td class="sorting_1"><s:property value="cliente.codigo" /></td>
                                            <td class="sorting_1"><s:property value="cliente.direccionImpresion" /></td>
                                            <td class="sorting_1"><s:property value="cliente.referencia" /></td>
                                            <td class="sorting_1"><s:property value="cliente.tipoServicio.descripcion" /></td>
                                            <td class="sorting_1"><s:property value="cliente.tipoPago.descripcion" /></td>
                                            <td class="sorting_1"><s:property value="tipoTransaccion.descripcion " /></td>
                                            
                                            <td><s:property value="montoPago" /></td>
                                            <td><s:property value="cliente.saldo" /></td>
                                            <td><s:property value="fechaIngreso" /></td>
                                            
                                        </tr>
                                    </s:iterator>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div></div>
        </div>
    </div>
</div>

<s:include   value="/template/footer.jsp"></s:include>
</s:if>
<s:else>
    <script>

        location.replace("../")


    </script>
</s:else>