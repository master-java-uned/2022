package es.uned.master.java.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import es.uned.master.java.interfaces.Ijuego;
import es.uned.master.java.models.Casilla;
import es.uned.master.java.models.ECategoria;
import es.uned.master.java.models.Jugadores;
import es.uned.master.java.models.Preguntas;
import es.uned.master.java.models.PreguntasOpciones;
import es.uned.master.java.models.Tablero;
import es.uned.master.java.repository.PreguntasOpcionesRepository;
import es.uned.master.java.repository.TableroRepository;



@Controller
public class Controlador {
	
	@Autowired
	private Ijuego service;
	//private int posicionInicial=1;
	private int posicionActual=0;
	Preguntas pregunta;
	List<PreguntasOpciones> opciones;
	Casilla nuevaCasilla;
	Boolean nuevoJuego=true;
	int dado;
	@Autowired
	TableroRepository tableroRepository;
	@Autowired
	PreguntasOpcionesRepository pregOpcRepository;
	int partida=0;
	int posicion=0;

	
//Partimos que el Jugador sale de la casilla 1, por lo que el primer dado indica la posición de Salida
	
	@RequestMapping("/index")
	public void partida (Model model) {
		//muestra la posicion  Actual
		
		
		
		if (nuevoJuego) {
		posicionActual=1;
		dado=0;
		partida++;
		model.addAttribute("nuevoJuego", nuevoJuego);
		model.addAttribute("dado",dado);
		model.addAttribute("posicionActual",posicionActual);
		model.addAttribute("mensaje","LANZA EL DADO PARA JUGAR COMENZAR EL JUEGO");
		nuevoJuego=false;
		}else {
	    
	    
	    
	   
			
		//llamamos al dado
		dado=llamarDado(model);	
		model.addAttribute("dado",dado);
		model.addAttribute("posicionActual",posicionActual);
		// muestra la posicion propuesta 1	
		int posicion1=service.posicionesPropuestas1(posicionActual,dado);
		model.addAttribute("posicion1",posicion1);
		
		//muestra la posicion propuesta 2
		int posicion2=service.posicionesPropuestas2(posicionActual,dado);
		model.addAttribute("posicion2",posicion2);
		
		
		}
		}
		
	
	@PostMapping("/index")
	public void nuevaCasilla(@RequestParam("posicion") int casilla,Model model) {
	posicionActual=casilla;
	model.addAttribute("posicionActual",posicionActual);
	
	if (partida>=1) {
	//busca en la bbdd la posicion actual para realizar la pregunta
	Tablero tab = tableroRepository.findByCasilla(posicionActual);
	
	System.out.println("categoria: "+ tab.getCategoria());
	//se incluye condicion temporal para categoria Marvel y Disney
	if(tab.getCategoria()!=ECategoria.DADO) {
		try {
			pregunta = service.getPregunta(tab.getCategoria());
		if(pregunta != null) {
			partida++;
			
			model.addAttribute("partida",partida);
			model.addAttribute("pregunta",pregunta.getPregunta());
			
			opciones = pregOpcRepository.findByPreguntaId(pregunta.getId());
			model.addAttribute("opcion1",opciones.get(0).getOpcion());
			model.addAttribute("opcion2",opciones.get(1).getOpcion());
			model.addAttribute("opcion3",opciones.get(2).getOpcion());
			model.addAttribute("opcion4",opciones.get(3).getOpcion());
		}
		}
		catch(Exception e) {
			         
		model.addAttribute("mensaje","NO HAY MAS PREGUNTAS DISPONIBLES DE ESTA TEMATICA");
		}
	} else model.addAttribute("mensaje","TIRA DE NUEVO");
	
	}
	
}

	
  public int llamarDado (Model model) {
   int leerDado=service.lanzarDato();
  return leerDado; }
 
	

  @RequestMapping("/respuesta")
	public void getResponse (Model model, int respuesta) {
		System.out.print("**********");
		boolean correcta = service.checkRespuesta(opciones, respuesta);
		
		partida(model);
		
		if(correcta) model.addAttribute("mensaje","RESPUESTA CORRECTA");
		else model.addAttribute("mensaje","RESPUESTA INCORRECTA");
		
	}
 
}