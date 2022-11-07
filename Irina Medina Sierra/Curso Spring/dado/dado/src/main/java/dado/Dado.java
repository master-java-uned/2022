package dado;

import java.util.Random;

public class Dado {

	
	/**
	 * Metodo que simula la tirada de un dado. 
	 * @return un numero aleatorio entre 1 y 6
	 */
	public int tirarDado()
	{	Random r = new Random();
		 return r.nextInt(6)+1; 
	}
}
