package es.uned.master.java.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "preguntas_opciones")
public class PreguntasOpciones {
	@Id
	private int id;
	private String opcion;
	private int correcta;
	@ManyToOne()
    @JoinColumn(name="pregunta_id")
	private Preguntas pregunta;

	public PreguntasOpciones(int id, int correcta, String opcion, int idPregunta) {
		super();
		this.id = id;
		this.opcion = opcion;
		this.correcta = correcta;
		this.pregunta = new Preguntas(idPregunta);
	}
	
	public PreguntasOpciones() {}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOpcion() {
		return opcion;
	}
	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}
	public int getCorrecta() {
		return correcta;
	}
	public void setCorrecta(int correcta) {
		this.correcta = correcta;
	}
	public Preguntas getPregunta() {
		return pregunta;
	}
	public void setPregunta(Preguntas pregunta) {
		this.pregunta = pregunta;
	}
	
}
