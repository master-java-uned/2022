package uned.master.java.crud.controlador;

import uned.master.java.crud.modelo.ConsultasUsuarios;
import uned.master.java.crud.modelo.Usuario;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * El servlet 'LoginUsuario' se utiliza para recoger los paramétros informados en 'login.jsp' y acceder al portal de usuario.
 * <p>A través del método POST, se evalúa si el usuario y contraseña son correctos. Solo en ese caso, se redigire a 'portal.jsp'.</p>
 * <p>En cualquier otro caso, se redigire a la misma página para que el usuario informe correctamente el usuario y la contraseña</p>
 */
@WebServlet(name = "LoginUsuario", value = "/LoginUsuario")
public class LoginUsuario extends HttpServlet {

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

        String usuario = request.getParameter("usuario");
        String contra = request.getParameter("contra");

        if(usuario != "" && contra != ""){
            Usuario nuevoUsuario = new Usuario();
            nuevoUsuario.setUsuario(usuario);
            nuevoUsuario.setContrasena(contra);

            String exito = registro.existeUsuario(nuevoUsuario);
            request.setAttribute("success", 0);

            if(exito.equals("1")){
                HttpSession session = request.getSession();
                session.setAttribute("usuario", usuario);
                session.setAttribute("contra", contra);
                response.sendRedirect(request.getContextPath() + "/portal.jsp");

            } else{
                response.sendRedirect(request.getContextPath() + "/login.jsp");
            }
        } else{
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }
}
