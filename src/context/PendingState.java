package context;

public class PendingState implements BookRequestState {
    @Override
    public void handleRequest(BookRequestContext context) {
        System.out.println("La solicitud del libro '" + context.getBook().getTitle() + "' está pendiente.");
        // Aquí puedes incluir más lógica relacionada con el estado pendiente
    }
}
