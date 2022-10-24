package es.uned.master.java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.uned.master.java.models.PreguntasOpciones;

@Repository
public interface PreguntasOpcionesRepository extends JpaRepository<PreguntasOpciones, Integer>{
	
	List<PreguntasOpciones> findByPreguntaId(int pregunta_id);
}