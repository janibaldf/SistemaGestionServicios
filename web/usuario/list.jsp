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
                                            <th class="sorting" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="Actions: activate to sort column ascending" style="width: auto;">Ver</th>
                                            <th class="sorting_asc" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Username: activate to sort column descending" style="width: auto;">Editar</th>
                                            <th class="sorting" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="Actions: activate to sort column ascending" style="width: auto;">Password</th>
                                            <th class="sorting_asc" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Username: activate to sort column descending" style="width: auto;">Codigo</th>
                                            <th class="sorting" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="Date registered: activate to sort column ascending" style="width: 200px;">Cuenta</th>
                                            <th class="sorting" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="Role: activate to sort column ascending" style="width: auto;">Nombre</th>
                                            <th class="sorting" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="Status: activate to sort column ascending" style="width: auto;">Apellido</th>
                                            
                                           <th class="sorting" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="Actions: activate to sort column ascending" style="width: auto;">Eliminar</th>        
                                    </thead
                                    <tbody>
                                    <s:iterator value="usuarios" status="usuariosStatus">
                                        <tr role="row" class="even">
                                            <td><a class="btn btn-green" href="ver?cusuario=<s:property value="codigo" />"><i class="fa fa-search-plus"></i></a></td>
                                            <td><a class="btn btn-info" href="editar?cusuario=<s:property value="codigo" />"><i class="fa fa-edit "></i></a></td>
                                            <td><a class="btn btn-gray-200" href="changepass?cusuario=<s:property value="codigo" />"><i class="fa fa-key "></i></a></td>
                                            
                                            <td class="sorting_1"><s:property value="codigo" /></td>
                                            <td><s:property value="cuenta" /></td>
                                            <td><s:property value="nombre" /></td>
                                            <td><s:property value="apellido" /></td>
                                            <!--<td><s:property value="estado" /></td>-->
                                            
                                            <td><a class="btn btn-danger" href="eliminar?cusuario=<s:property value="codigo" />"><i class="fa fa-trash-o "></i></a></td>
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