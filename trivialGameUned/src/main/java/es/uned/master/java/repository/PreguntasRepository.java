package es.uned.master.java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import es.uned.master.java.models.ECategoria;
import es.uned.master.java.models.Preguntas;
import es.uned.master.java.models.Tablero;

@Repository
public interface PreguntasRepository extends JpaRepository<Preguntas, Integer>{
	Preguntas findById(int id);
	List<Preguntas> findAllByCategoria(ECategoria categoria);
}
