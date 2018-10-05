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
            <tr><td>Codigo</td><td><s:property value="ruta.codigo"></s:property></td></tr>
         <tr><td>Placa</td><td><s:property value="ruta.placa"></s:property></td></tr>
         <tr><td>Autorizacion</td><td><s:property value="ruta.autorizacion"></s:property></td></tr>
         <tr><td>Descripcion</td><td><s:property value="ruta.descripcion"></s:property></td></tr>
         <tr><td>Correo</td><td><s:property value="ruta.correo"></s:property></td></tr>
         <tr><td>Telefono</td><td><s:property value="ruta.telefono"></s:property></td></tr>
         <tr><td>Comentario</td><td><s:property value="ruta.comentario"></s:property></td></tr>
         <tr><td>Firma</td><td><s:property value="ruta.firma"></s:property></td></tr>
         <tr><td>Estado</td><td><s:property value="ruta.estado"></s:property></td></tr>
         <tr><td>Fecha Ingreso</td><td><s:property value="ruta.fechaActualizacion"></s:property></td></tr>
         <tr><td>Fecha Actualizacion</td><td><s:property value="ruta.fechaIngreso"></s:property></td></tr>
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