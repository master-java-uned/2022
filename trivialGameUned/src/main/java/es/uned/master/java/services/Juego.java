package es.uned.master.java.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uned.master.java.controller.Ijuego;
import es.uned.master.java.models.ECategoria;
import es.uned.master.java.models.Preguntas;
import es.uned.master.java.models.PreguntasOpciones;
import es.uned.master.java.models.Tablero;
import es.uned.master.java.repository.PreguntasOpcionesRepository;
import es.uned.master.java.repository.PreguntasRepository;
import es.uned.master.java.repository.TableroRepository;


@Service
public class Juego implements Ijuego{

	private int resultado;
	
	@Autowired
	PreguntasRepository preguntasRepository;
	/*@Autowired
	PreguntasOpcionesRepository pregOpcRepository;
	@Autowired
	TableroRepository tableroRepository;*/
	
	@Override
	public int identificarJugador(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int posicionesPropuestas1(int posicionActual,int dado) {
		//verificamos que  la casilla actual sea menor o igual a 6
		System.out.println("posicionActual opcion1: "+ posicionActual);
		int posicion1=0;
		if (posicionActual<=6) {
			posicion1=posicionActual+dado;
		}
		if (posicionActual==0 || posicionActual>6) {
			posicion1=posicionActual+dado;
		}
		if (posicion1>24){
			posicion1=posicion1-24;
		}
		System.out.println("opcion1: "+ posicion1);
		return posicion1;
	}
	@Override
	public int posicionesPropuestas2(int posicionActual,int dado) {
		System.out.println("posicionActual opcion2: "+ posicionActual);
		int posicion2=0;
		int validarCasilla=posicionActual-dado;
			if (validarCasilla<=0) {
				posicion2=24-(dado-posicionActual);
				
			}else {
			posicion2=validarCasilla;
		}
		
		System.out.println("opcion2: "+ posicion2);
		return posicion2;
	}
	
	
	public int lanzarDato() {
		//metodo que se llama para lanzar el dado
		resultado = (int) ((Math.random() * 6) + 1);
		return resultado;
	}

	@Override
	public int leerCasilla(int casillaAnterior, int casillaNueva) {
		if (casillaAnterior==0 && casillaNueva==0) {
			casillaAnterior=1;
			casillaNueva=0;
		}
		
		// TODO Auto-generated method stub
		return casillaAnterior;
	}

	@Override
	public int pregunta(int idPregunta, String Pregunta, String opcion1, String opcion2, String opcion3, String opcion4,
			String Correcta) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public Preguntas getPregunta(ECategoria categoria) {

		List<Preguntas> pregs = preguntasRepository.findAllByCategoria(categoria);
		
		int numPreg = (int) ((Math.random() * pregs.size()));
		
		int control = 0;
		
		while (pregs.get(numPreg).isUtilizada() && (control < pregs.size())) {
			numPreg = (int) ((Math.random() * pregs.size()));
			System.out.println("CONTROL: "+ control);
			control++;
		}
			
		if(control >= pregs.size()) return null;
		
		pregs.get(numPreg).setUtilizada(true);		
		preguntasRepository.save(pregs.get(numPreg));
		
		System.out.println("preg.getPregunta(): "+ pregs.get(numPreg).getPregunta());
		return pregs.get(numPreg);
	}
	
	@Override
	public boolean checkRespuesta(List<PreguntasOpciones> opciones, String respuesta) {
		
		System.out.println("respuesta: "+ opciones.get(Integer.parseInt(respuesta)-1).getOpcion());
		
		if(opciones.get(Integer.parseInt(respuesta)-1).getCorrecta() == 1) return true;
		
		return false;
	}
	
	/*public List<String> getOpciones(int idPregunta) {
		
		List<PreguntasOpciones> opciones = pregOpcRepository.findByPreguntaId(idPregunta);
		
		List<String> str_opciones = new ArrayList<String>();
		
		for (PreguntasOpciones value : opciones)
		{
			str_opciones.add(value.getOpcion());
		}
		
		return str_opciones;
	}*/



	
}
