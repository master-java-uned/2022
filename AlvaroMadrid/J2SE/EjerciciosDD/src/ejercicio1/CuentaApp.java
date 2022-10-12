package ejercicio1;

public class CuentaApp {

    public static void main(String[] args) {

        //Instanciamos la clase Cuenta con dos objetos
        Cuenta cuenta_1 = new Cuenta("Álvaro Madrid");
        Cuenta cuenta_2 = new Cuenta("Fernando Díaz", 300);

        //Mostramos información sobre los saldos en el momento del alta
        System.out.println("Momento 0: Alta de cuentas \n" + cuenta_1 + "\n" + cuenta_2);

        //Ingresa dinero en las cuentas
        cuenta_1.ingresar(300);
        cuenta_2.ingresar(400);

        //Mostramos información sobre los saldos en el momento del ingreso
        System.out.println("\nMomento 1: Ingreso \n" + cuenta_1 + "\n" + cuenta_2);

        //Retiramos dinero en las cuentas
        cuenta_1.retirar(500);
        cuenta_2.retirar(100);

        //Mostramos información sobre los saldos en el momento de la retirada
        System.out.println("\nMomento 2: Retirada \n" + cuenta_1 + "\n" + cuenta_2);

    }
}
