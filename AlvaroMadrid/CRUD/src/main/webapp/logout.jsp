<%--
  User: alvaromadrid
  JSP para salir de la sesión. Una vez la sesión se termina, se redirige a la página de bienvenida.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Salir</title>
</head>
<body>
<%
    if(request.getSession().getAttribute("usuario") == null) {
        response.sendRedirect(request.getContextPath() + "/welcome.jsp");
    } else {
        session.invalidate();
    }
%>

<h1 align="center">Sesión cerrada</h1>
    <p>Elija una de las siguientes opciones:<br></p>
    <a href="welcome.jsp">Registrarse</a><br>
    <a href="login.jsp">Iniciar sesión</a><br>
</body>
</html>
