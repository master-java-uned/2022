package uned.master.java.crud.controlador;

import uned.master.java.crud.modelo.ConsultasUsuarios;
import uned.master.java.crud.modelo.Usuario;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * El servlet 'ModificaUsuario' se utiliza para recoger la nueva contraseña indicada en 'modifica.jsp' y actualizar este campo en la BD.
 * <p>A través del método POST, se evalúa si el usuario tiene una sesión abierta (tras haber iniciado sesión), y se modifica la contraseña.</p>
 * <p>Si hubiera un error en el cambio, se redirige al cliente a 'portal_error.jsp'.</p>
 * <p>En el caso de que la contraseña se modifique exitosamente, se redirige a 'portal_success.jsp', donde el cliente vuelve al portal de usuario.</p>
 */
@WebServlet(name = "ModificaUsuario", value = "/ModificaUsuario")
public class ModificaUsuario extends HttpServlet {

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

        if(request.getSession().getAttribute("usuario") == null){
            response.sendRedirect(request.getContextPath() + "/welcome.jsp");
        } else {
            String usuario = (String) request.getSession().getAttribute("usuario");
            String contra = request.getParameter("contra");

            Usuario modificaUsuario = new Usuario();
            modificaUsuario.setUsuario(usuario);
            modificaUsuario.setContrasena(contra);

            RequestDispatcher dispatcher;

            boolean exito = registro.modificaUsuario(modificaUsuario);

            if(exito && request.getSession().getAttribute("usuario") != null){
                dispatcher = request.getRequestDispatcher("/portal_success.jsp");
            } else{
                dispatcher = request.getRequestDispatcher("/portal_error.html");
            }
            dispatcher.forward(request, response);

        }

    }
}
