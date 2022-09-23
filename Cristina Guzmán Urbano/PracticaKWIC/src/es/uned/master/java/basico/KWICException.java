package es.uned.master.java.basico;

public class KWICException extends RuntimeException {
	//Se captura el error y se notifica 
	public KWICException(){
		super("Error");
	}
	
	//Se captura el error y se notifica el mensaje que se especifica
	public KWICException(String msg){
		super("Error: "+msg);
	}
}
