package es.uned.master.java.registroonline.modelo;
/**
 * @author: Cristina Guzman Urbano
 * @version: 03/08/2022
 * @Description: Clase que establece los parámetros necesarios para realizar la conexion con MySQL
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {
    /**
     * Esta clase consta de las siguientes propiedades:
     *      - Connection conexion: Este Objeto se utiliza para manejar la conexión a la Base de datos
     *      - String userDb: Valor por defecto del usuario de la conexión
     *      - String passDb: Valor por defecto de la contraseña de la conexión
     */
    public Connection conexion;
    public final static String userDb = "uned";
    public final static String passDb = "uned";

    /**
     * Este método realiza la conexión a la Base de datos con el driver correspondiente
     */
    public void conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/LoginOnline",userDb, passDb);
        } catch (ClassNotFoundException e) {
            throw new RegistroExcepciones(100);
        } catch (SQLException e) {
            throw new RegistroExcepciones(101);
        }
    }

    /**
     * Este método realiza la desconexión a la Base de datos
     */
    public void desconectar() {
        try {
            conexion.close();
        } catch (SQLException e) {
            throw new RegistroExcepciones(102);
        }
    }


}
