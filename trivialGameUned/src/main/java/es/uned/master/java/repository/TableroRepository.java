package es.uned.master.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.uned.master.java.models.Tablero;

@Repository
public interface TableroRepository extends JpaRepository<Tablero, Integer>{
	Tablero findByCasilla(int casilla);
}