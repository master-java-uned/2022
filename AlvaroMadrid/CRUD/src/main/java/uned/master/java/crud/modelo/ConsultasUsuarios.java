package uned.master.java.crud.modelo;

import java.sql.*;

/**
 * @author alvaromadrid
 * @version 1.0.0
 * @Description: Clase que define los diferentes métodos para realizar consultas a la base de datos (BD)
 * @Return: objeto de la clase Connection
 * @Extends: hereda de la clase Conexion, para utilizar el método 'getConexion()'
 */

public class ConsultasUsuarios extends Conexion{

    /**
     * El método 'registraUsuario()' utiliza un objeto de tipo 'PreparedStatement' para crear un usuario en la BD.
     * @param user
     * @return booleano para evaluar si el usuario se ha registrado correctamente
     */
    public boolean registraUsuario(Usuario user){
        PreparedStatement preparedStatement = null;
        Connection connection = getConexion();

        String INSERT_USER_SQL = "INSERT INTO crud_usuarios.usuarios VALUES (?,?,?,?,?)";

        try{
            preparedStatement = connection.prepareStatement(INSERT_USER_SQL);
            preparedStatement.setString(1, user.getNombre());
            preparedStatement.setString(2, user.getApellido());
            preparedStatement.setString(3, user.getUsuario());
            preparedStatement.setString(4, user.getContrasena());
            preparedStatement.setString(5, user.getInteres());
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e){
            System.err.println(e);
            return false;
        } finally{
            try{
                preparedStatement.close();
                connection.close();
            } catch(SQLException e) {
                System.err.println("No se pudo cerrar la conexión: " + e);
            }
        }
    }

    /**
     * El método 'existeUsuario()' utiliza un objeto de tipo 'PreparedStatement' para comprobar si el usuario existe en la BD.
     * @param user
     * @return String con el número de veces que el usuario consultado existe en la BD. Valor 1 significa que el usuario se encuentra en la BD, distinto de 1 indica que el usuario no está contemplado en la BD.
     */
    public String existeUsuario(Usuario user){
        PreparedStatement preparedStatement = null;
        Connection connection = getConexion();

        String SELECT_USER_SQL = "SELECT COUNT(*) FROM crud_usuarios.usuarios WHERE Usuario=? AND Contrasena=?";
        String result = null;

        try{
            preparedStatement = connection.prepareStatement(SELECT_USER_SQL);
            preparedStatement.setString(1, user.getUsuario());
            preparedStatement.setString(2, user.getContrasena());
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                result = resultSet.getString(1);
            }
            return result;
        } catch (SQLException e){
            System.err.println("No existe usuario: " + e);
            return null;
        } finally {
            try{
                preparedStatement.close();
                connection.close();
            } catch(SQLException e){
                System.err.println("No se puedo cerrar la conexión: " + e);
            }
        }
    }

    /**
     * El método 'modificaUsuario()' utiliza un objeto de tipo 'PreparedStatement' para modificar la contraseña de un usuario en la BD.
     * @param user
     * @return booleano para evaluar si la contraseña se ha modificado correctamente
     */
    public boolean modificaUsuario(Usuario user){
        PreparedStatement preparedStatement = null;
        Connection connection = getConexion();

        String UPDATE_USER_SQL = "UPDATE crud_usuarios.usuarios SET Contrasena=? WHERE Usuario=?";

        try{
            preparedStatement = connection.prepareStatement(UPDATE_USER_SQL);
            preparedStatement.setString(1, user.getContrasena());
            preparedStatement.setString(2, user.getUsuario());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e){
            System.err.println("No se pudo cambiar la contraseña: " + e);
            return false;
        } finally {
            try{
                preparedStatement.close();
                connection.close();
            } catch(SQLException e){
                System.err.println("No se puedo cerrar la conexión: " + e);
            }
        }
    }

    /**
     * El método 'eliminaUsuario()' utiliza un objeto de tipo 'PreparedStatement' para eliminar un usuario en la BD.
     * @param user
     * @return booleano para evaluar si el usuario se ha eliminado correctamente
     */
    public boolean eliminaUsuario(Usuario user){
        PreparedStatement preparedStatement = null;
        Connection connection = getConexion();

        String DELETE_USER_SQL = "DELETE FROM crud_usuarios.usuarios WHERE Usuario=? AND Contrasena=?";
        String result = null;

        try{
            preparedStatement = connection.prepareStatement(DELETE_USER_SQL);
            preparedStatement.setString(1, user.getUsuario());
            preparedStatement.setString(2, user.getContrasena());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e){
            System.err.println("No se pudo eliminar el usuario: " + e);
            return false;
        } finally {
            try{
                preparedStatement.close();
                connection.close();
            } catch(SQLException e){
                System.err.println("No se puedo cerrar la conexión: " + e);
            }
        }
    }

}