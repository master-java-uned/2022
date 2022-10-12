<%--
  User: alvaromadrid
  JSP utilizada para mostrar las opciones del portal de usuario: modificar contraseña, eliminar usuario o salir de la sesión.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Portal de usuario</title>
</head>
<body>

<%
    if(request.getSession().getAttribute("usuario") == null) {
        response.sendRedirect(request.getContextPath() + "/welcome.jsp");
    }
%>


    <p>Estás en el portal de usuario</p>
    <p>Elija una de las siguientes opciones:<p>
    <a href="modifica.jsp">Modifica contraseña</a><br>
    <a href="elimina.jsp">Elimina usuario</a><br>
    <a href="logout.jsp">Salir del portal</a><br>

</body>
</html>
