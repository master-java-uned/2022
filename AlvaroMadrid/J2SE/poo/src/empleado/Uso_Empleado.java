package empleado;

import java.util.Date;
import java.util.GregorianCalendar;

public class Uso_Empleado {
    public static void main(String[] args) {

        /*
        Empleado empleado1 = new Empleado("Paco Gómez", 65000, 2014, 1, 10);
        Empleado empleado2 = new Empleado("Ana López", 80000, 2003, 5, 9);
        Empleado empleado3 = new Empleado("María Martín", 90000, 1990, 8, 21);

        empleado1.subeSueldo(5);
        empleado2.subeSueldo(5);
        empleado3.subeSueldo(5);


        System.out.println("Nombre: " + empleado1.dameNombre() + "\nSueldo: " + empleado1.dameSueldo()
            + "\nFecha de Alta: " + empleado1.dameFechaContrato());
        System.out.println("Nombre: " + empleado2.dameNombre() + "\nSueldo: " + empleado2.dameSueldo()
                + "\nFecha de Alta: " + empleado2.dameFechaContrato());
        System.out.println("Nombre: " + empleado3.dameNombre() + "\nSueldo: " + empleado3.dameSueldo()
                + "\nFecha de Alta: " + empleado3.dameFechaContrato());
         */

        Jefatura jefe_RRHH = new Jefatura("Juan Ruiz", 120000, 2006, 6, 1);
        jefe_RRHH.estableceIncentivo(5500);

        Empleado[] misEmpleados = new Empleado[6];
        misEmpleados[0] = new Empleado("Paco Gómez", 65000, 2014, 1, 10);
        misEmpleados[1] = new Empleado("Ana López", 80000, 2003, 5, 9);
        misEmpleados[2] = new Empleado("María Martín", 90000, 1990, 8, 21);
        misEmpleados[3] = new Empleado("Antonio Fernández");
        misEmpleados[4] = jefe_RRHH;// POLIMORFISMO
        // Principio de sustitución: se puede utilizar un objeto de la subclase siempre que el programa espere un objeto de la superclase
        misEmpleados[5] = new Jefatura("María Dominguez", 95000, 1999, 5, 26);

        // Casting de objetos. En este caso, para aplicar un método de la subclase en el Array (de la superclase). Se puede aplicar por el diseño de la herencia y la regla "ES UN..."

        Jefatura jefa_Finanzas=(Jefatura) misEmpleados[5];
        jefa_Finanzas.estableceIncentivo(50000);

        /*
        for(int i=0; i<misEmpleados.length; i++){
            misEmpleados[i].subeSueldo(5);
        }
        */

        for(Empleado e: misEmpleados){
            e.subeSueldo(5);
        }

        // Cuando este bucle FOR...EACH llega al objeto de JEFATURA, invoca el método dameSueldo de la subclase (ENLAZADO DINÁMICO)

        /*
        for(int i=0; i< misEmpleados.length; i++){
            System.out.println("Nombre: " + misEmpleados[i].dameNombre() + "\nSueldo: " + misEmpleados[i].dameSueldo()
                + "\nFecha de Alta: " + misEmpleados[i].dameFechaContrato());
        }
        */

        for(Empleado e: misEmpleados){
            System.out.println("Nombre: " + e.dameNombre() + " Sueldo: " + e.dameSueldo()
                    + " Fecha de Alta: " + e.dameFechaContrato());
        }

    }
}

class Empleado{

    // Constructor de clase
    public Empleado(String nom, double sue, int ano, int mes, int dia){

        nombre=nom;
        sueldo=sue;
        GregorianCalendar calendario = new GregorianCalendar(ano, mes-1, dia);
        altaContrato = calendario.getTime();

    }

    // Sobrecarga de constructores: varios constructores bajo el mismo nombre pero diferentes parámetros
    // Se utiliza cuando necesitamos crear un objeto sin conocer todos sus atributos
    // También existe la sobrecarga de métodos: varios métodos bajo el mismo nombre pero diferentes parámetros

    public Empleado(String nom){

        this(nom, 30000, 2000, 1, 1); // El THIS llama al otro constructor de la clase

    }

    // Además, se puede utilizar un Constructor vacío -sin parámetros-, por lo que se crearán Objetos sin

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

    private final String nombre;
    private double sueldo;
    private final Date altaContrato;

}

final class Jefatura extends Empleado{ // Al declarar la CLASE como FINAL, se impide la herencia sobre esta clase

    public Jefatura(String nom, double sue, int ano, int mes, int dia){
        super(nom, sue, ano, mes, dia);
    }

    public void estableceIncentivo (double b){
        incentivo=b;
    }

    public double dameSueldo(){
        double sueldoJefe=super.dameSueldo(); // Utilizando SUPER invocamos el dameSueldo() del padre
        return sueldoJefe + incentivo;
    }

    private double incentivo;

}

/*
class Director extends Jefatura{

    public Director(String nom, double sue, int ano, int mes, int dia){
        super(nom, sue, ano, mes, dia);
    }

}
*/