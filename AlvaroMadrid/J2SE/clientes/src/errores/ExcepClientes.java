package errores;

public class ExcepClientes extends RuntimeException{

    public ExcepClientes(){
        super("Error al procesar el fichero");
    }

    public ExcepClientes(String err){
        super("Error al procesar el fichero: " + err);
    }

}
