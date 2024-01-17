package context;

import books.Book;
import users.Student;

public class BookRequestContext {

    private BookRequestState state;
    private Book book;
    private Student student;

    public BookRequestContext(Book book, Student student, BookRequestManager manager) {
        this.book = book;
        this.student = student;
        this.state = new PendingState(); // Initial state
        manager.addRequest(this);
    }

    public void setState(BookRequestState state) {
        this.state = state;
    }

    public void applyState() {
        state.handleRequest(this);
    }

    public void approveRequest() {
        if (!(state instanceof ApprovedState)) {
            setState(new ApprovedState());
            applyState();
            // Here you can add additional logic, such as registering the book loan
        } else {
            System.out.println("The request has already been approved previously.");
        }
    }

    public void rejectRequest() {
        if (!(state instanceof RejectedState)) {
            setState(new RejectedState());
            applyState();
        } else {
            System.out.println("The request has already been rejected previously.");
        }
    }

    // Method to get the request details
    public String getRequestDetails() {
        return "Book: " + book.getTitle() + ", Requested by: " + student.getName();
    }

    // Methods to access or modify the book or student
    public Book getBook() {
        return book;
    }

    public Student getStudent() {
        return student;
    }

    public BookRequestState getState() {
        return state;
    }

    // Other methods as needed
}
