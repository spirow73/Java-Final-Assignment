package context;

public class ApprovedState implements BookRequestState {
    @Override
    public void handleRequest(BookRequestContext context) {
        System.out.println("The book request for '" + context.getBook().getTitle() + "' has been approved.");
        context.getBook().lendBook(); // Change the book state to lent
        // You can add more logic here like notifying the student, recording the transaction, etc.
    }
}
