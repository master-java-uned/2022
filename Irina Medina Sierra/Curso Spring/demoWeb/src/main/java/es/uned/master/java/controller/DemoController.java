package es.uned.master.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.uned.master.java.model.Persona;
import es.uned.master.java.repo.iPersonaRepo;

@Controller
public class DemoController {
	
	@Autowired
	private iPersonaRepo repo;
	
	
	
	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		Persona p=new Persona();
		p.setIdPersona(3);
		p.setNombre("MitoCode");
		repo.save(p);
		model.addAttribute("name", name);
		return "greeting";
	}
	
	@GetMapping("/listar")
	public String greeting(Model model) {
		//lógica
		
		model.addAttribute("personas", repo.findAll());
		return "greeting";
	}
}
