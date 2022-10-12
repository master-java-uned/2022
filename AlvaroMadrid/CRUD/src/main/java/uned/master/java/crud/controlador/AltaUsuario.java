package uned.master.java.crud.controlador;

import uned.master.java.crud.modelo.ConsultasUsuarios;
import uned.master.java.crud.modelo.Usuario;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * El servlet 'AltaUsuario' se utiliza para recoger los paramétros informados en 'welcome.jsp' y crear así un objeto de la clase 'Usuario'.
 * <p>A través del método POST, se evalúa si el usuario ha informado todos los casos. Solo en ese caso, se crea un objeto 'Usuario' a través del método constructor por defecto.</p>
 * <p>Si hubiera un error en el alta, se redirige al cliente a 'error.jsp'. En caso de que el cliente no informe todos los campos, se redigire a la misma página, donde se indica que se deben informar todos los campos.</p>
 * <p>En el caso de que el usuario se cree exitosamente, se redirige a 'login.jsp', donde el cliente puede entrar al portal de usuario.</p>
 */
@WebServlet(name = "AltaUsuario", value = "/AltaUsuario")
public class AltaUsuario extends HttpServlet {

    private ConsultasUsuarios registro = new ConsultasUsuarios();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     *
     * @param request   an {@link HttpServletRequest} object that
     *                  contains the request the client has made
     *                  of the servlet
     *
     * @param response  an {@link HttpServletResponse} object that
     *                  contains the response the servlet sends
     *                  to the client
     *
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String usuario = request.getParameter("usuario");
        String contra = request.getParameter("contra");
        String interes = request.getParameter("interes");

        RequestDispatcher dispatcher;

        if(nombre != "" && apellido != "" && usuario != "" && contra != "" && interes != ""){
            Usuario nuevoUsuario = new Usuario();
            nuevoUsuario.setNombre(nombre);
            nuevoUsuario.setApellido(apellido);
            nuevoUsuario.setUsuario(usuario);
            nuevoUsuario.setContrasena(contra);
            nuevoUsuario.setInteres(interes);

            boolean exito = registro.registraUsuario(nuevoUsuario);

            if(exito){
                dispatcher = request.getRequestDispatcher("/login.jsp");
                dispatcher.forward(request, response);
            } else{
                dispatcher = request.getRequestDispatcher("/error.jsp");
                dispatcher.forward(request, response);
            }
        } else{
            response.sendRedirect(request.getContextPath() + "/welcome.jsp");
        }



    }
}
