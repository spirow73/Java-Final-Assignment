package context;

public class RejectedState implements BookRequestState {
    @Override
    public void handleRequest(BookRequestContext context) {
        System.out.println("The book request for '" + context.getBook().getTitle() + "' has been rejected.");
        // Here you can include additional logic to handle a rejection
    }
}
