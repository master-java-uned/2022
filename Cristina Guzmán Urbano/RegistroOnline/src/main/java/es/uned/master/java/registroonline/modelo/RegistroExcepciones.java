package es.uned.master.java.registroonline.modelo;

/**
 * @author: Cristina Guzman Urbano
 * @version: 01/09/2022
 * @Description: Clase que se encarga de gestionar las excepciones
 */
public class RegistroExcepciones extends RuntimeException{

    private int codigoError;

    public RegistroExcepciones(){
        super("RegistroOnline Exception\n\t");
    }
    public RegistroExcepciones(int codigoError){
        super();
        this.codigoError=codigoError;

    }

    @Override
    public String getMessage(){

        String mensaje="";

        switch(codigoError){
            case 1:
                mensaje="Error " + codigoError + ": ServletException : No se pudo cargar la pagina de inicio";
                break;
            case 2:
                mensaje="Error " + codigoError + ": IOException : No se pudo cargar la pagina de inicio";
                break;
            case 3:
                mensaje="Error " + codigoError + ": ServletException : No se pudo cargar la pagina de listado de usuarios";
                break;
            case 4:
                mensaje="Error " + codigoError + ": IOException : No se pudo cargar la pagina de listado de usuarios";
                break;
            case 5:
                mensaje="Error " + codigoError + ": ServletException : No se pudo cargar la pagina de registro de usuarios";
                break;
            case 6:
                mensaje="Error " + codigoError + ": IOException : No se pudo cargar la pagina de registro de usuarios";
                break;
            case 7:
                mensaje="Error " + codigoError + ": ServletException : No se pudo invocar el filtro correctamente";
                break;
            case 8:
                mensaje="Error " + codigoError + ": IOException : No se pudo invocar el filtro correctamente";
                break;
            case 100:
                mensaje="Error " + codigoError + ": ClassNotFoundException : No se pudo realizar la conexión a la Base de datos";
                break;
            case 101:
                mensaje="Error " + codigoError + ": SQLException : No se pudo realizar la conexión a la Base de datos";
                break;
            case 102:
                mensaje="Error " + codigoError + ": SQLException : No se pudo realizar la desconexión a la Base de datos";
                break;
            case 103:
                mensaje="Error " + codigoError + ": SQLException : No se pudo realizar la consulta";
                break;
            case 104:
                mensaje="Error " + codigoError + ": SQLException : No se pudo realizar la consulta";
                break;
            case 105:
                mensaje="Error " + codigoError + ": SQLException : No se pudo realizar la inserción";
                break;
            case 106:
                mensaje="Error " + codigoError + ": SQLException : No se pudo realizar la consulta";
                break;
            case 107:
                mensaje="Error " + codigoError + ": SQLException : No se pudo realizar la consulta";
                break;
            case 108:
                mensaje="Error " + codigoError + ": SQLException : No se pudo realizar la modificación";
                break;
            case 109:
                mensaje="Error " + codigoError + ": SQLException : No se pudo realizar la eliminación";
                break;
        }

        return mensaje;
    }
}
