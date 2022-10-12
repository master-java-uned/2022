<%--
  User: alvaromadrid
  JSP para mostrar mensaje de éxito al cambiar la contraseña.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Portal de Usuario</title>
</head>
<body>

<%
    if(request.getSession().getAttribute("usuario") == null) {
        response.sendRedirect(request.getContextPath() + "/welcome.jsp");
    }
%>

    <h1 align="center">Contraseña modificada correctamente</h1>
    <p>Estás en el portal de usuario</p>
    <p>Elija una de las siguientes opciones:<p>
    <a href="modifica.jsp">Modifica contraseña</a><br>
    <a href="elimina.jsp">Elimina usuario</a><br>
    <a href="logout.jsp">Salir del portal</a><br>
</body>
</html>
