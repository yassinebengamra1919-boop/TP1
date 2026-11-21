package tp.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ListItems")
public class ListItems extends HttpServlet {

    private static final String[] ITEMS = {"Clavier", "Souris", "Ecran"};

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Liste des items</h1>");
        out.println("<ul>");
        for (String item : ITEMS) {
            out.println("<li>" + item + "</li>");
        }
        out.println("</ul>");
        out.println("</body></html>");
    }
}
