package es.uned.master.java.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uned.master.java.interfaces.IJugadores;
import es.uned.master.java.interfaces.IjugadoresServices;
import es.uned.master.java.models.Jugadores;

@Service
public  class JugadoresServices  implements IjugadoresServices{

	@Autowired
	private IJugadores data;
	
	@Override
	public List<Jugadores> listar() {
		return (List<Jugadores>) data.findAll();
	}

	@Override
	public Optional<Jugadores> listarId(int id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public int save(Jugadores p) {
		int res=0;
		Jugadores jugador=data.save(p);
		if (jugador.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	
	

}
