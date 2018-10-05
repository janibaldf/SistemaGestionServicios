<%@taglib prefix="s" uri="/struts-tags" %>
<s:include  value="/template/header.jsp"></s:include>
<s:include  value="/template/navbar.jsp"></s:include>
<s:include  value="/template/sidebar.jsp"></s:include>
<s:include   value="/template/main.jsp"></s:include>
<s:include   value="/template/footer.jsp"></s:include>
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