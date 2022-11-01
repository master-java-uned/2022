package es.uned.master.java.interfaces;

import java.util.List;
import java.util.Optional;

import es.uned.master.java.models.ECategoria;
import es.uned.master.java.models.Jugadores;

public interface IjugadoresServices {

	public List<Jugadores>listar();
	public Optional<Jugadores>listarId(int id);
	public int save(Jugadores p);
	public void delete (int id);
	
	public Jugadores identificarJugador();
	public void marcarQuesito(Jugadores jugador,ECategoria categoria);
	public boolean esGanador();	
}
