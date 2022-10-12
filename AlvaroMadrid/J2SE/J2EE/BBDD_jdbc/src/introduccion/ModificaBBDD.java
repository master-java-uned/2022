package introduccion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ModificaBBDD {

    public static void main(String[] args) {

        try{

            // 1. CREAR CONEXIÓN CON LA BASE DE DATOS

            Connection miConexion = DriverManager.getConnection("jdbc:mariadb://localhost:3306/prueba", "root", "");

            // 2. CREAR STATEMENT

            Statement miStatement = miConexion.createStatement();

            //String instruccionSql = "INSERT INTO productos (id, precio) VALUES ('A1', 12)";
            // String instruccionSql = "UPDATE productos SET precio=40 WHERE id='A2'";
            //String instruccionSql = "DELETE FROM productos WHERE id='A1'";

            //miStatement.executeUpdate(instruccionSql);

            //System.out.println("Datos insertados correctamente");
            //System.out.println("Datos modificados correctamente");
            System.out.println("Datos eliminados correctamente");

            ResultSet datosInsert = miStatement.executeQuery("SELECT * FROM productos ORDER BY id");

            while (datosInsert.next()){

                System.out.println(datosInsert.getString(1) + ": " + datosInsert.getInt(2));

            }


        }catch(Exception e){
            System.out.println("No conecta:");
            e.printStackTrace();
        }


    }

}
