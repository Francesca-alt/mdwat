package s07;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s07/timerPlain") // ogni server legata a questo indirizzo;
public class TimerPlain extends HttpServlet { // timerplain è una classe httpservlet;
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)// ciclo x meccanismo response;
            throws ServletException, IOException {
        response.setContentType("text/plain");// il text è textplain;
        response.setCharacterEncoding("utf-8");
        try (PrintWriter writer = response.getWriter()) {// funziona come syso;
            writer.println(LocalTime.now());// scrivo dentro local time now, orario corrente;// printwriter una classe che mi permette di scrivere i file;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)// body del dopost delega alla doget come comportarsi;
            throws ServletException, IOException { // tira dell'exception;
        doGet(request, response);
    }
} 
