package es.uned.master.java;

import es.uned.master.java.caracteristicas.Categoria;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.*;

import static es.uned.master.java.caracteristicas.Categoria.*;
import static es.uned.master.java.caracteristicas.Estado.*;

public abstract class Tienda { //PRIMERA CLASE ABSTRACTA

    public static List<Herramienta> herramientas = new ArrayList<>();

    public static void AltaHerramienta() {

        System.out.println("· ALTA DE HERRAMIENTA \n Por favor, indique el número de herramientas a dar de alta");
        Scanner inputs = new Scanner(System.in);
        int numInputs = inputs.nextInt();

        for(int i=0; i<numInputs; i++){
            Scanner alta = new Scanner(System.in);
            byte altaInput = 0;

            while (altaInput < 1 || altaInput > 3) {
                System.out.println("· ALTA DE HERRAMIENTA \n Por favor, indique la categoría de la herramienta: \n 1) Limpieza \n 2) Obra \n 3) Pintura");
                altaInput = alta.nextByte();
            }

            Categoria altaCategoria;

            if (altaInput == 1) {
                altaCategoria = LIMPIEZA;
            } else if (altaInput == 2) {
                altaCategoria = OBRA;
            } else {
                altaCategoria = PINTURA;
            }

            Scanner altaFecha = new Scanner(System.in);
            String fechaInp;
            boolean fechaForm = false;
            LocalDate altaFechaForm = null;

            do {
                try {
                    System.out.println("· ALTA DE HERRAMIENTA \n Por favor, indique la fecha de adquisición: AAAA-MM-DD");
                    fechaInp = altaFecha.next();
                    altaFechaForm = LocalDate.parse(fechaInp);
                    fechaForm = true;

                } catch (Exception e) {
                    System.out.println("Respete el formato de fecha: AAAA-MM-DD");
                }
            } while (!fechaForm);

            herramientas.add(new Herramienta(altaCategoria, DISPONIBLE, altaFechaForm));

        }


    }

    public static void AlquilarHerramienta() {
        Scanner alquilerId = new Scanner(System.in);
        String inputId;

        System.out.println("· ALQUILER DE HERRAMIENTA \n Introduzca el ID de la herramienta: ");
        inputId = alquilerId.nextLine();


        // stream () - lambda
        String finalInputId = inputId;
        herramientas.stream().filter(herramienta -> herramienta.getNumeroDeReferencia().equals(finalInputId))
                .filter(herramienta -> herramienta.getEstado().equals("DISPONIBLE"))
                .findFirst()
                .ifPresent(herramienta ->{
                    System.out.println("¡El artículo está disponible para alquilar!");
                    Scanner fechaInAlqSc = new Scanner(System.in);
                    String inputFechaInAlq = "";
                    System.out.println("\nInserte la fecha de inicio del alquiler");
                    inputFechaInAlq = fechaInAlqSc.nextLine();

                    Scanner fechaFinAlqSc = new Scanner(System.in);
                    String inputFechaFinAlq = "";
                    System.out.println("Inserte la fecha fin del alquiler");
                    inputFechaFinAlq = fechaFinAlqSc.nextLine();

                    herramienta.setEstado(ALQUILADO);
                });

    }



    public static void ListarHerramienta(){
        for(int j=0; j<herramientas.size(); j++) {
            System.out.println(herramientas.get(j));
        }
    }

    public static String imprimirHerramienta(){
        return herramientas.toString();
    }

}
