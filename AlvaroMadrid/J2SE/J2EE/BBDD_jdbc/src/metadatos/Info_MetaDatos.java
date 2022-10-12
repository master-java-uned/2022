package metadatos;

import java.sql.*;

public class Info_MetaDatos {

    public static void main(String[] args) {

        //mostrarInfo_BBDD();
        mostrarInfo_Tabla();

    }

    static void mostrarInfo_BBDD(){
        Connection miConexion = null;
        try{
            miConexion= DriverManager.getConnection("jdbc:mariadb://localhost:3306/prueba", "root", "");

            //Obtención de metadatos
            DatabaseMetaData datosBBDD=miConexion.getMetaData();

            //Mostramos información de la BBDD
            System.out.println("Gestor de la BBDD: " + datosBBDD.getDatabaseProductName());
            System.out.println("Versión del gestor: " + datosBBDD.getDatabaseProductVersion());
            System.out.println("Nombre del driver: " + datosBBDD.getDriverName());
            System.out.println("Versión del driver: " + datosBBDD.getDriverVersion());


        }catch(Exception e){
            e.printStackTrace();
        } finally{
            try {
                miConexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    static void mostrarInfo_Tabla(){
        Connection miConexion = null;
        ResultSet resultSet = null;
        try {
            miConexion = DriverManager.getConnection("jdbc:mariadb://localhost:3306/curso_sql", "root", "");

            //Obtención de metadatos
            DatabaseMetaData datosBBDD = miConexion.getMetaData();

            //Lista de tablas
            System.out.println("Lista de tablas: ");
            resultSet=datosBBDD.getTables("curso_sql", null, "prod%", null);
            while(resultSet.next()){
                System.out.println(resultSet.getString("TABLE_NAME"));
            }

            //Lista de columnas de productos
            System.out.println("\nCampos de Productos:");
            resultSet=datosBBDD.getColumns("curso_sql", null, "productos", null);
            while(resultSet.next()){
                System.out.println(resultSet.getString("COLUMN_NAME"));
            }

        }catch(Exception e){
            e.printStackTrace();
        } finally{
            try {
                miConexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
