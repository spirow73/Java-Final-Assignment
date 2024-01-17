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
            System.out.println("Only administrators can add requests.");
        }
    }

    // Method to approve a book request
    public void approveRequest(BookRequestContext request, User user) {
        if (user instanceof Admin) {
            // Logic to approve the request
            request.approveRequest();
        } else {
            System.out.println("Only administrators can approve requests.");
        }
    }

    // Method to reject a book request
    public void rejectRequest(BookRequestContext request, User user) {
        if (user instanceof Admin) {
            // Logic to reject the request
            request.rejectRequest();
        } else {
            System.out.println("Only administrators can reject requests.");
        }
    }

    // You can add other delegated methods to requestManager here if needed
}
