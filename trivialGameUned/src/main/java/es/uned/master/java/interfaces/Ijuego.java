package es.uned.master.java.interfaces;

import java.util.List;
import java.util.Optional;


import es.uned.master.java.models.ECategoria;
import es.uned.master.java.models.Jugadores;
import es.uned.master.java.models.Preguntas;
import es.uned.master.java.models.PreguntasOpciones;

public interface Ijuego {

	public int identificarJugador(int id);
	public int posicionesPropuestas1(int posicionActual,int dado);
	public int posicionesPropuestas2(int posicionActual,int dado);
	public int  lanzarDato();
	public int  leerCasilla(int casilla, int categoria);
	public Preguntas getPregunta(ECategoria categoria);
	public boolean checkRespuesta(List<PreguntasOpciones> opciones, int respuesta);
	

}
