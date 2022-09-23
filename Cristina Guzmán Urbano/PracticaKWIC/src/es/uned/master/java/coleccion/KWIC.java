package es.uned.master.java.coleccion;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

import es.uned.master.java.basico.KWICCompare;

public class KWIC {
	
	/**
	 * Declaración de propiedades del objeto
	 * 
	 * El objeto consta de:
	 * - Un conjunto Set para guardar las palabras no claves que son las que 
	 *  carecen de significado
	 * - Una estructura Map donde por cada palabra con significado, que será 
	 *  nuestro índice, habrá un conjunto de frases. Estas frases relacionadas 
	 *  con el índice, serán aquellas frases en las que aparezca la palabra 
	 *  índice.
	 * 
	 **/
	
    private Set<KWICCompare> noClaves;
    private Map<KWICCompare,Set<String>> glosario;


    //Constructor del objeto
    public KWIC(){
         noClaves = new TreeSet();
         glosario = new TreeMap();
    }

    /**
     *
     * @param nc --> Cadena String de palabras no significativas
     *
     * Este método incorpora en un conjunto todas las palabras no significativas.
     *
     */
    public void addNoClaves(String nc){
        //Se utiliza el Tokenizer para coger cada palabra no significativa
        StringTokenizer st = new StringTokenizer(nc," ,:;");
        while (st.hasMoreTokens()){ //mientras haya elementos
                noClaves.add(new KWICCompare(st.nextToken())); //se añade la palabra en el conjunto noClaves
        }

    }
    
    /**
    *
    * @param frase --> Cadena String de frases a analizar
    *
    * Este método analiza las palabras de una frase y añade la frase en las claves correspondientes.
    *
    */
    public void clasificaFrases(String frase){
        //Se utiliza Tokenizer para coger las palabras significativas que valdrán
        //como índice para la estructura Map
        StringTokenizer st = new StringTokenizer(frase);
        while (st.hasMoreTokens()){
            KWICCompare palabra = new KWICCompare(st.nextToken());
            //Si no es una palabra no significativa, continúa
            if (!noClaves.contains(palabra)){
                //Se llama a un método privado frases, que incorpora la
            	//frase a la palabra clave del glosario
            	addFrase(palabra,frase);
            }
        }
    }
    /**
     *
     * @param indice --> palabra clave de la estructura Map
     * @param frase --> frase a introducir en el conjunto relacionado con el índice o
     *                  clave.
     *
     * Este método privado añade la frase al conjunto relacionado con el
     * índice que le paso como parámetro
     */
    private void addFrase(KWICCompare indice,String frase){
        //me creo un conjunto para el caso que ese indice no esté en mi estructura
        Set<String> s = new TreeSet<String>();
        //si mi estructura Map contiene ese indice
        if (glosario.containsKey(indice)){
        //Devuelve el conjunto de frases de ese indice
            s = glosario.get(indice);
        }
        //como tanto si está el indice en la estructura como si no está tengo que
        //añadir la frase al conjunto y luego relacionar ese indice con mi conjunto
        //s actualizado, lo saco del if, y no me hace falta poner un else
        s.add(indice.replace(frase));
        //OJO --> añado replace para que me sustituya en la frase
        //        el indice por ...
        //el método está definido en KWICCompare
        glosario.put(indice,s);

    }

 //----------------------------------------------------------------------------
    /**
     * Este método imprime el glosario final.

       Utiliza dos métodos privados:
       imprimirNoClaves() --> Imprime por pantalla el conjunto de no claves.

       imprimirGlosario() --> Imprime por pantalla la estructura Map,
	                          clave (índice) y valor (conjunto de frases relacionadas
	                          y con el índice sustituido por ...)

     */
    public String toString(){
        String cadFinal = "";
        cadFinal += imprimirNoClaves();
        cadFinal += imprimirGlosario();
        return cadFinal;
    }

    /**
     *
     * @return Una cadena con las palabras no significativas a imprimir
     *
     * Método privado que imprime el conjunto de las palabras no significativas.
     * Este método será utilizado por el toString()
     */
    private String imprimirNoClaves(){
        String cadNoClaves = "N O    C L A V E S: ["; //inicializo la cadena
        //Se utiliza el iterador de conjuntos para recorrerlo e imprimirlo
        Iterator<KWICCompare> itNoClaves = this.noClaves.iterator();
        //Se imprime el primer elemento sin coma
        if(itNoClaves.hasNext()) cadNoClaves += itNoClaves.next().toString();
        while (itNoClaves.hasNext()){//mientras halla elementos en el conjunto
            cadNoClaves += ", " + itNoClaves.next().toString();//imprime elementos separando con comas
        }
        cadNoClaves += "]";
        return cadNoClaves;
    }

    /**
     * 
     * @return Un listado con las palabras clave y frases que usan esa palabra a imprimir
     * 
     * Método privado que imprime la estructura Map<Indice,conjunto de frases>.
       Este método será utilizado por el toString()
     */
    private String imprimirGlosario(){
        String cadGlosario = "\n\n\t"+"G L O S A R I O"+"\n";
        //como el Map no tiene iterator se coge de Map.Entry 
        Iterator<Map.Entry<KWICCompare,Set<String>>> itGlosario = this.glosario.entrySet().iterator();
        while (itGlosario.hasNext()){//mientras halla elementos en la estructura
            Map.Entry<KWICCompare,Set<String>> me = itGlosario.next();
            cadGlosario +="\n"+ me.getKey()+"\n\n";//meto el indice
            //hago un método privado para recorrer el conjunto para ese índice
            cadGlosario += imprimirFrases(me.getValue());
        }
        return cadGlosario;
    }

    /**
     *
     * @param s --> Conjunto de cadenas asociadas a una key, es el valor de la estructura Map
     * @return  Una cadena con los elementos del conjunto para imprimir
     *
     * Método que imprime el conjunto de frases transformadas
     * 
     */

    private String imprimirFrases(Set<String> s){
        //Es el mismo procedimiento que imprimirNoClaves()
        String cFrases = "";//inicializo
        //Se crea el iterador
        Iterator itCFrases = s.iterator();
        //mientras halla elementos en mi conjunto
        while (itCFrases.hasNext()){
            //Se imprimen los elementos
        	cFrases += "\t" + itCFrases.next()+ "\n";
        }
        return cFrases;
    }

}
