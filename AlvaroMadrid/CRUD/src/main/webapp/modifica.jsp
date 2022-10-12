<%--
  User: alvaromadrid
  JPS utilizada para modificar la contraseña. El cliente debe introducir la nueva contraseña.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modificar Contraseña</title>
</head>
<body>

<%
    if(request.getSession().getAttribute("usuario") == null) {
        response.sendRedirect(request.getContextPath() + "/welcome.jsp");
    }
%>

Por favor, introduzca su nueva contraseña:
<form action="ModificaUsuario" method="POST">

    <table width="25%">
        <tr>
            <td><label for="contra">Contraseña:  </label></td>
            <td><input type="password" name="contra" id="contra"></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" name="button" id="button" value="Modificar Contraseña"></td>
        </tr>
    </table>
    <p><br>
    </p>
</form>
</body>
</html>
