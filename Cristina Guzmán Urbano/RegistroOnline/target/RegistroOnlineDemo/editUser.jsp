<%@ page import="es.uned.master.java.registroonline.modelo.UsuarioDao" %>
<%@ page import="es.uned.master.java.registroonline.modelo.Usuario" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Cristina Guzmán Urbano
  Date: 23/08/2022
  Time: 18:15
  Description: Página para realizar la modificación de los datos de un usuario existente
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modificación de Usuarios Online</title>
    <link href="css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

    <form action="Controlador" method="post">
        <button type="submit" name="accion" value="Regresar" title="Regresar"><i class="fa fa-arrow-left" style="font-size:24px"></i></button>
    </form>

    <h1>Modificación de Usuario Existente</h1>

    <%
        UsuarioDao dao=new UsuarioDao();
        Usuario user = dao.getUsuarioByEmail(request.getParameter("email"));

    %>
    <div class="form-center">
        <form action="Controlador" method="post">
            <p><label>Nombre:</label> <input type="text" name="name" value="<%= user.getName()%>"></p>
            <p><label>Apellidos:</label> <input type="text" name="surname" value="<%= user.getSurname()%>"></p>
            <p><label>Email:</label> <input type="text" name="email" value="<%= user.getEmail()%>" readonly></p>
            <p><input type="submit" name="accion" value="Actualizar"></p>
        </form>
    </div>

    <p style="color: #ff0000; font-size: 20px; font-weight: bolder">${sessionScope['error']}</p>
</body>
</html>
