<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Comprueba Usuario</title>
</head>
<body>
<%@ page import="alvaro.bbdd.Sentencia" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>

<%
    String usuario = request.getParameter("usuario");
    String contra = request.getParameter("contra");

    try{
        Connection connection = java.sql.DriverManager.getConnection("jdbc:mariadb://localhost:3306/registro_usuarios", "root", "root");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM registro_usuarios.usuarios WHERE Usuario=? AND Contrasena=?;");
        preparedStatement.setString(1, usuario);
        preparedStatement.setString(2, contra);

        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.absolute(1)) out.println("Usuario autorizado");
        else out.println("Usuario no autorizado");

    }catch(Exception e){
        out.println("Ha habido un error en su conexión");
    }

%>

</body>
</html>
