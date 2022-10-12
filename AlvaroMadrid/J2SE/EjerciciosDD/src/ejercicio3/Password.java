package ejercicio3;

/**
 * Clase Password
 *
 * Contiene una contraseña y una longitud
 *
 * @author Álvaro Madrid
 * @version 1.0
 */

public class Password {

    // Constantes

    /**
     * Longitud por defecto
     */

    private final static int LONG_DEF = 8;

    // Atributos

    /**
     * Longitud de la contraseña
     */
    private int longitud;

    /**
     * Caracteres de la contraseña
     */
    private String contraseña;

    // Métodos públicos

    /**
     * Devuelve la  longitud
     * @return longitud de la contraseña
     */
    public int getLongitud(){
        return longitud;
    }

    /**
     * Modifica la longitud de la contraseña
     * @param longitud a cambiar
     */
    public void setLongitud(int longitud){
        this.longitud = longitud;
    }

    /**
     * Devuelve la contraseña
     * @return contraseña
     */
    public String getContraseña(){
        return contraseña;
    }

    /**
     * Genera una contraseña al azar con la longitud que esté definida
     * @return contraseña
     */
    public String generaPassword(){
        String password = "";
        for (int i=0; i<longitud; i++){
            // Generamos un número aleatorio, según este elige si añadir una mínuscula, mayúscula o número
            int eleccion = ((int) Math.floor(Math.random()*3+1));

            if(eleccion == 1){
                char minusculas = (char)((int)Math.floor(Math.random()*(123-97)+97));
                password += minusculas;
            } else {
                if (eleccion == 2){
                    char mayusculas = (char)((int)Math.floor(Math.random()*(91-65)+65));
                    password += mayusculas;
                } else {
                    char numeros = (char)((int)Math.floor(Math.random()*(58-48)+48));
                }
            }
        }
        return password;
    }

    /**
     * Comprueba la fortaleza de la contraseá
     * @return boolean
     */
    public boolean esFuerte(){
        int cuentanumeros = 0;
        int cuentaminusculas = 0;
        int cuentamayusculas = 0;
        // Vamos caracter a caracter y comprobamos su tipo
        for (int i=0;i<contraseña.length(); i++){
            if (contraseña.charAt(i) >= 97 && contraseña.charAt(i) <= 122) {
                cuentaminusculas += 1;
            } else if (contraseña.charAt(i) >= 65 && contraseña.charAt(i) <= 90) {
                cuentamayusculas += 1;
            } else{
                cuentanumeros += 1;
            }
        }
        // Si la contraseá tiene más de 5 números, 1 minúscula y 2 mayúsculas es fuerte
        if (cuentanumeros>=5 && cuentaminusculas>=1 && cuentamayusculas>=2){
            return true;
        } else{
            return false;
        }
    }

    // Constructores
    /**
     * Crea una contraseña al azar
     */
    public Password(){
        this(LONG_DEF);
    }

    /**
     * La contraseña será la pasada por parámetro
     */
    public Password(int longitud){
        this.longitud = longitud;
        contraseña = generaPassword();
    }

}
