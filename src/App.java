import context.BookRequestManager;
import context.BookRequestContext;
import context.ApprovedState;
import context.PendingState;
import context.RejectedState;
import proxy.BookRequestProxy;
import books.Book;
import strategy.ApprovedRequestFilterStrategy;
import strategy.PendingRequestFilterStrategy;
import strategy.RejectedRequestFilterStrategy;
import users.Admin;
import users.Student;

public class App {
    public static void main(String[] args) {
        // Crear instancia de BookRequestManager
        BookRequestManager manager = BookRequestManager.getInstance();
        BookRequestProxy proxy = new BookRequestProxy(manager);

        // Crear un libro y usuarios de ejemplo
        Book book = new Book("123456", "El Principito", "Antoine de Saint-Exupéry");
        Admin admin = new Admin("admin1", "Administrador", "admin@example.com");
        Student student = new Student("student1", "Estudiante", "student@example.com");

        // Crear una solicitud de libro
        BookRequestContext request = new BookRequestContext(book, student, manager);

        // Intentar añadir la solicitud usando un estudiante (debería fallar)
        proxy.addRequest(request, student);

        // Intentar añadir la solicitud usando un administrador (debería tener éxito)
        proxy.addRequest(request, admin);
    }
}
