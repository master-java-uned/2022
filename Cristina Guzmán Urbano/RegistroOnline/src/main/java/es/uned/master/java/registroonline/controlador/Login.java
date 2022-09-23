package es.uned.master.java.registroonline.controlador;
/**
 * @author: Cristina Guzman Urbano
 * @version: 03/08/2022
 * @Description: Servlet que sirve para manejar el inicio de sesión
 */
import es.uned.master.java.registroonline.modelo.RegistroExcepciones;
import es.uned.master.java.registroonline.modelo.Usuario;
import es.uned.master.java.registroonline.modelo.UsuarioDao;
import es.uned.master.java.registroonline.modelo.Validador;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
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
        respuesta.setAttribute("EstadoSesion", "Desactivo");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Se comienza con las validaciones

        // Hay que comprobar que no hayan campos vacios
        if (email.isEmpty() || password.isEmpty()) {
            respuesta.setAttribute("error", "Hay campos vacíos");
        } else {
            Validador v = new Validador();

            //Si no hay campos vacios, se comprueba que la direccion de email sea válida
            if (v.isEmailValid(email)) {
                //La direccion de email es correcta, se verifica que la contraseña tambien lo sea
                if (v.isPasswordValid(password))
                {
                    UsuarioDao dao = new UsuarioDao();
                    if (dao.isAcountExists(email, password)) {
                        //Significa que la cuenta sí existe, por lo que se activa la sesión y se redirige
                        // a la pagina siguiente
                        respuesta.setAttribute("EstadoSesion", "Activo");

                        List<Usuario> list=dao.listar();
                        request.setAttribute("listUsers", list);
                        try {
                            request.getRequestDispatcher("listUsers.jsp").forward(request,response);
                        } catch (ServletException e) {
                            throw new RegistroExcepciones(3);
                        } catch (IOException e) {
                            throw new RegistroExcepciones(4);
                        }
                    } else {
                        respuesta.setAttribute("error", "Dirección de email y/o contraseña incorrecta");
                    }
                } else {
                    respuesta.setAttribute("error", "Contraseña no válida. " +
                            "La contraseña debe tener entre 6 y 16 caracteres, " +
                            "al menos un dígito, al menos una minúscula y al menos una mayúscula. " +
                            "NO puede tener otros símbolos.");
                }
            } else {
                respuesta.setAttribute("error", "Dirección de email no válida");
            }
        }

        //Si algo sale mal, se redirige a la pagina de inicio
        try {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath () + "/login.jsp"));
        } catch (IOException e) {
            throw new RegistroExcepciones(2);
        }
    }
}