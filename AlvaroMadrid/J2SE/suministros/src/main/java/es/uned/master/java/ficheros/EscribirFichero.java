package es.uned.master.java.ficheros;

import java.io.*;

public class EscribirFichero {

    public void escribir(String frase){

        try {
            FileWriter escritura = new FileWriter("/Users/alvaromadrid/Desktop/prueba_texto.txt");

            BufferedWriter miwriffer = new BufferedWriter(escritura);

            miwriffer.write(frase);
            miwriffer.flush();

            escritura.close();

            System.out.println("impresion");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

//StringTokenizer