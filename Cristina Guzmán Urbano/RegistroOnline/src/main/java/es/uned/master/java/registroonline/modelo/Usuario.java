package es.uned.master.java.registroonline.modelo;
/**
 * @author: Cristina Guzman Urbano
 * @version: 03/08/2022
 * @Description: Clase que define el objeto Usuario
 */

public class Usuario extends Dao{
    /**
     * Esta clase consta de las siguientes propiedades:
     *      - String name: Cadena que contiene el nombre del Usuario
     *      - String surname: Cadena que contiene los apellidos del Usuario
     *      - String email: Cadena que contiene el email del Usuario
     */
    public String name;
    public String surname;
    public String email;

    /**
     * Este método es el constructor vacío del Objeto
     */
    public Usuario(){}

    /**
     * Este método es el constructor que inicializa el objeto con los valores indicados
     * @param name establece el valor de name
     * @param surname establece el valor de surname
     * @param email establece el valor de email
     */
    public Usuario(String name, String surname, String email){
        setName(name);
        setSurname(surname);
        setEmail(email);
    }

    /**
     * Getters y Setter de las propiedades
     */

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}