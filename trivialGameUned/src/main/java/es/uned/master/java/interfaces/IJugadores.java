package es.uned.master.java.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.uned.master.java.models.Jugadores;



@Repository
public interface IJugadores extends CrudRepository<Jugadores,Integer>{
	
	

}
