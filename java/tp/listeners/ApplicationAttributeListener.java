package tp.listeners;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ApplicationAttributeListener implements ServletContextAttributeListener {

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("[ApplicationAttributeListener] attribut ajoute : " + event.getName()
                + " = " + event.getValue());
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        Object nouvelleValeur = event.getServletContext().getAttribute(event.getName());
        System.out.println("[ApplicationAttributeListener] attribut modifie : " + event.getName()
                + " | ancienne valeur = " + event.getValue()
                + " | nouvelle valeur = " + nouvelleValeur);
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("[ApplicationAttributeListener] attribut supprime : " + event.getName()
                + " = " + event.getValue());
    }
}
