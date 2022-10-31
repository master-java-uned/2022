package es.uned.master.java.models;

public class Tablero {
	
	private int casilla;
	public Tablero(int casilla, int categoria) {
		this.casilla = casilla;
		this.categoria = categoria;
	}
	private int categoria;
	public int getCasilla() {
		return casilla;
	}
	public void setCasilla(int casilla) {
		this.casilla = casilla;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	
}
