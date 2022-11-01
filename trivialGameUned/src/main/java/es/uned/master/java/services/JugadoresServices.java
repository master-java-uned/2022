package es.uned.master.java.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uned.master.java.interfaces.IJugadores;
import es.uned.master.java.interfaces.IjugadoresServices;
import es.uned.master.java.models.ECategoria;
import es.uned.master.java.models.Jugadores;
import es.uned.master.java.repository.JugadoresRepository;

@Service
public  class JugadoresServices  implements IjugadoresServices{

	@Autowired
	private IJugadores data;
	
	@Autowired
	JugadoresRepository jugadoresRepository;
	
	Jugadores jugador;
	
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
		jugador=data.save(p);
		if (jugador.equals(null)) {
			res=1;
		}
		return res;
	}
	
	@Override
	public Jugadores identificarJugador() {
		return jugador;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void marcarQuesito(Jugadores jugador, ECategoria categoria) {

		switch(categoria) {
			case HARRY_POTTER: 
				jugador.setQuesito_morado(true);
	            break;
	        case STAR_WARS: 
	        	jugador.setQuesito_verde(true);
	            break;
			case NARNIA: 
				jugador.setQuesito_azul(true);
		        break;
			case SEÑOR_ANILLOS: 
				jugador.setQuesito_naranja(true);
		        break;
			case MARVEL: 
				jugador.setQuesito_amarillo(true);
		        break;
			case DISNEY: 
				jugador.setQuesito_rosa(true);
		        break;
			default:
				break;
		}

		jugadoresRepository.save(jugador);
		
	}
	
	@Override
	public boolean esGanador() {
		if(jugador.isQuesito_amarillo() && jugador.isQuesito_azul() && jugador.isQuesito_morado() && jugador.isQuesito_naranja() &&
				jugador.isQuesito_rosa() && jugador.isQuesito_verde()) return true;
		
		return false;
	}

}
