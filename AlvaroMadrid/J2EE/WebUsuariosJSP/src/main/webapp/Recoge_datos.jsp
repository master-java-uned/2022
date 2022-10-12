<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Recoge Datos</title>
</head>
<body>

<%@ page import="alvaro.bbdd.Sentencia" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>

<%
    String nombre = request.getParameter("nombre");
    String apellido = request.getParameter("apellido");
    String usuario = request.getParameter("usuario");
    String contra = request.getParameter("contra");
    String pais = request.getParameter("pais");
    String tecno = request.getParameter("tecnologias");

    try{
        Connection connection = java.sql.DriverManager.getConnection("jdbc:mariadb://localhost:3306/registro_usuarios", "root", "root");
        Statement statement1 = connection.createStatement();
        String instruccionSql = Sentencia.generaSentencia(nombre, apellido, usuario, contra, pais, tecno);
        statement1.executeUpdate(instruccionSql);

        out.println("Registrado con éxito");
    }catch(Exception e){
        out.println("Ha habido un error relacionado con la base de datos: " + e);
    }

%>

</body>
</html>
