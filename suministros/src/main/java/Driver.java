import es.uned.master.java.enumerados.*;

public class Driver {
    public static void main (String [] arg) {
        Categoria cat = Categoria.LIMPIEZA;

        System.out.println(cat+": "+ cat.getAlquiler()+" - "+ cat.getVenta());

    }
}
