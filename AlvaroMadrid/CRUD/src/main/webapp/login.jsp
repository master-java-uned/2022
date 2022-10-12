<%--
  User: alvaromadrid
  JSP utilizada para entrar al portal del usuario. En caso de error, el código redirige a esta misma página.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Login</title>
    <style>
        body{
            background-color: #ffffff;
        }
        table{
            background: #a6a6a5;
            padding:10px;
            border:solid 2px #000000;
        }

        td{
            padding:5px 0;
        }
    </style>
</head>

<body>

    <h1 style="text-align:center">Login</h1>
    <p>Por favor, inserte su usuario y contraseña:</p>
    <form action="LoginUsuario" method="POST">

        <table width="25%">
            <tr>
                <td width="13%"><label for="usuario">Usuario: </label></td>
                <td width="87%"><input type="text" name="usuario" id="usuario"></td>
            </tr>
            <tr>
                <td><label for="contra">Contraseña:  </label></td>
                <td><input type="password" name="contra" id="contra"></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" name="button" id="button" value="Iniciar sesión"></td>
            </tr>
        </table>
        <p><br></p>
    </form>
</body>
</html>
