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
        if (user instanceof Admin) {
            requestManager.addRequest(request);
        } else {
            System.out.println("Sólo los administradores pueden añadir solicitudes.");
        }
    }

    // Método para aprobar una solicitud de libro
    public void approveRequest(BookRequestContext request, User user) {
        if (user instanceof Admin) {
            // Lógica para aprobar la solicitud
            request.approveRequest();
        } else {
            System.out.println("Sólo los administradores pueden aprobar solicitudes.");
        }
    }

    // Método para rechazar una solicitud de libro
    public void rejectRequest(BookRequestContext request, User user) {
        if (user instanceof Admin) {
            // Lógica para rechazar la solicitud
            request.rejectRequest();
        } else {
            System.out.println("Sólo los administradores pueden rechazar solicitudes.");
        }
    }

    // Aquí puedes añadir otros métodos delegados a requestManager si es necesario
}
