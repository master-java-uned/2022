package filestream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import clientes.Cliente;
import errores.ExcepClientes;

public class inputFichero {

    // Declaramos una Lista para cargar la información de los clientes
    private List<Cliente> listado;

    /**
     * Método constructor de clase
     */
    public inputFichero() {
        List<Cliente> listado = new ArrayList<Cliente>();
        this.listado = listado;
    }
    /**
     * Método procesaLinea: a través de StringTokenizer, crea un objeto Cliente para cada línea del fichero
     * @param linea
     * @return cliente
     */
    private Cliente procesaLinea(String linea){
        StringTokenizer lineaToken = new StringTokenizer(linea, " |");
        try{
            Cliente cliente = new Cliente(lineaToken.nextToken(), lineaToken.nextToken(), Integer.parseInt(lineaToken.nextToken()));
            return cliente;
        }catch (Exception e){
            throw new ExcepClientes("Revisa el formato del fichero");
        }
    }

    /**
     * Método void procesa: lee el fichero, y añade a List un cliente del método 'procesaLinea'
     * @throws ExcepClientes
     */
    public void procesa() throws ExcepClientes{

        try{

            FileReader entrada = new FileReader("/Users/alvaromadrid/Desktop/JavaProgramming/clientes/ej_ficheros/fichero_input.txt");
            BufferedReader mibuffer = new BufferedReader(entrada);

            String linea = "";
            while((linea = mibuffer.readLine()) != null){
                listado.add(procesaLinea(linea));
            }

        } catch (IOException e){
            System.out.println("No se ha encontrado el archivo");
        }

        System.out.println("Se han cargado " + listado.size() + " líneas desde el fichero con la siguiente información:");
        for(int i=0; i<listado.size(); i++){
            System.out.println(i+1+")\n" + listado.get(i).getNombre()
                    + "\nDNI: " + listado.get(i).getIdNac()
                    + "\nConsumo: " + listado.get(i).getConsumo() + " €\n");
        }

    }

}
