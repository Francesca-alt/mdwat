package s09;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.LocalTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/s09/greeter")
public class Greeter extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();// tomcat vede che c'è il cookie prepara la session a questa request;facciamo la get di un attributo che non sappiamo cosa c'è dentro, mi ritorna null;
        LocalTime start = (LocalTime) session.getAttribute("start");

        Duration duration;
        if (start == null) {
            duration = Duration.ZERO; // se non si era mai collegato sarà 0;
            session.setAttribute("start", LocalTime.now()); // mi collego per la prima volta;
        } else {
            duration = Duration.between(start, LocalTime.now()); // duration il gap dalla prima volta e l'ultima acui ti sei collegato;
        }

        if (request.getParameter("done") == null) { // vedo se l'utente mi ha passato parametri;
            request.setAttribute("duration", duration); // l'attributo duration lo metto in request;
            RequestDispatcher rd = request.getRequestDispatcher("/s09/greeter.jsp");
            rd.forward(request, response);
        } else {
            session.invalidate(); // chiamo il metodo invalide, mi disconetto chiamo l'uscita da quella sessione;

            response.setContentType("text/html");
            response.setCharacterEncoding("utf-8");
            try (PrintWriter writer = response.getWriter()) {
                writer.println("<!DOCTYPE html><html>");
                writer.println("<head><meta charset=\"utf-8\">");
                writer.println("<title>So long</title></head>");
                writer.println("<body><h1>Goodbye</h1>");
                writer.println("<p>You worked on this stuff for " + duration.getSeconds() + " seconds</p>");
                writer.println("</body></html>");
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
