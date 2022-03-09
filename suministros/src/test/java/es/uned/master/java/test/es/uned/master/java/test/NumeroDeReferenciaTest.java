package es.uned.master.java.test.es.uned.master.java.test;

import es.uned.master.java.*;
import es.uned.master.java.enumerados.*;
import es.uned.master.java.errores.*;
import es.uned.master.java.enumerados.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class NumeroDeReferenciaTest{
    @Test
    public void numeroDeReferenciaTest(){
        //Vamos a simular un Número de referencia y comprobar que es válido.
        // Inicializamos los valores para año 2022
        NumeroDeReferencia.reset((short) 2022);
        // Creamos una instancia NumeroDeReferencia limpieza;
        NumeroDeReferencia ref1 = new NumeroDeReferencia(Categoria.LIMPIEZA);
        assertEquals(ref1.toString(), "LIMPIEZA - 2022 # 1");
        NumeroDeReferencia ref2 = new NumeroDeReferencia(Categoria.OBRA);
        assertEquals(ref2.toString(), "OBRA - 2022 # 1");
        NumeroDeReferencia ref3 = new NumeroDeReferencia(Categoria.OBRA);
        assertEquals(ref3.toString(), "OBRA - 2022 # 2");
    }

    @Test
    public void addUltimaReferenciaTest(){
        NumeroDeReferencia.reset((short) 2022);

        //Compruebo que el map se completa inicializado bien.
        assertEquals(NumeroDeReferencia.getSecuencia(Categoria.LIMPIEZA), 0);
        assertEquals(NumeroDeReferencia.getSecuencia(Categoria.OBRA), 0);
        assertEquals(NumeroDeReferencia.getSecuencia(Categoria.PINTURA), 0);

        // Añado algunos elemnetos.
        for (int i =0; i < 30; i++) {
            NumeroDeReferencia.nextSecuencia(Categoria.LIMPIEZA);
            NumeroDeReferencia.nextSecuencia(Categoria.OBRA);
            NumeroDeReferencia.nextSecuencia(Categoria.PINTURA);
        }
        //Compruebo que el map se completa inicializado bien.
        assertEquals(NumeroDeReferencia.getSecuencia(Categoria.LIMPIEZA), 30);
        assertEquals(NumeroDeReferencia.getSecuencia(Categoria.OBRA), 30);
        assertEquals(NumeroDeReferencia.getSecuencia(Categoria.PINTURA), 30);

    }
}
