package es.uned.master.java.errores;

public class SuministrosException extends RuntimeException{
    public SuministrosException(){
        super("Suministros ERROR en ejecusión.");
    }
    public SuministrosException(String err){
        super("Suministros ERROR en ejecusión: "+ err);
    }
}
