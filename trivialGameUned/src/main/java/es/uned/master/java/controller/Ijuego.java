package es.uned.master.java.controller;


public interface Ijuego {

	public int  identificarJugador(int id);
	public int posicionesPropuestas1(int posicionActual,int dado);
	public int posicionesPropuestas2(int posicionActual,int dado);
	public int  lanzarDato();
	public int  leerCasilla(int casilla, int categoria);
	public int  pregunta(int idPregunta,String Pregunta,String opcion1,String opcion2,String opcion3,String opcion4, String Correcta);
	
}
