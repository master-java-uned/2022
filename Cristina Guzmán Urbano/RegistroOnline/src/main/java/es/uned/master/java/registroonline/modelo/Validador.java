package es.uned.master.java.registroonline.modelo;
/**
 * @author: Cristina Guzman Urbano
 * @version: 03/08/2022
 * @Description: Clase que realiza las comprobaciones de formato a las contraseñas y los correos electrónicos
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validador {
    /**
     * Este método se encarga de comprobar si el formato de contraseña introducido cumple las normas establecidas.
     * @param password cadena que se va a analizar
     * @return
     *      -true si la contraseña tiene un formato válido
     *      -false si la contraseña tiene un formato incorrecto
     *
     */
    public boolean isPasswordValid(String password) {

        /*
         * La contraseña debe tener entre 6 y 16 caracteres,
         * al menos un dígito, al menos una minúscula y al menos una mayúscula.
         * NO puede tener otros símbolos.
         */

        Pattern p = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d].{6,16}$");
        Matcher m = p.matcher(password);

        return m.find();
    }

    /**
     * Este método se encarga de comprobar si el formato de email introducido cumple las normas estándares.
     * @param email cadena que se va a analizar
     * @return
     *      -true si el email tiene un formato válido
     *      -false si el email tiene un formato incorrecto
     */
    public boolean isEmailValid(String email) {

        Pattern p = Pattern.compile("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?!-)(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");
        Matcher m = p.matcher(email);
        return m.find();
    }
}
