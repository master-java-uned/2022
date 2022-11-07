package es.uned.master.java.bancaonlineuned.controlador;

import es.uned.master.java.bancaonlineuned.modelo.Clientes;
import es.uned.master.java.bancaonlineuned.modelo.ClientesDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.Phaser;

@WebServlet(name = "Controlador2", value = "/Controlador2")
public class Controlador2 extends HttpServlet {
    ClientesDAO dao = new ClientesDAO();
    Clientes c = new Clientes();
    int r;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("enviar");
        int respuesta=0;
        if (accion.equals("Siguiente")) {
            String nombre = request.getParameter("nombre");
            short edad = Short.parseShort(request.getParameter("edad"));
            String apellidos = request.getParameter("apellidos");
            String direccion = request.getParameter("direccion");
            c.setNombre(nombre);
            c.setApellidos(apellidos);
            c.setEdad(edad);
            c.setDireccion(direccion);
            if (dao.validacionTextos(nombre,apellidos,direccion) && dao.validacionEdad(edad) ) {
                respuesta= dao.registrar(c);
                if (respuesta==1) {
                    request.getRequestDispatcher("tercera.jsp").forward(request, response);
                }else{
                    String mensaje="Existe un error al registrar sus datos. Intentelo de nuevo";
                    request.getSession().setAttribute("mensaje",mensaje);
                    request.getRequestDispatcher("index.jsp").forward(request,response);
                }


            } else {
                request.getRequestDispatcher("segunda.jsp").forward(request, response);
            }
        }
    }
}
