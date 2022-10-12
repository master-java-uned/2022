package transacciones;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejemplo_Transaccion {

    public static void main(String[] args) {

        Connection miConexion = null;
        try{
            miConexion= DriverManager.getConnection("jdbc:mariadb://localhost:3306/curso_sql", "root", "");
            // Indico que las instrucciones SQL se deben tratar como bloque
            miConexion.setAutoCommit(false);

            Statement miStatement =miConexion.createStatement();

            String instruccionSql_1="DELETE FROM productos WHERE PAIS='ITALIA'";

            String instruccionSql_2="DELETE FROM productos WHERE PRECIO>300";

            String instruccionSql_3="UPDATE productos SET PRECIO=PRECIO*1.15";

            boolean ejecutar = ejecutar_transaccion();
            if (ejecutar){
                miStatement.executeUpdate(instruccionSql_1);
                miStatement.executeUpdate(instruccionSql_2);
                miStatement.executeUpdate(instruccionSql_3);
                miConexion.commit();
                System.out.println("Se ejecutó la transacción correctamente");
            } else {
                System.out.println("No se realizó ningún cambio en la base de datos");
            }

        }catch(Exception e){

            try {
                miConexion.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            System.out.println("Algo salió mal...");
        }
    }

    static boolean ejecutar_transaccion(){

        String ejecucion = JOptionPane.showInputDialog("¿Ejecutamos transacción?");
        if(ejecucion.equals("Sí")) return true;
        else return false;

    }

}
