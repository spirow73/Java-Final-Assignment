package context;

public class PendingState implements BookRequestState {
    @Override
    public void handleRequest(BookRequestContext context) {
        System.out.println("The request for the book '" + context.getBook().getTitle() + "' is pending.");
        // You can include more logic related to the pending state here
    }
}
