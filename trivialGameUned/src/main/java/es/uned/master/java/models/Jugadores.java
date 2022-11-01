package es.uned.master.java.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="jugadores")
public class Jugadores implements Serializable  {
		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		private String nombre;
		private String email;
	
		private String avatar;
		
		@Column(nullable=false, columnDefinition="boolean default false")
		private boolean quesito_morado;
		@Column(nullable=false, columnDefinition="boolean default false")
		private boolean quesito_naranja;
		@Column(nullable=false, columnDefinition="boolean default false")
		private boolean quesito_azul;
		@Column(nullable=false, columnDefinition="boolean default false")
		private boolean quesito_verde;
		@Column(nullable=false, columnDefinition="boolean default false")
		private boolean quesito_rosa;
		@Column(nullable=false, columnDefinition="boolean default false")
		private boolean quesito_amarillo;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
	
		public String getAvatar() {
			return "images/SVG/Users2_"+avatar+".svg";
		}
		public void setAvatar(String avatar) {
			this.avatar = avatar;
		}
		public boolean isQuesito_morado() {
			return quesito_morado;
		}
		public void setQuesito_morado(boolean quesito_morado) {
			this.quesito_morado = quesito_morado;
		}
		public boolean isQuesito_naranja() {
			return quesito_naranja;
		}
		public void setQuesito_naranja(boolean quesito_naranja) {
			this.quesito_naranja = quesito_naranja;
		}
		public boolean isQuesito_azul() {
			return quesito_azul;
		}
		public void setQuesito_azul(boolean quesito_azul) {
			this.quesito_azul = quesito_azul;
		}
		public boolean isQuesito_verde() {
			return quesito_verde;
		}
		public void setQuesito_verde(boolean quesito_verde) {
			this.quesito_verde = quesito_verde;
		}
		public boolean isQuesito_rosa() {
			return quesito_rosa;
		}
		public void setQuesito_rosa(boolean quesito_rosa) {
			this.quesito_rosa = quesito_rosa;
		}
		public boolean isQuesito_amarillo() {
			return quesito_amarillo;
		}
		public void setQuesito_amarillo(boolean quesito_amarillo) {
			this.quesito_amarillo = quesito_amarillo;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		
		public Jugadores(int id, String nombre, String email,  String avatar) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.email = email;
			
			this.avatar = avatar;
			
		}
		
		public Jugadores() {
			super();
		}
		
}
