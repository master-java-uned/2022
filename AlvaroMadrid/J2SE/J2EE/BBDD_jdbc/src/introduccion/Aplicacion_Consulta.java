package introduccion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class Aplicacion_Consulta {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        JFrame mimarco=new Marco_Aplicacion();

        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mimarco.setVisible(true);

    }

}

class Marco_Aplicacion extends JFrame{

    public Marco_Aplicacion(){

        setTitle ("Consulta BBDD");

        setBounds(500,300,400,400);

        setLayout(new BorderLayout());

        JPanel menus=new JPanel();

        menus.setLayout(new FlowLayout());

        secciones=new JComboBox();

        secciones.setEditable(false);

        secciones.addItem("Todos");

        paises=new JComboBox();

        paises.setEditable(false);

        paises.addItem("Todos");

        resultado= new JTextArea(4,50);

        resultado.setEditable(false);

        add(resultado);

        menus.add(secciones);

        menus.add(paises);

        add(menus, BorderLayout.NORTH);

        add(resultado, BorderLayout.CENTER);

        JButton botonConsulta=new JButton("Consulta");
        botonConsulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ejecutaConsulta();
            }
        });

        add(botonConsulta, BorderLayout.SOUTH);


        // ----------CONEXIÓN CON BBDD----------

        try{

            Statement statement = connection.createStatement();

            // Carga JComboBox Sección

            String consulta = "SELECT DISTINCT SECCION FROM productos";
            ResultSet resultSet = statement.executeQuery(consulta);

            while(resultSet.next()){
                secciones.addItem(resultSet.getString(1));
            }
            resultSet.close();

            // Carga JComboBox Sección

            consulta = "SELECT DISTINCT PAIS FROM productos";
            resultSet = statement.executeQuery(consulta);
            while(resultSet.next()){
                paises.addItem(resultSet.getString(1));
            }
            resultSet.close();

        }catch(Exception e){
            System.out.println("Ha habido un error");
            e.printStackTrace();
        }

    }

    private void ejecutaConsulta(){

        ResultSet rs = null;
        try{

            resultado.setText("");
            String seccion = (String) secciones.getSelectedItem();
            String pais = (String) paises.getSelectedItem();

            if(!seccion.equals("Todos") && pais.equals("Todos")) {

                enviaConsultaSeccion = connection.prepareStatement(consultaSeccion);
                enviaConsultaSeccion.setString(1, seccion);
                rs = enviaConsultaSeccion.executeQuery();

            } else if(seccion.equals("Todos") && !pais.equals("Todos")){

                enviaConsultaPais = connection.prepareStatement(consultaPais);
                enviaConsultaPais.setString(1, pais);
                rs = enviaConsultaPais.executeQuery();

            } else if(!seccion.equals("Todos") && !pais.equals("Todos")){

                enviaConsultaTodos = connection.prepareStatement(consultaTodos);
                enviaConsultaTodos.setString(1, seccion);
                enviaConsultaTodos.setString(2, pais);
                rs = enviaConsultaTodos.executeQuery();

            }

            while(rs.next()){
                resultado.append(rs.getString(1));
                resultado.append(", ");
                resultado.append(rs.getString(2));
                resultado.append(", ");
                resultado.append(rs.getString(3));
                resultado.append(", ");
                resultado.append(rs.getString(4));
                resultado.append("\n");
            }

            rs.close();

        }catch(Exception e){

        }
    }

    private Connection connection;

    {
        try {
            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/curso_sql", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private PreparedStatement enviaConsultaSeccion;
    private PreparedStatement enviaConsultaPais;
    private PreparedStatement enviaConsultaTodos;

    private final String consultaSeccion="SELECT NOMBRE, SECCION, PRECIO, PAIS FROM productos WHERE SECCION=?";
    private final String consultaPais="SELECT NOMBRE, SECCION, PRECIO, PAIS FROM productos WHERE PAIS=?";
    private final String consultaTodos="SELECT NOMBRE, SECCION, PRECIO, PAIS FROM productos WHERE SECCION=? AND PAIS=?";

    private JComboBox secciones;
    private JComboBox paises;
    private JTextArea resultado;

}