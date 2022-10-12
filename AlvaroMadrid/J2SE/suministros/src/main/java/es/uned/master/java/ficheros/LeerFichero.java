package es.uned.master.java.ficheros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeerFichero {

    public void lee(){

        try {
            FileReader entrada = new FileReader("/Users/alvaromadrid/Desktop/prueba.txt");

            BufferedReader mibuffer = new BufferedReader(entrada);

            String linea = "";
            while(linea != null){
                linea = mibuffer.readLine();
                if(linea!= null) {
                    System.out.println(linea);
                }
            }
            entrada.close();

        } catch (IOException e) {
            System.out.println("No se ha encontrado el archivo");
        }
    }
}