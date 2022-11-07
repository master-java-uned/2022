package es.uned.master.java.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uned.master.java.model.Persona;

public interface iPersonaRepo extends JpaRepository<Persona,Integer>{
	

}
