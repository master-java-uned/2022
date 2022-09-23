package es.uned.master.java.registroonline.controlador;
/**
 * @author: Cristina Guzman Urbano
 * @version: 10/08/2022
 * @Description: Servlet que sirve para manejar el filtro de sesión
 */
import es.uned.master.java.registroonline.modelo.RegistroExcepciones;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(servletNames = {"Controlador", "Login"})
public class MiFiltro implements Filter {
    /**
     *
     * @param filterConfig a <code>FilterConfig</code> object containing the
     *                     filter's configuration and initialization parameters
     *
     */
    @Override
    public void init(FilterConfig filterConfig) {
        // invoked when an instance of this filter is created by the container
        // used to initialize resources, read parameters...

    }

    /**
     *
     * @param request the <code>ServletRequest</code> object contains the client's request
     * @param response the <code>ServletResponse</code> object contains the filter's response
     * @param chain the <code>FilterChain</code> for invoking the next filter or the resource
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain){
        // invoked when a matching request sent to the server
        // used to intercept the request and transform the response
        HttpSession sesion = ((HttpServletRequest) request).getSession();

        if (request instanceof HttpServletRequest){
            // Si no hay una sesion activada se manda a la pagina de inicio y se muestra un mensaje de error
            if (sesion.getAttribute("EstadoSesion")!="Activo"){

                sesion.setAttribute("error", "Debes iniciar sesion");
                request.getRequestDispatcher("login.jsp");
            }
        }
        try {
            // invokes next filter in the chain
            chain.doFilter(request, response);
        } catch (ServletException e) {
            throw new RegistroExcepciones(7);
        } catch (IOException e) {
            throw new RegistroExcepciones(8);
        }

    }

    /**
     *
     */
    @Override
    public void destroy() {
        // invoked when the filter instance is being destroyed by the container
        // used clean up resources

    }
}