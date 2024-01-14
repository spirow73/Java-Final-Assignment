package context;

public class ApprovedState implements BookRequestState {
    @Override
    public void handleRequest(BookRequestContext context) {
        System.out.println("La solicitud del libro '" + context.getBook().getTitle() + "' ha sido aprobada.");
        context.getBook().lendBook(); // Cambiar el estado del libro a prestado
        // Aquí puedes añadir más lógica como notificar al estudiante, registrar la
        // transacción, etc.
    }
}
