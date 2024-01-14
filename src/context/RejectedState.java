package context;

public class RejectedState implements BookRequestState {
    @Override
    public void handleRequest(BookRequestContext context) {
        System.out.println("La solicitud del libro '" + context.getBook().getTitle() + "' ha sido rechazada.");
        // Aquí puedes incluir lógica adicional para manejar un rechazo
    }
}
