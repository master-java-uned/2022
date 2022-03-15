package es.uned.master.java;

import es.uned.master.java.enumerados.*;
import es.uned.master.java.errores.*;
import java.util.*;

public class NumeroDeReferencia {
    private static short ultimoAño;
    private static Map<Categoria, Integer> ultimaSecuencia;


        public static short getUltimoAño() {

            return ultimoAño;
        }

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

        public static void nextSecuencia(Categoria c) throws SuministrosException{
                int i = ultimaSecuencia.get(c).intValue();
                i++;
                ultimaSecuencia.put(c, i);
        }
        public static int getSecuencia(Categoria c){
            if (c instanceof Categoria){
                return ultimaSecuencia.get(c).intValue();
            }else{
                throw new SuministrosException("No es una categoria válida");
            }
        }

    private int SECUENCIA_MAXIMA;
    private String codigo;

    public NumeroDeReferencia(Categoria categoria){
        this.SECUENCIA_MAXIMA = 99999;
        if (categoria instanceof Categoria) {
            // Empezamos con el código añadiendo la categoria.
            this.codigo = categoria.toString() + " - ";
            // Después añadimos el ultimoAño
            this.codigo += NumeroDeReferencia.ultimoAño + " # ";
            // Para terminar debe tener un código de 5 digitos que se reinicia por cada año y categoria
            NumeroDeReferencia.nextSecuencia(categoria);
            this.codigo += getSecuencia(categoria);
        }else{
            // Me colaron un null...
            throw new SuministrosException("No es una categoria");
        }
    }

    public String toString(){
        return this.codigo;
    }
}
