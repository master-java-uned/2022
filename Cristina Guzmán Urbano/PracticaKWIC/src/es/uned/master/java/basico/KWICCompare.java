package es.uned.master.java.basico;

import java.util.StringTokenizer;

/**
*
* @author cguzman
* 
* Esta clase se encarga de procesar correctamente las comparaciones de cadenas
* 
*/

public class KWICCompare implements Comparable<KWICCompare> {
	/**
	 * Declaración de propiedades del objeto
	 * 
	 * El objeto consta de una propiedad de tipo String y con acceso private
	 **/
    private String titulo;

    /**
	 * Declaración de métodos del objeto
	 * 
	 **/
    
    //Constructor del objeto
    public KWICCompare(String t){
    	setTitulo(t.toUpperCase());
    }
    
    //Acceso a la propiedad del objeto
    public String getTitulo() {
    	return titulo;
    }
    public void setTitulo(String t) {
    	titulo = t;
    }

    /**
     * Como se van a usar estructuras TreeMap y TreeSet, se necesita redefinir
     * los métodos:
     * -compareTo
     * -equals
     * -toString
     * -hashCode
     */

    //Método compareTo para no distinguir entre mayúsculas y minúsculas
    public int compareTo(KWICCompare kc) {
        return getTitulo().compareToIgnoreCase(kc.getTitulo());
    }


    //Método equals, que dos títulos sean iguales sin distinguir entre mayúsculas y
    //minúsculas
    public boolean equals(KWICCompare kc) {
        return getTitulo().equalsIgnoreCase(kc.getTitulo());
    }

	//Método toString, imprime el contenido del String titulo
	public String toString(){
	   return getTitulo();
	}
	
	public int hashCode(){
		return this.titulo.toUpperCase().hashCode();
	}

    /**
     *
     * @param palabra: Se reemplaza por "..." si aparece en la frase
     * @return
     *           si coinciden --> la cadena modificada
     *           si no coinciden --> la cadena sin modificar
     */
    public String replace(String palabra) {

        StringTokenizer st = new StringTokenizer(palabra);
        String destino = "";
        while(st.hasMoreTokens()){
        	KWICCompare token = new KWICCompare(st.nextToken());
            if(getTitulo().equals(token.toString())){
                destino += "... ";
            }
            else{
                destino += token +" ";
            }
        }
        return destino;
    }
}
