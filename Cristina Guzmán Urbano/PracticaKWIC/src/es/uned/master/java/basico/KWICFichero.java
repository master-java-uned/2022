package es.uned.master.java.basico;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class KWICFichero {
	
	/**
	 * Declaración de propiedades del objeto
	 * 
	 * El objeto consta de:
	 * 
	 * - Un objeto FileReader que se crea a partir de la path del archivo que se quiere leer 
	 * y ayuda a leerlo
	 *  
	 * - Un objeto BufferedReader encargado de leer las lineas del fichero
	 * 
	 * - Un objeto ArrayList donde se almacenan las lineas leidas del fichero
	 * 
	 * - Un objeto FileWriter que se crea a partir de la path del archivo en el que se quiere escribir
	 *  y ayuda a escribirlo
	 *  
	 * - Un objeto BufferedWriter encargado de escribir en un fichero
	 * 
	 **/
	
	private FileReader fr;
	private BufferedReader bfr;
	private ArrayList<String> lineas;
	private FileWriter fw;
	private BufferedWriter bfw;
	
	public KWICFichero(){}
	
	//Se crea el getter de la propiedad lineas para poder acceder a ella desde fuera
	public ArrayList<String> getLineas() {
		return this.lineas;
	}

	//En esta funcion se realiza la lectura de las lineas del fichero que se adjunta como argumento
	//y se insertan en la propiedad lineas
	public void leeFichero(String file){
		String linea;
		this.lineas = new ArrayList<String>();
		try {
			//Apertura de fichero y creación de Buffer para agilizar la lectura
			this.fr = new FileReader(file);
			this.bfr = new BufferedReader(this.fr);
			//Se lee cada linea hasta que acabe el fichero
			while ((linea = this.bfr.readLine()) != null){
				//System.out.println("Linea capturada: " + linea);
				//Se introduce cada linea leida en el objeto lineas
				this.lineas.add(linea);
			}
		} //Se capturan las posibles excepciones que pueden darse
		catch (FileNotFoundException ex){
			ex.printStackTrace();
		}catch (IOException ex){
			ex.printStackTrace();
		}catch (Exception ex){
			ex.printStackTrace();
		}finally{ //Si no hay excepciones se cierra el buffer y el reader
			try{
				if (this.bfr != null){
					this.bfr.close();
				}
				if (this.fr != null){
					this.fr.close();
				}
			}catch(Exception ex){}
		}
	}
	
	public void escribeFichero(String contenido, String file){
		try {
			//Apertura (y creacion) de fichero y creación de Buffer para agilizar la escritura
			this.fw = new FileWriter(file);
			this.bfw = new BufferedWriter(this.fw);
			//Se escribe el contenido del fichero
			bfw.write(contenido);
		} //Se capturan las posibles excepciones que pueden darse
		catch (FileNotFoundException ex){
			ex.printStackTrace();
		}catch (IOException ex){
			ex.printStackTrace();
		}catch (Exception ex){
			ex.printStackTrace();
		}finally{ //Si no hay excepciones se cierra el buffer y el writer
			try{
				if (this.bfw != null){
					this.bfw.close();
				}
				if (this.fw != null){
					this.fw.close();
				}
			}catch(Exception ex){}
		}
	}
}
