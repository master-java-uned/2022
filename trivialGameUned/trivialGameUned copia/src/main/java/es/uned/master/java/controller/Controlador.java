package es.uned.master.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.uned.master.java.models.Casilla;



@Controller

public class Controlador {
	
	@Autowired
	private Ijuego service;
	private int posicionActual;
	private boolean comienzoPartida=false;
	
//Partimos que el Jugador sale de la casilla 1, por lo que el primer dado indica la posición de Salida

	@GetMapping("/index")
	public void partida (Model model) {
		if (!comienzoPartida) {
			posicionActual=1;
			comienzoPartida=true;
			model.addAttribute("dado",0);
			model.addAttribute("posicionActual",posicionActual);
			
		}
		else {
			//llamamos al dado
			int dado=llamarDado(model);	
			model.addAttribute("posicionActual",posicionActual);
			// muestra la posiciones propuestas
			mostrarOpciones(model,dado,posicionActual);
			
			
		}	
		
			
		//muestra la posicion  Actual
		
		//actualiza la posicion actual	
			
	}

	public int llamarDado (Model model) {
		int leerDado=service.lanzarDato();
		model.addAttribute("dado",leerDado);
		return leerDado;
		
	}

	
	public void mostrarOpciones(Model model,int dado,int posicionActual2) {
				// muestra la posicion propuesta 1	
				int posicion1=service.posicionesPropuestas1(posicionActual2,dado);
				model.addAttribute("posicion1",posicion1);
				//muestra la posicion propuesta 2
				int posicion2=service.posicionesPropuestas2(posicionActual2,dado);
				model.addAttribute("posicion2",posicion2);
					
	}
	
	
		public void seleccionarOpcion(Model model) {
		int posicion=service.nuevaPosicion();
		model.addAttribute("posicionActual",posicion);
		System.out.println(posicionActual);	
		
	}
	
	
	
	
}