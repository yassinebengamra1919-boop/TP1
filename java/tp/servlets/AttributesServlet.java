package tp.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Attributes")
public class AttributesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String valeur = request.getParameter("value");
        if (valeur == null) {
            valeur = "valeur1";
        }
        String resultat = "Aucune action (actions possibles : session-set, session-remove, app-set, app-remove, request-test)";

        if ("session-set".equals(action)) {
            HttpSession session = request.getSession();
            session.setAttribute("user", valeur);
            resultat = "session.setAttribute(user, " + valeur + ")";
        } else if ("session-remove".equals(action)) {
            HttpSession session = request.getSession();
            session.removeAttribute("user");
            session.removeAttribute("sessionUser");
            resultat = "session.removeAttribute(user) et removeAttribute(sessionUser)";
        } else if ("app-set".equals(action)) {
            getServletContext().setAttribute("test", valeur);
            resultat = "servletContext.setAttribute(test, " + valeur + ")";
        } else if ("app-remove".equals(action)) {
            getServletContext().removeAttribute("test");
            resultat = "servletContext.removeAttribute(test)";
        } else if ("request-test".equals(action)) {
            request.setAttribute("test", "valeur1");
            request.setAttribute("test", "valeur2");
            request.removeAttribute("test");
            resultat = "request.setAttribute x2 puis request.removeAttribute(test)";
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Attributes</h1>");
        out.println("<p>" + resultat + "</p>");
        out.println("</body></html>");
    }
}
