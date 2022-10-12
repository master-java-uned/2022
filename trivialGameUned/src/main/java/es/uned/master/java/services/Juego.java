package es.uned.master.java.services;

import org.springframework.stereotype.Service;

import es.uned.master.java.controller.Ijuego;


@Service
public class Juego implements Ijuego{

	private int resultado;

	
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
	
	//metodo que se llama para lanzar el dado
	public int lanzarDato() {
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



	
}
