package es.uned.master.java.test.es.uned.master.java.test;

import es.uned.master.java.*;
import es.uned.master.java.enumerados.*;
import es.uned.master.java.errores.*;
import es.uned.master.java.enumerados.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class NumeroDeReferenciaTest{
    @Test
    public void comprobacionReferencias(){
        //Vamos a simular un Número de referencia y comprobar que es válido.
        // Inicializamos los valores para año 2022
        NumeroDeReferencia.reset((short) 2022);
        // Creamos una instancia NumeroDeReferencia limpieza;
        NumeroDeReferencia ref1 = new NumeroDeReferencia(Categoria.LIMPIEZA);
        assertEquals(ref1.toString(), "LIMPIEZA202200000");

    }
}
