package tp.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ReadCookie")
public class ReadCookie extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String valeur = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("visiteur")) {
                    valeur = cookie.getValue();
                }
            }
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>ReadCookie</h1>");
        if (valeur == null) {
            response.addCookie(new Cookie("visiteur", "etudiant"));
            out.println("<p>Cookie visiteur cree. Rechargez la page.</p>");
        } else {
            out.println("<p>Cookie visiteur = " + valeur + "</p>");
        }
        out.println("</body></html>");
    }
}
