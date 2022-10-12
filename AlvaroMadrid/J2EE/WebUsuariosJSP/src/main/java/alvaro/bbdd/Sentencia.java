package alvaro.bbdd;

public class Sentencia {

    public static String generaSentencia(String nombre, String apellido, String usuario, String contra, String pais, String tecno){
        String instruccionSql = "INSERT INTO registro_usuarios.usuarios (Nombre, Apellido, Usuario, Contrasena, Pais, Tecnologia) VALUE ('" + nombre + "','" + apellido + "','" + usuario + "','" + contra + "','" + pais + "','" + tecno + "');";
        return instruccionSql;
    }


}
