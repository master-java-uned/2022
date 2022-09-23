<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="es.uned.master.java.registroonline.modelo.Usuario" %>
<%@ page import="es.uned.master.java.registroonline.modelo.UsuarioDao" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%--
  Created by IntelliJ IDEA.
  User: Cristina Guzmán Urbano
  Date: 07/08/2022
  Time: 20:16
  Description: Página donde se lista la información de todos los usuarios registrados
--%>
<html>
<head>
    <title>Listado Usuarios Registrados</title>
    <link href="css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
    <form action="Logout" method="post">
        <button type="submit" title="Logout"><i class="fa fa-sign-out" style="font-size:24px"></i></button>
    </form>

    <table class="cinereousTable">
        <thead>
        <tr>
            <th>Nombre</th>
            <th>Apellidos</th>
            <th>Email</th>
            <th>Opciones</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="usuario" items="${listUsers}">
            <tr>
                <td><c:out value="${usuario.name}"/></td>
                <td><c:out value="${usuario.surname}"/></td>
                <td><c:out value="${usuario.email}"/></td>
                <td>
                    <form action="editUser.jsp">
                        <input type="hidden" name="email" value=${usuario.email} />
                        <button type="submit" title="Editar usuario"><i class="fa fa-edit" style="font-size:24px"></i></button>
                    </form>
                    <form action="Controlador" method="post">
                        <input type="hidden" name="email" value=${usuario.email} />
                        <button type="submit" name="accion" value="Eliminar" title="Borrar usuario"><i class="fa fa-trash" style="font-size:24px"></i></button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>

    </table>

    <form action="register.jsp">
        <button type="submit" class="cinereousButton" title="Insertar usuario nuevo"><i class="fa fa-plus" style="font-size:24px"></i></button>
    </form>

</body>
</html>
