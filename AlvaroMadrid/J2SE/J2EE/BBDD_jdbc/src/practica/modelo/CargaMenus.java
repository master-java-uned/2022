package practica.modelo;

import java.sql.*;

public class CargaMenus {


    public CargaMenus(){

        miConexion=new Conexion();
    }

    public String ejecutaConsultas(){
        Productos miProducto = null;
        Connection accesoBBDD= miConexion.dameConexion();

        try{

            Statement secciones = accesoBBDD.createStatement();
            Statement paises = accesoBBDD.createStatement();
            rs = secciones.executeQuery("SELECT DISTINCT SECCION FROM productos");
            rs2 = paises.executeQuery("SELECT DISTINCT PAIS FROM productos");
            miProducto = new Productos();
            miProducto.setSeccion(rs.getString(1));
            miProducto.setPaisOrigen(rs2.getString(1));
            rs.close();
            rs2.close();

        } catch (Exception e){
            System.out.println("Hay un problema en la ejecución");
        }
        return miProducto.getSeccion();
    }

    public Conexion miConexion;
    public ResultSet rs;
    public ResultSet rs2;
}
