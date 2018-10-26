<%-- 
    Document   : pdf
    Created on : 23/01/2016, 03:31:22 PM
    Author     : Ingeniero
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>
<%@page import="net.sf.jasperreports.engine.*"%>
<%@page import="net.sf.jasperreports.view.JasperViewer"%>
<%@page import="javax.servlet.ServletResponse"%>
<%@page import="com.controller.dbConection.ConnectDB"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <%
       ConnectDB estadoBD = ConnectDB.getEstadoBD();
            Connection con = estadoBD.getCnn();
        
        //File reportfile = new File ("/home/janibaldf/NetBeansProjects/WebApplication1/web/report1.jasper");
         File reportfile = new File (application.getRealPath("reporte/todosClientesPDF.jasper"));
        Map<String,Object> parameter = new HashMap<String,Object>();
        
        //String valor = request.getParameter("txtparametro");
        //parameter.put("mar",new String(valor));
        
        byte[] bytes = JasperRunManager.runReportToPdf(reportfile.getPath(),parameter, con);
        
       response.setContentType("application/pdf");
        response.setContentLength(bytes.length);
        ServletOutputStream outputstream = response.getOutputStream();
        outputstream.write(bytes,0,bytes.length);
        
        outputstream.flush();
        outputstream.close();
        %>
        
    </body>
</html>
