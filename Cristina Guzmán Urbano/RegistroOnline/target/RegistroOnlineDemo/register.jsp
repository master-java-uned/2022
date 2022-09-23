<%--
  Created by IntelliJ IDEA.
  User: Cristina Guzmán Urbano
  Date: 03/08/2022
  Time: 21:15
  Description: Página donde se registra un nuevo usuario a la bbdd
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registro de Usuarios Online</title>
    <link href="css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
    <form action="Registro" method="post">
        <button type="submit" name="accion" value="Regresar" title="Regresar"><i class="fa fa-arrow-left" style="font-size:24px"></i></button>
    </form>

    <h1>Registro de Usuario Nuevo</h1>

    <div class="form-center">
        <form action="Registro" method="post">
            <p><label>Nombre:</label> <input type="text" name="name"></p>
            <p><label>Apellidos:</label> <input type="text" name="surname"></p>
            <p><label>Email:</label> <input type="text" name="email"></p>
            <p><label>Contraseña:</label> <input type="password" name="password1"></p>
            <p><label>Confirma contraseña:</label> <input type="password" name="password2"></p>
            <p><input type="submit" name="accion" value="Insertar"></p>
        </form>
    </div>

    <p style="color: #ff0000; font-size: 20px; font-weight: bolder">${sessionScope['error']}</p>
</body>
</html>
