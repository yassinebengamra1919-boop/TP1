package tp.listeners;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ApplicationListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        ServletContext context = event.getServletContext();
        context.setAttribute("appName", "ING1 Web Application");
        System.out.println("[ApplicationListener] contextInitialized() : l'application demarre");
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        System.out.println("[ApplicationListener] contextDestroyed() : l'application s'arrete");
    }
}
