package tp.listeners;

import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;

public class SessionUser implements HttpSessionBindingListener {

    private final String username;

    public SessionUser(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("[SessionUser] valueBound() : " + username + " ajoute a la session "
                + event.getSession().getId() + " (attribut " + event.getName() + ")");
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("[SessionUser] valueUnbound() : " + username + " retire de la session "
                + event.getSession().getId() + " (attribut " + event.getName() + ")");
    }

    @Override
    public String toString() {
        return "SessionUser(" + username + ")";
    }
}
