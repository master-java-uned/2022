package es.uned.master.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping
public class Controlador {
	
	@Autowired
	private Ijuego service;
	private int posicionInicial=1;
	private int posicionActual=0;
	
//Partimos que el Jugador sale de la casilla 1, por lo que el primer dado indica la posición de Salida
	
	@GetMapping("/index")
	public void partida (Model model) {
		
			//muestra la posicion  Actual
				 posicionActual++;
				 model.addAttribute("posicionActual",posicionActual);
		
		
		//llamamos al dado
		int dado=llamarDado(model);		
		
		// muestra la posicion propuesta 1	
		int posicion1=service.posicionesPropuestas1(posicionActual,dado);
		model.addAttribute("posicion1",posicion1);
		
		//muestra la posicion propuesta 2
		int posicion2=service.posicionesPropuestas2(posicionActual,dado);
		model.addAttribute("posicion2",posicion2);
		
		//lee la seleccion
		/*******Falta *********/
		//actualiza la posicion actual	Pongo un ejemplo de seleccionar la posicion2
		/*******Falta *********/
		
		//int posicionActual=service.leerCasilla(posicionInicial, nuevaPosicion);
			
		
	}
	
	public int llamarDado (Model model) {
		int leerDado=service.lanzarDato();
		model.addAttribute("dado",leerDado);
		return leerDado;
	}

}