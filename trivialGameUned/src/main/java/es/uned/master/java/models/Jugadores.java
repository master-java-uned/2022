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
