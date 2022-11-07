package es.uned.master.java.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.uned.master.java.modelo.Persona;

@Repository
public interface IPersona extends CrudRepository<Persona,Integer>{

}
