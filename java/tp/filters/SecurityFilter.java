package tp.filters;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class SecurityFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("[SecurityFilter] init() : le filtre est initialise");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        System.out.println("[SecurityFilter] AVANT : verification de la session pour " + httpRequest.getRequestURI());

        HttpSession session = httpRequest.getSession(false);
        boolean connecte = session != null && session.getAttribute("user") != null;

        if (connecte) {
            chain.doFilter(request, response);
            System.out.println("[SecurityFilter] APRES : acces autorise, le servlet a fini");
        } else {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.html");
            System.out.println("[SecurityFilter] APRES : acces refuse, chain.doFilter() non appele, redirection vers login.html");
        }
    }

    @Override
    public void destroy() {
        System.out.println("[SecurityFilter] destroy() : le filtre est detruit");
    }
}
