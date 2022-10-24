package es.uned.master.java.controller;

import java.util.List;

import es.uned.master.java.models.ECategoria;
import es.uned.master.java.models.Preguntas;
import es.uned.master.java.models.PreguntasOpciones;

public interface Ijuego {

	public int  identificarJugador(int id);
	public int posicionesPropuestas1(int posicionActual,int dado);
	public int posicionesPropuestas2(int posicionActual,int dado);
	public int  lanzarDato();
	public int  leerCasilla(int casilla, int categoria);
	public int  pregunta(int idPregunta,String Pregunta,String opcion1,String opcion2,String opcion3,String opcion4, String Correcta);
	public Preguntas getPregunta(ECategoria categoria);
	public boolean checkRespuesta(List<PreguntasOpciones> opciones, int respuesta);
	//public List<String> getOpciones(int idPregunta);
}
