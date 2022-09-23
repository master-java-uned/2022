package es.uned.master.java.registroonline.controlador;
/**
 * @author: Cristina Guzman Urbano
 * @version: 23/08/2022
 * @Description: Servlet que sirve para controlar la modificación y borrado de elementos
 */

import es.uned.master.java.registroonline.modelo.RegistroExcepciones;
import es.uned.master.java.registroonline.modelo.Usuario;
import es.uned.master.java.registroonline.modelo.UsuarioDao;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Controlador", value = "/Controlador")
public class Controlador extends HttpServlet {

    /**
     *
     * @param request   an {@link HttpServletRequest} object that
     *                  contains the request the client has made
     *                  of the servlet
     *
     * @param response  an {@link HttpServletResponse} object that
     *                  contains the response the servlet sends
     *                  to the client
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        /* En este proyecto; este servlet no recibe ni debe recibir nada por GET,
         * asi que si se lleva a entrar al servelt
         * usando el metodo GET solamente redireccion al login.jsp
         */
        try {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath () + "/login.jsp"));
        } catch (IOException e) {
            throw new RegistroExcepciones(2);
        }
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
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        HttpSession respuesta = request.getSession(true);
        respuesta.setAttribute("error", null);
        String accion=request.getParameter("accion");
        UsuarioDao dao = new UsuarioDao();
        // Si se presiona en el icono Actualizar
        if (accion.equals("Actualizar")) {

            // Se obtienen los nuevos valores
            String nombreUsuario = request.getParameter("name");
            String apellidosUsuario = request.getParameter("surname");
            String emailUsuario = request.getParameter("email");

            if(nombreUsuario.isEmpty() || apellidosUsuario.isEmpty()){
                respuesta.setAttribute("error", "Hay campos vacíos");
            } else{
                // Se crea un Usuario nuevo con los datos obtenidos
                Usuario user = new Usuario(nombreUsuario, apellidosUsuario, emailUsuario);
                // Se llama a la funcion dandole el Objeto Usuario creado
                dao.editar(user);
            }
        }
        // Si se presiona en el icono Eliminar
        else if (accion.equals("Eliminar")) {
            // Se llama a la funcion dandole el parametro email
            dao.eliminar(request.getParameter("email"));
        }

        // En ambos casos, se redirige al acabar a la pagina del listado de usuarios

        List<Usuario> list=dao.listar();
        request.setAttribute("listUsers", list);
        try {
            request.getRequestDispatcher("listUsers.jsp").forward(request,response);
        } catch (IOException e) {
            throw new RegistroExcepciones(4);
        } catch (ServletException e) {
            throw new RegistroExcepciones(3);
        }

    }
}
