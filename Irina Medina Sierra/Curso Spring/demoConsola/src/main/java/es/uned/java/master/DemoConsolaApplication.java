package es.uned.java.master;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import es.uned.java.master.service.IPersonaService;

@SpringBootApplication
public class DemoConsolaApplication implements CommandLineRunner{

	private static Logger LOG = LoggerFactory.getLogger(DemoConsolaApplication.class);
	
	@Autowired
	private IPersonaService service;
	

	
	public static void main(String[] args) {
		SpringApplication.run(DemoConsolaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//LOGI.info("Informando: Apendiendo Spring Boots");
		//LOGI.warn("Avisando: Apendiendo Spring Boots");
		
		service.registrar("InformáticaPlus");
	}
	
}
