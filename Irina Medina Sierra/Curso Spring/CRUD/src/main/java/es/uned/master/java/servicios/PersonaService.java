package es.uned.master.java.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uned.master.java.interfaceService.IpersonaServices;
import es.uned.master.java.interfaces.IPersona;
import es.uned.master.java.modelo.Persona;


@Service
public class PersonaService implements IpersonaServices{

	@Autowired
	private IPersona data;

	
	
	@Override
	public List<Persona> listar() {
		// TODO Auto-generated method stub
		return (List<Persona>)data.findAll();
	}

	@Override
	public Optional<Persona> listarId(int id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public int save(Persona p) {
		// TODO Auto-generated method stub
		int res=0;
		Persona persona=data.save(p);
		if (!persona.equals(null)) {
			res=1;			
		}
		return res;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	

}
