package es.uned.master.java.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name = "preguntas")
public class Preguntas {
	
	@Id
	private int id;
	@Enumerated(EnumType.ORDINAL)
	private ECategoria categoria;
	@NotBlank
	private String pregunta;
	@OneToMany(mappedBy="pregunta")
	private List<PreguntasOpciones> opciones;
	@Column(nullable=false, columnDefinition="boolean default false")
	private boolean utilizada;

	public Preguntas(int id, ECategoria categoria, String pregunta, List<PreguntasOpciones> opciones) {
		this.id = id;
		this.categoria = categoria;
		this.pregunta = pregunta;
		this.opciones = opciones;
	}
	
	public Preguntas() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ECategoria getCategoria() {
		return categoria;
	}

	public void setCategoria(ECategoria categoria) {
		this.categoria = categoria;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public List<PreguntasOpciones> getOpciones() {
		return opciones;
	}

	public void setOpciones(List<PreguntasOpciones> opciones) {
		this.opciones = opciones;
	}
	
	public boolean isUtilizada() {
		return utilizada;
	}

	public void setUtilizada(boolean utilizada) {
		this.utilizada = utilizada;
	}
	
}
