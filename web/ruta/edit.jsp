<%@ taglib prefix="s" uri="/struts-tags" %>
<s:if test="#session.userId>''">
<s:include  value="/template/header.jsp"></s:include>
<s:include  value="/template/navbar.jsp"></s:include>
<s:include  value="/template/sidebar.jsp"></s:include>
<s:include   value="/template/main.jsp"></s:include>
<s:include   value="form.jsp"></s:include>
<s:include value="/template/footer.jsp"></s:include>
</s:if>
<s:else>
<script>

    location.replace("../")
    

</script>
</s:else>