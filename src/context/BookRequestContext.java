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
        setState(new ApprovedState());
        applyState();
        // Aquí puedes añadir lógica adicional, como registrar el préstamo del libro
    }

    public void rejectRequest() {
        setState(new RejectedState());
        applyState();
        // Lógica adicional para rechazar la solicitud
    }

    // Método para obtener los detalles de la solicitud
    public String getRequestDetails() {
        return "Book: " + book.getTitle() + ", Requested by: " + student.getName();
    }

    // Métodos para acceder o modificar el libro o el estudiante
    public Book getBook() {
        return book;
    }

    public Student getStudent() {
        return student;
    }

    public BookRequestState getState() {
        return state;
    }

    // Otros métodos según sea necesario
}
