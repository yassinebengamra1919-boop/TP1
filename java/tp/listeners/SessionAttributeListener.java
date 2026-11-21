package tp.listeners;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

@WebListener
public class SessionAttributeListener implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("[SessionAttributeListener] attribut ajoute : " + event.getName()
                + " = " + event.getValue());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        Object nouvelleValeur = event.getSession().getAttribute(event.getName());
        System.out.println("[SessionAttributeListener] attribut modifie : " + event.getName()
                + " | ancienne valeur = " + event.getValue()
                + " | nouvelle valeur = " + nouvelleValeur);
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("[SessionAttributeListener] attribut supprime : " + event.getName()
                + " = " + event.getValue());
    }
}
