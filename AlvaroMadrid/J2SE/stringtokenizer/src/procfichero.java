import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class procfichero {
    private List<Persona> personal;

        // Gestiona una línea
        // La líena debe contemplar los parámetros <nombre>|<NIF>|<Sueldo>
        // Devuelve error en caso que el fichero este mal formateado -> ExceptionMia
        // Entrada String de la línea
        // Saluda Persona con los datos de la línea.
        private Persona procesaLinea(String linea){
            StringTokenizer lineaToken = new StringTokenizer(linea," |");
            try{
                Persona persona = new Persona(lineaToken.nextToken(), lineaToken.nextToken(), (int lineaToken.nextToken());
            }catch (Exception e){
                throw new ExcepcionMia("Error en el formato de fichero");
            }
        }

        // Procesa un fichero con el formato ...
        // Lectura con control de error
        // Mandar a out los error (FIN).Client

    public void procesa() throws ExceptionMia{
        this.personal = new ArrayList<Persona>(); // Al contructor!

        try{
            FileReader entrada = new FileReader("/Users/alvaromadrid/Desktop/JavaProgramming/clientes/ej_ficheros/fichero_input.txt");

            BufferedReader mibuffer = new BufferedReader(entrada);


            String linea = "";
            while( (linea = mibuffer.readLinea()) != null){
                this.personal.add(this.procesaLinea(linea));
            }

        } catch (IOException e){
            System.out.println("No se ha encontrado el archivo");

        } catch (ExceptionMia e){
            System.out.printl("Error de lectura de fichero");
        }

    }

}
