package uned.master.java.crud.controlador;

import uned.master.java.crud.modelo.ConsultasUsuarios;
import uned.master.java.crud.modelo.Usuario;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * El servlet 'EliminaUsuario' se utiliza para recoger los paramétros informados en 'elimina.jsp' y eliminar así el usuario de la BD.
 * <p>A través del método POST, se evalúa si el usuario tiene una sesión abierta (tras haber iniciado sesión) y si la contraseña es correcta para eliminar al usuario de la BD.</p>
 * <p>Si hubiera un error en el alta, se redirige al cliente a la misma página 'elimina.jsp'.</p>
 * <p>En el caso de que el usuario se elimine exitosamente, se redirige a 'welcome.jsp', donde el cliente puede volver a crear un usuario o iniciar sesión con otro usuario diferente.</p>
 */
@WebServlet(name = "EliminaUsuario", value = "/EliminaUsuario")
public class EliminaUsuario extends HttpServlet {

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

            Usuario eliminaUsuario = new Usuario();
            eliminaUsuario.setUsuario(usuario);
            eliminaUsuario.setContrasena(contra);

            RequestDispatcher dispatcher;

            boolean exito = registro.eliminaUsuario(eliminaUsuario);

            if(exito && request.getSession().getAttribute("usuario") != null){
                dispatcher = request.getRequestDispatcher("/welcome.jsp");
            } else{
                dispatcher = request.getRequestDispatcher("/elimina.jsp");
            }
            dispatcher.forward(request, response);

        }



    }
}
