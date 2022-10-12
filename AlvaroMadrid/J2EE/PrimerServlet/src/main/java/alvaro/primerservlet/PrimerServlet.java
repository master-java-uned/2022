package alvaro.primerservlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "PrimerServlet", value = "/PrimerServlet")
public class PrimerServlet extends HttpServlet {

    // DECLARAMOS EL CONSTRUCTOR DE LA SUPERCLASE
    public PrimerServlet(){
        super();
    }

    // SOBREESCRIBIMOS LOS MÉTODOS doGet Y doPost DE HttpServlet
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // ESPECIFICAMOS FORMATO DE RESPUESTA
        PrintWriter printWriter = response.getWriter();
        // GENERAR LA RESPUESTA DE LA PETICIÓN
        printWriter.println("<html><body>");
        printWriter.println("<h1 style='text-align:center'>Prueba Servlet</h1>");
        printWriter.println("");
        printWriter.println("");
        printWriter.println("Fecha y hora actual: " + new Date());
        printWriter.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
