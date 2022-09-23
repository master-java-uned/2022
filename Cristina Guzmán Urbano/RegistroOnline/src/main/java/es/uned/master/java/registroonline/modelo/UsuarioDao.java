package es.uned.master.java.registroonline.modelo;
/**
 * @author: Cristina Guzman Urbano
 * @version: 03/08/2022
 * @Description: Clase que establece las consultas necesarios a la Base de datos
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao extends Dao{
    /**
     * Este método consta de dos propiedades:
     *      - PreparedStatement ps: Es una estructura que permite mantener las consultas neutras
     *      - ResultSet rs: Es un objeto que obtiene los datos de columna correspondientes a un fila
     */
    public static PreparedStatement ps;
    public static ResultSet rs;

    /**
     * Este método se encarga de consultar si el email y la contraseña pertenecen a una cuenta registrada
     * @param email se utiliza para identificar el usuario que se quiere consultar
     * @param password se utiliza para comprobar si corresponde con la contraseña registrada
     * @return
     *      - true si se encuentra un registro con ese email y esa contraseña
     *      - false si alguno de los valores o ninguno corresponde con los registrados
     */
    public boolean isAcountExists(String email, String password) {
        String sql = "SELECT * FROM usuarios WHERE email=? AND password=?";
        boolean result;
        conectar();
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();
            result = rs.next();
        } catch (SQLException e) {
            throw new RegistroExcepciones(103);
        }
        desconectar();

        return result;
    }

    /**
     * Este método se encarga de consultar si el email recibido ya está registrado
     * @param email se utiliza para identificar el usuario que se quiere consultar
     * @return
     *      - true si el email corresponde con algún registro en Base de datos
     *      - false si el email no se encuentra registrado
     */
    public boolean isEmailRegistered(String email){
        String sql = "SELECT * FROM usuarios WHERE email=?";
        boolean result;
        conectar();
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            result = rs.next();
        } catch (SQLException e) {
            throw new RegistroExcepciones(104);
        }
        desconectar();
        return result;
    }

    /**
     * Este método se encarga de insertar en Base de datos un usuario nuevo con los valores indicados
     * @param email valor para el correo electrónico
     * @param password valor de la contraseña
     * @param name valor del nombre
     * @param surname valor de los apellidos
     */
    public void insertar(String email, String password, String name, String surname){
        String sql = "INSERT INTO usuarios(email, password, name, surname) VALUES (?,?,?,?)";
        conectar();
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ps.setString(3, name);
            ps.setString(4, surname);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RegistroExcepciones(105);
        }
        desconectar();
    }

    /**
     * Este método se encarga de listar todos los usuarios existentes en la Base de datos
     * @return
     *      - Se devuelve un Objeto List<Usuario> que contiene en un listado la información de los usuarios
     *      de Base de datos
     */
    public List<Usuario> listar() {
        List<Usuario> list = new ArrayList<Usuario>();
        String sql = "SELECT  * FROM usuarios ORDER BY name";
        conectar();
        try {
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            //Bucle while para recorrer los registros de los usuarios en la bbdd
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setName(rs.getString("name"));
                u.setSurname(rs.getString("surname"));
                u.setEmail(rs.getString("email"));
                list.add(u);

            }
            rs.close();
        }  catch (SQLException e){
            throw new RegistroExcepciones(106);
        }
        desconectar();
        return list;
    }

    /**
     * Este método se encarga de obtener el usuario correspondiente al email que se indica
     * @param email se utiliza para identificar el usuario que se quiere obtener
     * @return
     *      Se devuelve un Objeto Usuario con la información existente en Base de datos
     */
    public Usuario getUsuarioByEmail(String email) {
        String sql="SELECT  * FROM usuarios WHERE email=?";
        Usuario u = new Usuario();
        conectar();
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            //Bucle while para recorrer los registros de los usuarios en la bbdd
            if (rs.next()) {
                u.setName(rs.getString("name"));
                u.setSurname(rs.getString("surname"));
                u.setEmail(rs.getString("email"));
            }
            rs.close();
        }  catch (SQLException e){
            throw new RegistroExcepciones(107);
        }
        desconectar();
        return u;
    }

    /**
     * Este método se encarga de establecer el nombre y los apellidos que reciba para el usuario con el email indicado.
     * @param user Objeto Usuario que contiene la información de nombre, usuario y email.
     */
    public void editar(Usuario user) {
        String sql="UPDATE usuarios SET name=?, surname=? WHERE email=?";
        conectar();
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());
            ps.setString(3, user.getEmail());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            throw new RegistroExcepciones(108);
        }
        desconectar();
    }

    /**
     * Este método se encarga de eliminar un registro de la Base de datos que cumpla la condición
     * @param email email del usuario que se va a eliminar
     */
    public void eliminar(String email) {
        String sql="DELETE FROM usuarios WHERE email=?";
        conectar();
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, email);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            throw new RegistroExcepciones(109);
        }
        desconectar();
    }
}
