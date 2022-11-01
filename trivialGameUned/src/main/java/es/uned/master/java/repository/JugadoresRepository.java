package es.uned.master.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.uned.master.java.models.Jugadores;

@Repository
public interface JugadoresRepository extends JpaRepository<Jugadores, Integer>{
	Jugadores findById(int id);
}