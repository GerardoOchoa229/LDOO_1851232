<%-- 
    Document   : p3
    Created on : 5/03/2019, 09:38:28 AM
    Author     : cuack
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Datos introducidos</title>
        
        <link rel="stylesheet" href="main.css">
    </head>
    <body>
        <div>
        Email: <%=request.getParameter("email")%> <br/>
        Contraseña: <%=request.getParameter("password")%> <br/>
        Nombre:<%=request.getParameter("nombre")%> <br/>
        Fecha de Nacimiento: <%=request.getParameter("fecha")%><br/>
        </div>
    </body>
</html>
