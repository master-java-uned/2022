package es.uned.master.java.test;

import es.uned.master.java.caracteristicas.*;
import static org.junit.Assert.*;
import org.junit.Test;


public class EnumeradosTest {
    @Test
    public void esCategoria(){
        Categoria c = Categoria.LIMPIEZA;
        assertTrue(c instanceof Categoria);
    }

    @Test
    public void esEstado() {
        Estado e = Estado.ALQUILADO;
        assertTrue(e instanceof Estado);
    }
}
