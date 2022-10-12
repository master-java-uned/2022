package coche;

import javax.swing.*;

public class Uso_Vehiculo {

    public static void main(String[] args) {

        /*
        Coche micoche1 = new Coche();
        micoche1.establece_color(JOptionPane.showInputDialog("Introduce color"));
        System.out.println(micoche1.dime_datos_generales());

        System.out.println(micoche1.dime_color());
        micoche1.configura_asientos(JOptionPane.showInputDialog("¿Tiene asientos de cuero"));
        System.out.println(micoche1.dime_asientos());

        micoche1.configura_climatizador(JOptionPane.showInputDialog("¿Tiene climatizador"));
        System.out.println(micoche1.dime_climatizador());

        System.out.println(micoche1.dime_peso_coche());

        System.out.println("El precio final del coche es: " + micoche1.precio_coche());
         */

        Coche micoche1 = new Coche();
        micoche1.establece_color("rojo");

        Furgoneta mifurgoneta1 = new Furgoneta(7, 580);
        mifurgoneta1.establece_color("azul");
        mifurgoneta1.configura_asientos("Si");
        mifurgoneta1.configura_climatizador("Si");

        System.out.println(micoche1.dime_datos_generales() + " " + micoche1.dime_color());
        System.out.println(mifurgoneta1.dime_datos_generales() + " " + mifurgoneta1.dimeDatosFurgoneta());
    }
}
