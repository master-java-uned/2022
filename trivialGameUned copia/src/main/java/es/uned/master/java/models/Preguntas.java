package es.uned.master.java.models;


public class Preguntas {

	private int id;
	private int categoria;
	private String pregunta;
	private int correcta;
	private String[] opciones;
	
	public Preguntas(int id, int categoria, String pregunta, int correcta, String[] opciones) {
		this.id = id;
		this.categoria = categoria;
		this.pregunta = pregunta;
		this.correcta = correcta;
		this.opciones = opciones;
	}
	
	public Preguntas() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public int getCorrecta() {
		return correcta;
	}

	public void setCorrecta(int correcta) {
		this.correcta = correcta;
	}


	public String[] getOpciones() {
		return opciones;
	}

	public void setOpciones(String[] opciones) {
		this.opciones = opciones;
	}
	
	
	
}
