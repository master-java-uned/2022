package es.uned.master.java.test;

import es.uned.master.java.enumerados.*;
import static org.junit.Assert.*;
import org.junit.Test;


public class CategoriaTest {
    @Test
    public void esCategoria(){
        Categoria c = Categoria.LIMPIEZA;
        assertTrue(c instanceof Categoria);
    }
}
