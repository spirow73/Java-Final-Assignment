package proxy;

import context.BookRequestContext;
import context.BookRequestManager;
import users.Admin;
import users.User;

public class BookRequestProxy {
    private BookRequestManager requestManager;

    public BookRequestProxy(BookRequestManager requestManager) {
        this.requestManager = requestManager;
    }

    public void addRequest(BookRequestContext request, User user) {
        if (user instanceof Admin) { // Comprobando si el usuario es una instancia de Admin
            requestManager.addRequest(request);
        } else {
            System.out.println("Sólo los administradores pueden añadir solicitudes.");
        }
    }

    // Aquí puedes añadir otros métodos delegados a requestManager si es necesario
}