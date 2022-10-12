package uned.master.java.crud.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author alvaromadrid
 * @version 1.0.0
 * @literal Clase que define el método 'getConexion()' utilizado para conectarse a la base de datos (BD)
 * @Parameters: url (base -nombre de la BD-, user -usuario de la BD-, password -contraseña del usuario de la BD-)
 * @Return: objeto de la clase Connection
 */

public class Conexion {

    private final String base = "crud_usuarios";
    private final String user = "root";
    private final String password = "alvarodb";
    private final String url = "jdbc:mysql://localhost:3306/" + base + "?useUnicode=true&characterEncoding=utf-8";
    private Connection connection;

    /**
     * El método 'getConexion()' se utiliza para conectarse a la base de datos (BD)
     * @return objeto de la clase Connection
     */
    public Connection getConexion(){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(this.url, this.user, this.password);
        } catch(SQLException e){
            System.err.println("Error al conectar con la base de datos: " + e);
        } catch(ClassNotFoundException ex){
            System.err.println("Error: " + ex);
        }
        return connection;
    }
}