package tp.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tp.listeners.SessionUser;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");

        HttpSession session = request.getSession();
        session.setAttribute("user", username);
        session.setAttribute("sessionUser", new SessionUser(username));

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Connexion reussie</h1>");
        out.println("<p>Bienvenue " + username + ", vous etes connecte.</p>");
        out.println("<p><a href=\"items.html\">Aller a la page des items</a></p>");
        out.println("</body></html>");
    }
}
