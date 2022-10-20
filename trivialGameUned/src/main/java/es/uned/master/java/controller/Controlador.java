package es.uned.master.java.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.uned.master.java.models.ECategoria;
import es.uned.master.java.models.Preguntas;
import es.uned.master.java.models.PreguntasOpciones;
import es.uned.master.java.models.Tablero;
import es.uned.master.java.repository.PreguntasOpcionesRepository;
import es.uned.master.java.repository.TableroRepository;



@Controller
@RequestMapping
public class Controlador {
	
	@Autowired
	private Ijuego service;
	private int posicionInicial=1;
	private int posicionActual=0;
	Preguntas pregunta;
	List<PreguntasOpciones> opciones;
	
	@Autowired
	TableroRepository tableroRepository;
	@Autowired
	PreguntasOpcionesRepository pregOpcRepository;
	
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
		
		Tablero tab = tableroRepository.findByCasilla(posicionActual);
		
		
		System.out.println("categoria: "+ tab.getCategoria());
		
		if(tab.getCategoria()!=ECategoria.DADO) {
			pregunta = service.getPregunta(tab.getCategoria());
			model.addAttribute("pregunta",pregunta.getPregunta());
			
			opciones = pregOpcRepository.findByPreguntaId(pregunta.getId());
			model.addAttribute("opcion1",opciones.get(0).getOpcion());
			model.addAttribute("opcion2",opciones.get(1).getOpcion());
			model.addAttribute("opcion3",opciones.get(2).getOpcion());
			model.addAttribute("opcion4",opciones.get(3).getOpcion());
		} else model.addAttribute("mensaje","TIRA DE NUEVO");
			
		
	}
	
	public int llamarDado (Model model) {
		int leerDado=service.lanzarDato();
		model.addAttribute("dado",leerDado);
		return leerDado;
	}
	
	@RequestMapping("/index")
	public void getResponse (Model model, String respuesta) {
		
		boolean correcta = service.checkRespuesta(opciones, respuesta);
		
		partida(model);
		
		if(correcta) model.addAttribute("mensaje","RESPUESTA CORRECTA");
		else model.addAttribute("mensaje","RESPUESTA INCORRECTA");
		
	}

}