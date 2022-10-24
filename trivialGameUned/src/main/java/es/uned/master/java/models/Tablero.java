package es.uned.master.java.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tablero")
public class Tablero {
	
	@Id
	private int casilla;
	public Tablero(int casilla, ECategoria categoria) {
		this.casilla = casilla;
		this.categoria = categoria;
	}
	public Tablero() {};
	@Enumerated(EnumType.ORDINAL)
	private ECategoria categoria;
	public int getCasilla() {
		return casilla;
	}
	public void setCasilla(int casilla) {
		this.casilla = casilla;
	}
	public ECategoria getCategoria() {
		return categoria;
	}
	public void setCategoria(ECategoria categoria) {
		this.categoria = categoria;
	}
	
}
