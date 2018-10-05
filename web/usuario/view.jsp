<%@ taglib prefix="s" uri="/struts-tags" %>
<s:if test="#session.userId>''">
<s:include  value="/template/header.jsp"></s:include>
<s:include  value="/template/navbar.jsp"></s:include>
<s:include  value="/template/sidebar.jsp"></s:include>
<s:include   value="/template/main.jsp"></s:include>
     <div class="animated fadeIn">
        <div class="card">
            <div class="card-header">
                <i class="fa fa-edit"></i> Detalle del Registro
            </div>
            <div class="card-body">
                <div id="DataTables_Table_0_wrapper" class="dataTables_wrapper container-fluid dt-bootstrap4 no-footer">
                        <div class="row">
    <table class="table table-striped table-bordered datatable dataTable no-footer"> 
        <tbody>
         <tr><td>Codigo</td><td><s:property value="usuario.codigo"></s:property></td></tr>
        <tr><td>Cuenta</td><td><s:property value="usuario.cuenta"></s:property></td></tr>
        <tr><td>Nombre</td><td><s:property value="usuario.nombre"></s:property></td></tr>
        <tr><td>Apellido</td><td><s:property value="usuario.apellido"></s:property></td></tr>
         <tr><td>Estado</td><td><s:property value="usuario.estado"></s:property></td></tr>
         <tr><td>Fecha Ingreso</td><td><s:property value="usuario.fechaActualizacion"></s:property></td></tr>
         <tr><td>Fecha Actualizacion</td><td><s:property value="usuario.fechaIngreso"></s:property></td></tr>
        </tbody>
        <tfoot>
            
        </tfoot>
    </table>
         </div>
             </div>
             </div>
             </div>
             </div>
             
<s:include value="/template/footer.jsp"></s:include>
</s:if>
<s:else>
<script>

    location.replace("../")
    

</script>
</s:else>