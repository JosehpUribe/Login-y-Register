<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Login y Registro</title>
</head>
<body>
    <h2>Registro</h2>
    <form:form modelAttribute="usuario" action="/procesa/registro" method="post">
        Nombre de Usuario: <form:input path="nombreUsuario" /><form:errors path="nombreUsuario" cssClass="error"/><br/>
        Contraseña: <form:input type="password" path="contraseña" /><form:errors path="contraseña" cssClass="error"/><br/>
        Confirmar Contraseña: <form:input type="password" path="confirmacionContraseña" /><br/>
        Correo: <form:input path="correo" /><br/>
        Nombre: <form:input path="nombre" /><form:errors path="nombre" cssClass="error"/><br/>
        Apellido: <form:input path="apellido" /><form:errors path="apellido" cssClass="error"/><br/>
        Fecha de Nacimiento: <form:input path="fechaDeNacimiento" type="date"/><form:errors path="fechaDeNacimiento" cssClass="error"/><br/>
        <input type="submit" value="Registrar" />
    </form:form>

    <h2>Login</h2>
    <form:form modelAttribute="usuario" action="/procesa/login" method="post">
        Nombre de Usuario: <form:input path="nombreUsuario" /><br/>
        Contraseña: <form:input type="password" path="contraseña" /><form:errors path="contraseña" cssClass="error"/><br/>
        <input type="submit" value="Login" />
    </form:form>
</body>
</html>
