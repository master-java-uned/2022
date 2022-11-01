package es.uned.master.java.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.uned.master.java.models.Jugadores;
import es.uned.master.java.services.JugadoresServices;

@Controller
@RequestMapping
public class UserController {
	
	@Autowired
	private JugadoresServices services;
	
	@RequestMapping("/trivial")	
	 public void inicio() {
		
		 
	 }
	

	  @GetMapping("/listar")
		public void listar (Model model) {
			List<Jugadores>jugador=services.listar();
			model.addAttribute("jugador",jugador);
			
		}
	  
	  @GetMapping("/new")
		public String agregar(Model model) {
			model.addAttribute("jugador", new Jugadores());
			return "registro";
		}
	  
		@PostMapping("/save")
		public String save(@Validated Jugadores jugador, Model model) {
			services.save(jugador);
			
			return "redirect:/index";
			//+"?"+jugador.getNombre();
			
			
		}
	  
}
