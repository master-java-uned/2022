<%--
  User: alvaromadrid
  JSP utilizada como bienvenida. El cliente debe informar todos los campos para crear un usuario. En caso de que ya tuviera usuario, puede acceder a través del link 'Iniciar sesión'.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Bienvenida</title>
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

<h1 style="text-align:center">Registro</h1>
<p>Por favor, cumplimente todos los campos:</p>
<form action="AltaUsuario" method="POST">

    <table width="25%">
        <tr>
            <td width="13%"><label for="nombre">Nombre: </label></td>
            <td width="87%"><input type="text" name="nombre" id="nombre"></td>
        </tr>
        <tr>
            <td><label for="apellido">Apellido:  </label></td>
            <td><input type="text" name="apellido" id="apellido"></td>
        </tr>
        <tr>
            <td><label for="usuario">Usuario: </label></td>
            <td><input type="text" name="usuario" id="usuario"></td>
        </tr>
        <tr>
            <td><label for="contra">Contraseña: </label></td>
            <td><input type="password" name="contra" id="contra"></td>
        </tr>
        <tr>
            <td> <label for="interes">Campo de interés:</label></td>
            <td><select name="interes" id="interes">
                <option>Pintura</option>
                <option>Escultura</option>
                <option>Literatura</option>
                <option>Cine</option>
            </select></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" name="button" id="button" value="Registrar"></td>
        </tr>
    </table>
    <p><br>
    </p>
</form>
<a href="login.jsp">Inicia sesión</a>
</body>
</html>
