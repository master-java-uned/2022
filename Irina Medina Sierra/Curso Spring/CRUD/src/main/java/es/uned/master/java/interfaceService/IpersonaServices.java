package es.uned.master.java.interfaceService;
import java.util.List;
import java.util.Optional;

import es.uned.master.java.modelo.Persona;



public interface IpersonaServices {
	public List<Persona>listar();
	public Optional<Persona>listarId(int id);
	public int save(Persona p);
	public void delete (int id);
	

}
