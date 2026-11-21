package tp.listeners;

import jakarta.servlet.ServletRequestAttributeEvent;
import jakarta.servlet.ServletRequestAttributeListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class RequestAttributeListener implements ServletRequestAttributeListener {

    @Override
    public void attributeAdded(ServletRequestAttributeEvent event) {
        System.out.println("[RequestAttributeListener] attribut ajoute : " + event.getName()
                + " = " + event.getValue());
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent event) {
        Object nouvelleValeur = event.getServletRequest().getAttribute(event.getName());
        System.out.println("[RequestAttributeListener] attribut modifie : " + event.getName()
                + " | ancienne valeur = " + event.getValue()
                + " | nouvelle valeur = " + nouvelleValeur);
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent event) {
        System.out.println("[RequestAttributeListener] attribut supprime : " + event.getName()
                + " = " + event.getValue());
    }
}
