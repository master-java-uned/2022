<%--
  User: alvaromadrid
  JSP utilizada para eliminar la cuenta. El usuario debe reconfirmar su contraseña.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Eliminar usuario</title>
</head>
<body>

<%
    if(request.getSession().getAttribute("usuario") == null) {
        response.sendRedirect(request.getContextPath() + "/welcome.jsp");
    }
%>

<form action="EliminaUsuario" method="POST">
    <p>Por favor, confirme la eliminación de su cuenta introduciendo la contraseña:</p>
    <table width="25%">
        <tr>
            <td><label for="contra">Contraseña:  </label></td>
            <td><input type="password" name="contra" id="contra"></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" name="button" id="button" value="Eliminar cuenta"></td>
        </tr>
    </table>
    <p><br>
    </p>
</form>
</body>
</html>
