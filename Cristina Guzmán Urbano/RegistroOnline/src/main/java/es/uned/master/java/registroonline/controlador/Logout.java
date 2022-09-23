package es.uned.master.java.registroonline.controlador;
/**
 * @author: Cristina Guzman Urbano
 * @version: 03/08/2022
 * @Description: Servlet que sirve para manejar el fin de sesión
 */
import es.uned.master.java.registroonline.modelo.RegistroExcepciones;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "Logout", value = "/Logout")
public class Logout extends HttpServlet {
    /**
     *
     * @param request
     * @param response
     *
     */
    //Ya sea que el método sea por GET o POST, se cierra la sesion.
    protected void processRequest(HttpServletRequest request, HttpServletResponse response){
        HttpSession sesion = request.getSession(true);

        //Se cierra la sesion
        sesion.invalidate();

        //Se redirecciona a login.jsp
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        processRequest(request, response);
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
        processRequest(request, response);
    }
}
