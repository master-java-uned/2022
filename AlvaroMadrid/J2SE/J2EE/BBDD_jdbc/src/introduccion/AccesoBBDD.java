package introduccion;

import java.sql.*;

public class AccesoBBDD {

    public static void main(String[] args) {

        try{

            // 1. CREAR CONEXIÓN CON LA BASE DE DATOS

            Connection miConexion = DriverManager.getConnection("jdbc:mariadb://localhost:3306/prueba", "root", "");

            // 2. CREAR STATEMENT

            Statement miStatement = miConexion.createStatement();

            // 3. EJECUTAR LA INSTRUCCIÓN SQL

            ResultSet miResultSet=miStatement.executeQuery("SELECT * FROM productos");

            // 4. RECORRER EL RESULTSET

            while (miResultSet.next()){

                System.out.println(miResultSet.getString(1) + ": " + miResultSet.getString(2));

            }


        }catch(Exception e){

            e.printStackTrace();
        }

    }
}
