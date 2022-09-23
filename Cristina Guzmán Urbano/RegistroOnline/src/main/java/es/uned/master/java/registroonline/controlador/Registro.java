package es.uned.master.java.registroonline.controlador;
/**
 * @author: Cristina Guzman Urbano
 * @version: 03/08/2022
 * @Description: Servlet que sirve para manejar el registro de usuarios nuevos
 */
import es.uned.master.java.registroonline.modelo.RegistroExcepciones;
import es.uned.master.java.registroonline.modelo.Usuario;
import es.uned.master.java.registroonline.modelo.UsuarioDao;
import es.uned.master.java.registroonline.modelo.Validador;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "Registro", value = "/Registro")
public class Registro extends HttpServlet{
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
            throw new RegistroExcepciones(3);
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

        if (accion.equals("Insertar")) {
            //Declaro e inicio las variables
            String nombreUsuario = request.getParameter("name");
            String apellidosUsuario = request.getParameter("surname");
            String emailUsuario = request.getParameter("email");
            String password = request.getParameter("password1");
            String confirm_password = request.getParameter("password2");

            // Se comienza con las validaciones

            // Hay que comprobar que no hayan campos vacios
            if(nombreUsuario.isEmpty() || apellidosUsuario.isEmpty() || emailUsuario.isEmpty() || password.isEmpty() || confirm_password.isEmpty()){
                respuesta.setAttribute("error", "Hay campos vacíos");

            } else {

                Validador v = new Validador();
                //Si no hay campos vacios, se comprueba que la direccion de email sea válida
                if (v.isEmailValid(emailUsuario)) {

                    //Si la direccion de email es correcta, se verifica que la contraseña tambien lo sea
                    if(v.isPasswordValid(password))
                    {
                        //Ahora se verifica que la contraseña 1 y la contraseña 2 son iguales
                        if(password.equals(confirm_password)){
                            UsuarioDao dao = new UsuarioDao();

                            if(dao.isEmailRegistered(emailUsuario)){
                                respuesta.setAttribute("error", "Esta dirección de correo ya fue registrada");
                            } else {

                                //Llegado a este punto significa que los datos son correctos, por lo que se inserta el registro
                                dao.insertar(emailUsuario, password, nombreUsuario, apellidosUsuario);
                                respuesta.setAttribute("error", null);

                                //Si hay una sesion activa se redirige al listado de usuarios y si no, a la pagina de inicio
                                if(  respuesta.getAttribute("EstadoSesion")!="Activo"){
                                    try {
                                        request.getRequestDispatcher("login.jsp").forward(request,response);
                                    } catch (ServletException e) {
                                        throw new RegistroExcepciones(4);
                                    } catch (IOException e) {
                                        throw new RegistroExcepciones(4);
                                    }
                                }
                                else{
                                    List<Usuario> list=dao.listar();
                                    request.setAttribute("listUsers", list);
                                    try {
                                        request.getRequestDispatcher("listUsers.jsp").forward(request,response);
                                    } catch (ServletException e) {
                                        throw new RegistroExcepciones(4);
                                    } catch (IOException e) {
                                        throw new RegistroExcepciones(4);
                                    }
                                }
                            }



                        } else {
                            respuesta.setAttribute("error", "Las contraseñas no son iguales");
                        }

                    } else {
                        respuesta.setAttribute("error", "Contraseña no válida. " +
                                "La contraseña debe tener entre 6 y 16 caracteres, " +
                                "al menos un dígito, al menos una minúscula y al menos una mayúscula. " +
                                "NO puede tener otros símbolos.");
                    }

                } else{
                    respuesta.setAttribute("error", "La dirección de email no es correcta");
                }
            }
        }
        // Si se pulsa en el botón Regresar se tiene que comprobar si hay una sesión activa y en base a ello,
        // se redirige a una pagina o a otra
        else if(accion.equals("Regresar")){
            if(  respuesta.getAttribute("EstadoSesion")!="Activo"){
                try {
                    request.getRequestDispatcher("login.jsp").forward(request,response);
                } catch (ServletException e) {
                    throw new RegistroExcepciones(1);
                } catch (IOException e) {
                    throw new RegistroExcepciones(2);
                }
            }
            else{
                UsuarioDao dao = new UsuarioDao();
                List<Usuario> list=dao.listar();
                request.setAttribute("listUsers", list);

                try {
                    request.getRequestDispatcher("listUsers.jsp").forward(request,response);
                } catch (ServletException e) {
                    throw new RegistroExcepciones(3);
                } catch (IOException e) {
                    throw new RegistroExcepciones(4);
                }
            }
        }

        try {
            request.getRequestDispatcher("register.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RegistroExcepciones(2);
        } catch (IOException e) {
            throw new RegistroExcepciones(4);
        }
    }
}

