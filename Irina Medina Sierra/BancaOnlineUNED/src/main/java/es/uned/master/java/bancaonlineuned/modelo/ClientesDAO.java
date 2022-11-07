package es.uned.master.java.bancaonlineuned.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class ClientesDAO {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    Vector errores=new Vector<>();

    public boolean validacionDNI(String dni){
        String DIGITO_CONTROL = "TRWAGMYFPDXBNJZSQVHLCKE";
        String letraDni= String.valueOf(dni.charAt(8)).toUpperCase();
        String letraCalculada= String.valueOf(DIGITO_CONTROL.charAt(Integer.parseInt(dni.substring(0, 8)) % 23));
        if(letraDni.equals(letraCalculada)){
            return true;
        }else{
            errores.add("El número de DNI no es valido");
            return false;

        }
    }
    public  boolean validacionTelefono(int telefono){
        String tel=String.valueOf(telefono);
        boolean r=false;
        if (tel.substring(0,1)!="6" || tel.substring(0,1)!="7" || tel.substring(0,1)!="8" || tel.substring(0,1)!="9" ){
            r=true;
            //validamos que el telefono no comience por 6-7-8-9, en caso de no cumplir envia true
        }else{
            errores.add("Existe un error en el número de Teléfono");
        }
        return r;
    }

   public boolean validarEmail(String email,String email2) {
        if (email.equals(email2)) {
           // Los email son iguales
            return true; }
        else {
            //Los Email son diferentes
            errores.add("Los email y la confirmación de Email no son iguales.");
            return false;}
    }
    public boolean validacionTextos(String nombre,String apellidos,String dirección){
        if (nombre.isEmpty() || apellidos.isEmpty() || dirección.isEmpty()){
            //alguno de los textos estan vacios.
            return false;
        }else{
           //Los campos de textos no estan vacios
            return true;
        }
    }
public boolean validacionEdad(short edad){
        boolean r=false;
        if(edad>=18){
            //La edad es mayor de 18 años");
            return true;
        }else {
            //La edad es menor a 18 años
        return false;}
}

    public int registrar(Clientes clientes) {
        int numeroRegistro = 0;
        System.out.println(clientes.getNombre()+"-"+clientes.getEmail());
            String sql = "INSERT INTO BancaOnline.clientes (nombre,apellidos,edad,dni,direccion,email,telefono) VALUES (?,?,?,?,?,?,?);";
            try {
                con = cn.Conectar();
                ps = con.prepareStatement(sql);
                ps.setString(1, clientes.getNombre());
                ps.setString(2, clientes.getApellidos());
                ps.setShort(3, clientes.getEdad());
                ps.setString(4, clientes.getDni());
                ps.setString(5, clientes.getDireccion());
                ps.setString(6, clientes.getEmail());
                ps.setInt(7, clientes.getTelefono());

                ps.executeUpdate();
                numeroRegistro=1;


            } catch (Exception e) {
                return numeroRegistro;
            }
        return numeroRegistro;
    }
    
    
}
