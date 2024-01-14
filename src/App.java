import context.BookRequestManager;
import context.BookRequestContext;
import context.ApprovedState;
import context.PendingState;
import context.RejectedState;
import factory.AdminFactory;
import factory.StudentFactory;
import factory.UserFactory;
import proxy.BookRequestProxy;
import books.Book;
import commands.Command;
import commands.LendBookCommand;
import strategy.ApprovedRequestFilterStrategy;
import strategy.PendingRequestFilterStrategy;
import strategy.RejectedRequestFilterStrategy;
import users.Admin;
import users.Student;
import users.User;

public class App {
    public static void main(String[] args) {
        // Obtener la instancia de BookRequestManager (Singleton)
        BookRequestManager manager = BookRequestManager.getInstance();

        // Crear un proxy para el BookRequestManager
        BookRequestProxy proxy = new BookRequestProxy(manager);

        // Crear fábricas para usuarios
        UserFactory adminFactory = new AdminFactory();
        UserFactory studentFactory = new StudentFactory();

        // Crear un administrador y un estudiante
        User admin = adminFactory.createUser("admin1", "Administrador", "admin@example.com");
        User student = studentFactory.createUser("student1", "Estudiante", "student@example.com");

        // Crear libros
        Book book1 = new Book("123456", "El Principito", "Antoine de Saint-Exupéry");
        Book book2 = new Book("789012", "El Señor de los Anillos", "J. R. R. Tolkien");

        // Crear solicitudes de libros
        BookRequestContext request1 = new BookRequestContext(book1, (Student) student, manager);
        BookRequestContext request2 = new BookRequestContext(book2, (Student) student, manager);

        // Añadir solicitudes utilizando el proxy (solo el admin puede hacerlo)
        proxy.addRequest(request1, admin); // Debería tener éxito
        proxy.addRequest(request2, student); // Debería fallar

        // Cambiar el estado de una solicitud y aplicar el estado
        request1.approveRequest(); // Aprobar la solicitud

        // Ejecutar un comando (ejemplo: prestar un libro)
        Command lendBookCommand = new LendBookCommand(book1, student);
        lendBookCommand.execute(); // Ejecuta el comando de prestar libro

        // Intentar aprobar una solicitud que ya ha sido aprobada
        request1.approveRequest(); // Debería fallar
    }
}
