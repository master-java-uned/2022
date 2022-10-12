package empleadoabstract;

import java.util.Date;
import java.util.GregorianCalendar;

public class Uso_Empleado {
    public static void main(String[] args) {

        Persona[] lasPersonas = new Persona[2];

        lasPersonas[0] = new Empleado("Luis Conde", 50000, 2009, 02, 25);
        lasPersonas[1] = new Alumno("Alvaro Madrid", "Economía");

        for (Persona p:lasPersonas){
            System.out.println(p.dameNombre() + ": " + p.dameDescripcion());
        }
    }
}

abstract class Persona{

    public Persona(String nom){
        nombre = nom;
    }

    public String dameNombre(){
        return nombre;
    }

    public abstract String dameDescripcion();

    private String nombre;

}


class Empleado extends Persona{

    private String nombre;
    private double sueldo;
    private final Date altaContrato;

    // Constructor de clase
    public Empleado(String nom, double sue, int ano, int mes, int dia){

        super(nom);

        sueldo = sue;
        GregorianCalendar calendario = new GregorianCalendar(ano, mes-1, dia);
        altaContrato = calendario.getTime();

    }

     public String dameNombre(){ // getter
         return nombre;
     }

     public double dameSueldo(){ // FINAL: si declaramos como FINAL, el método de la subclase no podría llamarse igual que este método
         return sueldo;
     }

     public Date dameFechaContrato(){ // getter
         return altaContrato;
     }

     public void subeSueldo(double porcentaje){ // setter

         double aumento = sueldo*porcentaje/100;
         sueldo += aumento;

     }

     public String dameDescripcion(){
         return "Este empleado se llama " + nombre + " con un sueldo de " + sueldo;
     }

}

class Alumno extends Persona{

    public Alumno(String nom, String car){

        super(nom);
        carrera = car;

    }

    public String dameDescripcion(){
        return "Este alumno está estudiando la carrera de " + carrera;
    }

    private String carrera;

}