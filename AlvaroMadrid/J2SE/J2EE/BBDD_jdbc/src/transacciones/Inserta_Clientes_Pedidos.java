package transacciones;

import java.sql.*;

public class Inserta_Clientes_Pedidos {

    public static void main(String[] args) {

        // Defino el objeto miConexion fuera del try
        Connection miConexion = null;
        try{
            miConexion=DriverManager.getConnection("jdbc:mariadb://localhost:3306/prueba", "root", "");
            // Indico que las instrucciones SQL se deben tratar como bloque
            miConexion.setAutoCommit(false);

            Statement miStatement =miConexion.createStatement();

            String instruccionSql_1="INSERT INTO clientes (CÓDIGOCLIENTE, EMPRESA, DIRECCIÓN) VALUES ('CT84', 'EJEMPLO', 'P BOTANICO')";

            miStatement.executeUpdate(instruccionSql_1);

            String instruccionSql_2="INSERT INTO pedidos (NÚMERODEPEDIDO, CÓDIGOCLIENTE,FECHADEPEDIDO) VALUES('82', 'CT84', '11/03/2000')";

            miStatement.executeUpdate(instruccionSql_2);

            miConexion.commit();

            System.out.println("Datos INSERTADOS correctamente");

        }catch(Exception e){

            System.out.println("ERROR EN LA INSERCIÓN DE DATOS!!");
            try{
                miConexion.rollback();
                System.out.println("Se ha ejecutado un rollback");
            } catch (SQLException e1){
                e1.printStackTrace();
            }
            e.printStackTrace();

        }

    }
}
