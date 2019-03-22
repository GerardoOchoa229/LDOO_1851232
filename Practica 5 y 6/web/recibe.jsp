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
        <% String email=request.getParameter("email");
         String password= request.getParameter("password");
       String nombre= request.getParameter("nombre");
         String fecha= request.getParameter("fecha");
         
            Cookie cookieEmail= new Cookie("email.recibe", email);
            Cookie cookiePassword= new Cookie("password.recibe", password);
            Cookie cookieNombre= new Cookie("nombre.recibe", nombre);
            Cookie cookieFecha= new Cookie("fecha.recibe", fecha);
            
            cookieEmail.setMaxAge(31536000);
            cookiePassword.setMaxAge(31536000);
            cookieNombre.setMaxAge(31536000);
            cookieFecha.setMaxAge(31536000);
            
            
            response.addCookie(cookieNombre);
            response.addCookie(cookieFecha);
           
        %>
        <div>
            <h1><a href="Bienvenido.jsp">Pagina Inicial</a></h1>
        </div>
    </body>
</html>
