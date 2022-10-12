import es.uned.master.java.Herramienta;
import es.uned.master.java.Tienda;
import es.uned.master.java.acciones.Alquiler;
import es.uned.master.java.acciones.Reparacion;
import es.uned.master.java.acciones.Venta;
import es.uned.master.java.caracteristicas.*;
import es.uned.master.java.ficheros.EscribirFichero;
import es.uned.master.java.ficheros.LeerFichero;

import java.time.LocalDate;


public class Driver {
    // Definimos la clase principal
    public static void main (String [] arg) {

/*
        EscribirFichero escribiendo = new EscribirFichero();
        escribiendo.escribir(imprimir);

        LeerFichero accediendo = new LeerFichero();
        accediendo.lee();
        NumeroDeReferencia.reset((short) 2022);
*/

        NumeroDeReferencia.reset((short) 2022);
        System.out.println("GESTIÓN DE TIENDA DE SUMINISTROS");

        Tienda.AltaHerramienta();
        //Tienda.ListarHerramienta();
        //System.out.println("stop");
        //Tienda.AltaHerramienta();
        //Tienda.ListarHerramienta();


        //System.out.println("stop");
        Tienda.ListarHerramienta();
        Tienda.AlquilarHerramienta();
        Tienda.ListarHerramienta();

    }
}
