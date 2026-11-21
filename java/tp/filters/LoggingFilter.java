package tp.filters;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class LoggingFilter implements Filter {

    private String logPrefix = "[LoggingFilter]";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String parametre = filterConfig.getInitParameter("logPrefix");
        if (parametre != null) {
            logPrefix = parametre;
        }
        System.out.println(logPrefix + " init() : le filtre est initialise");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        long debut = System.nanoTime();

        System.out.println(logPrefix + " AVANT chain.doFilter() : " + httpRequest.getRequestURL());

        chain.doFilter(request, response);

        long fin = System.nanoTime();
        double dureeMs = (fin - debut) / 1_000_000.0;
        System.out.println(logPrefix + " APRES chain.doFilter() : " + httpRequest.getRequestURL());
        System.out.println(logPrefix + " duree de la requete : " + String.format("%.3f", dureeMs) + " ms");
    }

    @Override
    public void destroy() {
        System.out.println(logPrefix + " destroy() : le filtre est detruit");
    }
}
