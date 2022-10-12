package es.uned.master.java.caracteristicas;

// Importamos todos los packages necesarios.
import es.uned.master.java.errores.*;
import java.util.*;

// Declaramos la clase y sus atributos.
public class NumeroDeReferencia {
    private static short ultimoAño;
    private static Map<Categoria, Integer> ultimaSecuencia;

        // Constructor de la clase.
        // Comenzamos un método getUltimoAño.
        public static short getUltimoAño() {

            return ultimoAño;
        }

        // Método setter para inicializar y validar el año y asignarle la CATEGORIA.
        public static void reset(short año){
            if ((año >1000) && (año<9999)) {
                ultimoAño = año;
                ultimaSecuencia = new HashMap();
                ultimaSecuencia.put(Categoria.LIMPIEZA, 0);
                ultimaSecuencia.put(Categoria.OBRA, 0);
                ultimaSecuencia.put(Categoria.PINTURA, 0);
            }else{
                throw new SuministrosException("El año debe tener 4 digitos");
            }
        }

        // Método setter de la siguiente secuencia disponible.
        public static void nextSecuencia(Categoria c) throws SuministrosException{
                int i = ultimaSecuencia.get(c).intValue();
                i++;
                ultimaSecuencia.put(c, i);
        }

        // Método getter de la Secuencia. También se valida si la categoria es válida.
        public static int getSecuencia(Categoria c){
            if (c instanceof Categoria){
                return ultimaSecuencia.get(c).intValue();
            }else{
                throw new SuministrosException("No es una categoria válida");
            }
        }

    // Más atributos
    private int SECUENCIA_MAXIMA;
    private String codigo;

    // Constructor de clase
    public NumeroDeReferencia(Categoria categoria){
        this.SECUENCIA_MAXIMA = 99999;
        if (categoria instanceof Categoria) {
            // Empezamos con el código añadiendo la categoria, convirtiendo el valor en String.
            this.codigo = categoria.toString() + " - ";
            // Después añadimos el ultimoAño
            this.codigo += NumeroDeReferencia.ultimoAño + " # ";
            // Para terminar debe tener un código de 5 dígitos que se reinicia por cada año y categoria.
            NumeroDeReferencia.nextSecuencia(categoria);
            this.codigo += getSecuencia(categoria);
        }else{
            // En caso de valor NULL, lanzamos error "específico".
            throw new SuministrosException("No es una categoria");
        }
    }

    // Convertimos el output en String.
    public String toString(){
        return this.codigo;
    }
}
