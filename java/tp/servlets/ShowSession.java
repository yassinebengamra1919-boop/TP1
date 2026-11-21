package tp.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ShowSession")
public class ShowSession extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String idSession = session.getId();
        boolean invalidee = "invalidate".equals(request.getParameter("action"));

        if (invalidee) {
            session.invalidate();
        }

        Object activeSessions = getServletContext().getAttribute("activeSessions");
        if (activeSessions == null) {
            activeSessions = 0;
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>ShowSession</h1>");
        out.println("<p>Identifiant de session : " + idSession + "</p>");
        if (invalidee) {
            out.println("<p>La session a ete invalidee avec session.invalidate().</p>");
        } else {
            out.println("<p>Nouvelle session : " + session.isNew() + "</p>");
            out.println("<p>Utilisateur : " + session.getAttribute("user") + "</p>");
            out.println("<p><a href=\"ShowSession?action=invalidate\">Invalider la session</a></p>");
        }
        out.println("<p>Nombre de sessions actives : " + activeSessions + "</p>");
        out.println("<p><a href=\"ShowSession\">Recharger</a></p>");
        out.println("</body></html>");
    }
}
