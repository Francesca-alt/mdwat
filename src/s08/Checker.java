package s08;

import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s08/checker")
public class Checker extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("user");// user cos'è? in html name="user in user parametro associato"
        Set<Character> set = new TreeSet<>();// noi ci siamo creati un treeSet vuoto
        if (user != null) {
            for (char c : user.toCharArray()) {
                set.add(Character.toLowerCase(c));
            }
        }
        request.setAttribute("set", set);// ci metto dentro un attributo; collection set non ha duplicati.key value come sono memorizzati attributi in questo nome;

        RequestDispatcher rd = request.getRequestDispatcher("/s08/checker.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)// passo il controllo al jsp;
            throws ServletException, IOException {
        doGet(request, response);
    }
}
