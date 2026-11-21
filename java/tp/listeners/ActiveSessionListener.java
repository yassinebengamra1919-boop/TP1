package tp.listeners;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

import java.util.concurrent.atomic.AtomicInteger;

@WebListener
public class ActiveSessionListener implements HttpSessionListener {

    private final AtomicInteger compteur = new AtomicInteger(0);

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        int nombre = compteur.incrementAndGet();
        event.getSession().getServletContext().setAttribute("activeSessions", nombre);
        System.out.println("[ActiveSessionListener] session creee : " + event.getSession().getId()
                + " | sessions actives = " + nombre);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        int nombre = compteur.decrementAndGet();
        event.getSession().getServletContext().setAttribute("activeSessions", nombre);
        System.out.println("[ActiveSessionListener] session detruite : " + event.getSession().getId()
                + " | sessions actives = " + nombre);
    }
}
