package es.uned.master.java.bancaonlineuned.controlador;

import es.uned.master.java.bancaonlineuned.modelo.Clientes;
import es.uned.master.java.bancaonlineuned.modelo.ClientesDAO;

import java.io.IOException;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

    @WebServlet(name = "Controlador", value = "/Controlador")
    public class Controlador extends HttpServlet {
        ClientesDAO dao = new ClientesDAO();
        Clientes c = new Clientes();
        int r;

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String accion = request.getParameter("submit");
            if (accion.equals("Siguiente")) {
                String dni = request.getParameter("dni");
                int telefono = Integer.parseInt(request.getParameter("movil"));
                String email = request.getParameter("email1");
                String email2 = request.getParameter("email2");
                String direccion=request.getParameter("direccion");
                String nombbre=request.getParameter("nombre");
                c.setDni(dni);
                c.setTelefono(telefono);
                c.setEmail(email);
                c.setEmail2(email2);
                c.setDireccion(direccion);
                if (dao.validacionDNI(dni) && dao.validacionTelefono(telefono) && dao.validarEmail(email,email2)) {
                    request.getRequestDispatcher("segunda.jsp").forward(request, response);

                } else {

                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
            }
        }
    }
