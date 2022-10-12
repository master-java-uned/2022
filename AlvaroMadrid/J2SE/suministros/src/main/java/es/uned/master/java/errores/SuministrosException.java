package es.uned.master.java.errores;

// Creamos una clase para gestionar los Excepcion
public class SuministrosException extends RuntimeException{
    // Nuestra clase SuministrosException 'hereda' de RuntimeException
    // Constructor genérico:
    public SuministrosException(){
        super("Suministros ERROR en ejecución.");
    }
    // Constructor de un mensaje específico:
    public SuministrosException(String err){
        super("Suministros ERROR en ejecución: "+ err);
    }
}
