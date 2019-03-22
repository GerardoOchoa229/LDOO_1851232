<%-- 
    Document   : Bienvenido
    Created on : 21/03/2019, 01:12:35 AM
    Author     : cuack
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenido</title>
        <link rel="stylesheet" href="main.css">
    </head>
    <body>
        
            
            <%
             String nombre= " amigo";
             Cookie[] allCookies= request.getCookies();
             
             if(allCookies!=null){
                 for(Cookie temp_nombre: allCookies){
                     if("nombre.recibe".equals(temp_nombre.getName()) ){
                         nombre=temp_nombre.getValue();
                         break;
                     }
                 }
             }   
            %>
            <div><h1>Hola <%=nombre%></h1></div>
    </body>
</html>
