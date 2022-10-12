package practica.modelo;

import java.sql.*;

public class Conexion {

    Connection miConexion = null;

    public Conexion() {}

    public Connection dameConexion() {

        try {
            miConexion = DriverManager.getConnection("jdbc:mariadb://localhost:3306/curso_sql", "root", "");
        } catch (Exception e) { System.out.println("No ha sido posible conectarse con la base de datos");}

        return miConexion;
    }
}
