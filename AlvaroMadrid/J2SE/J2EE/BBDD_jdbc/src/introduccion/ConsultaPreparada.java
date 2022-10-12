package introduccion;

import java.sql.*;

public class ConsultaPreparada {

    public static void main(String[] args) {

        try{
            // 1. Crear conexión
            Connection conexion = DriverManager.getConnection("jdbc:mariadb://localhost:3306/prueba", "root", "");

            // 2. Preparar consulta
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM productos WHERE id=?");

            // 3. Establecer parámetros
            ps.setString(1, "A2");

            // 4. Ejecutar instrucción SQL
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString(1) + ": " + rs.getString(2));
            }
            rs.close();

            // Reutilización de consulta SQL
            System.out.println("\nSegunda ejecución de consulta:\n");
            ps.setString(1, "A1");
            rs=ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString(1) + ": " + rs.getString(2));
            }
            rs.close();

        } catch(SQLException e){
            e.printStackTrace();
        }

    }

}
