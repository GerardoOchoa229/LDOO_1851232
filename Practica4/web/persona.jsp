<%-- 
    Document   : persona
    Created on : 15/03/2019, 12:14:42 PM
    Author     : cuack
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Practica #4 LDOO</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="main.css">
    </head>
    <body>
        <h1>Formulario</h1>
        <form:form method = "POST" action = "/Practica4/addPersona">
        <div>
        <form:form method = "POST" action = "/Practica4/addPersona">
            <h2>Registro de usuario</h2>
                <form:label from='' path = "name">Nombre</form:label>
                <form:input  path = "name" />
                <form:label path = "email">Email</form:label>
                <form:input path = "email" />
                <form:label path = "password">Contraseña</form:label>
                <form:input path = "password" />
                <form:label path = "date">Fecha de nacimiento</form:label>
                <form:input path = "date" />
                <input type="submit" value="Enviar"/>  
            </form:form>
        </div>
    </body>
</html>