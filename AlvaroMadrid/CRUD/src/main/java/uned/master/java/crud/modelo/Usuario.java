package uned.master.java.crud.modelo;

/**
 * @author alvaromadrid
 * @version 1.0.0
 * @Description: Clase que contiene la información sobre el Usuario (nombre, apellido, usuario, contraseña y su ámbito de interés en el arte).
 * @return objeto de la clase Usuario
 */

public class Usuario {

    private String nombre;
    private String apellido;
    private String usuario;
    private String contrasena;
    private String interes;

    /**
     * Métodos constructores de la clase Usuario (sobrecarga de métodos)
     * @param nombre
     * @param apellido
     * @param usuario
     * @param contrasena
     * @param interes
     */
    public Usuario(String nombre, String apellido, String usuario, String contrasena, String interes) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.interes = interes;
    }

    public Usuario(){

    }

    /**
     * Métodos getters y setters de los atributos de clase
     * @return String / void
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getInteres() {
        return interes;
    }

    public void setInteres(String interes) {
        this.interes = interes;
    }

}
