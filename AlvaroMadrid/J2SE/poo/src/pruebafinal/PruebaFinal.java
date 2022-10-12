package pruebafinal;

public class PruebaFinal {

    public static void main(String[] args) {

        Empleados trabajador1 = new Empleados("Paco");
        Empleados trabajador2 = new Empleados("Ana");
        Empleados trabajador3 = new Empleados("Antonio");

        trabajador1.cambiaSeccion("RRHH");
        //trabajador1.cambiaNombre("María");

        System.out.println(trabajador1.devuelveDatos() + "\n" + trabajador2.devuelveDatos() + "\n" + trabajador3.devuelveDatos());

        System.out.println(Empleados.dameIdSiguiente());

    }

}

class Empleados{

    public Empleados(String nom){

        nombre = nom;
        seccion = "Administración";
        Id = IdSiguiente;
        IdSiguiente++;

    }

    public void cambiaSeccion(String seccion){ // setter
        this.seccion = seccion;
    }

    /*
    public void cambiaNombre(String nombre){ // setter
        this.nombre = nombre;
    }
     */

    public String devuelveDatos(){
        return "El nombre es " + nombre + ". La sección es " + seccion + ". El Id es " + Id;
    }

    public static String dameIdSiguiente(){
        return "El IdSiguiente es: " + IdSiguiente;
    }

    private final String nombre; // FINAL
    private String seccion;
    private int Id;

    private static int IdSiguiente = 1;

}
