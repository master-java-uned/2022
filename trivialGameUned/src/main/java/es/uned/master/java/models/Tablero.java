package es.uned.master.java.models;

import javax.persistence.Column;
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
	@Enumerated(EnumType.ORDINAL)
	private ECategoria categoria;
	private boolean quesito;
	
	public Tablero(int casilla, int categoria, boolean quesito) {
		this.casilla = casilla;
		this.categoria = ECategoria.fromId(categoria);
		this.quesito = quesito;
	}
	
	public Tablero() {}
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
	public boolean isQuesito() {
		return quesito;
	}
	public void setQuesito(boolean quesito) {
		this.quesito = quesito;
	}
	
}
