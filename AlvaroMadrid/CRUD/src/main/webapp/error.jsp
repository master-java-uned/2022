<%--
  User: alvaromadrid
  JSP utilizada para mostrar error a la hora de crear la cuenta.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>

<%
    if(request.getSession().getAttribute("usuario") == null) {
        response.sendRedirect(request.getContextPath() + "/welcome.jsp");
    }
%>

<h1 align="center">No ha sido posible crear su cuenta</h1>

    <p>Elija una de las siguientes opciones:<br></p>
    <a href="welcome.jsp">Registrarse</a><br>
    <a href="login.jsp">Iniciar sesión</a><br>
</body>
</html>
