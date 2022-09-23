<%--
  Created by IntelliJ IDEA.
  User: Cristina Guzmán Urbano
  Date: 03/08/2022
  Time: 21:08
  Description: Página donde se inicia la sesión con el correo y la contraseña y se redirige a la página
  de registro de nuevo usuario
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login de Usuarios Online</title>
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
<h1>Iniciar sesión</h1>

<div class="form-center">
    <form action="Login" method="post">
        <p><label>Email:</label> <input type="text" name="email"></p>
        <p><label>Contraseña:</label> <input type="password" name="password"></p>
        <p><input type="submit" value="Entrar"></p>
    </form>
</div>

<p>Si no esta registrado, puede hacerlo pulsando <a href="register.jsp">aqui</a></p>

<p style="color: #ff0000; font-size: 20px; font-weight: bolder">${sessionScope['error']}</p>
</body>
</html>
