<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.controller.dao.CatalogoDAO"%>
<%@ page import="com.model.dto.eCatalogo"%>
<%CatalogoDAO catdao=new CatalogoDAO();
            eCatalogo catalogo= new  eCatalogo(); 
            catalogo=catdao.selectOne(Integer.parseInt(request.getParameter("tcatalogo")));
%>
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
                <i class="fa fa-edit"></i> Detalle de Registros - <%= catalogo.getDescripcion()  %> <i></i> <i></i> <i></i> 

            <a class="btn btn-blue" href="nuevo?tcatalogo=<%= request.getParameter("tcatalogo") %>"><i class="fa fa-arrow-circle-up "></i> Nuevo</a>
        </div>
        <div class="card-body">
            <div id="DataTables_Table_0_wrapper" class="dataTables_wrapper container-fluid dt-bootstrap4 no-footer">
                <div class="row">
                    <div class="col-sm-4 col-md-2">
                        <div class="dataTables_length" id="DataTables_Table_0_length">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12">
                            <table class="table table-striped table-bordered datatable dataTable no-footer" id="DataTables_Table_0" role="grid" aria-describedby="DataTables_Table_0_info" style="border-collapse: collapse !important">
                                <thead>
                                    <tr role="row">
                                        <th class="sorting_asc" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Username: activate to sort column descending" style="width: auto;">Editar</th>
                                        <th class="sorting_asc" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Username: activate to sort column descending" style="width: auto;">Codigo</th>
                                        <th class="sorting" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="Date registered: activate to sort column ascending" style="width: 200px;">Descripcion</th>
                                        <th class="sorting" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="Role: activate to sort column ascending" style="width: auto;">Ingreso</th>
                                        <th class="sorting" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="Status: activate to sort column ascending" style="width: auto;">Actualizacion</th>
                                </thead>
                                <tbody>
                                    <s:iterator value="catalogos" status="catalogosStatus">
                                        <tr role="row" class="even">
                                            <td><a class="btn btn-info" href="editar?rcodigo=<s:property value="codigo" />"><i class="fa fa-edit "></i></a></td>
                                            <td class="sorting_1"><s:property value="codigo" /></td>
                                            <td><s:property value="descripcion" /></td>
                                            <td><s:property value="fechaIngreso" /></td>
                                            <td><s:property value="fechaActualizacion" /></td>
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