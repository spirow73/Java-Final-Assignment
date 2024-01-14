import context.BookRequestManager;
import context.BookRequestContext;
import context.ApprovedState;
import context.PendingState;
import context.RejectedState;
import books.Book;
import strategy.ApprovedRequestFilterStrategy;
import strategy.PendingRequestFilterStrategy;
import strategy.RejectedRequestFilterStrategy;
import users.Student;

public class App {
    public static void main(String[] args) {
        // Crear instancia de BookRequestManager
        BookRequestManager manager = BookRequestManager.getInstance();

        // Crear algunos libros de ejemplo
        Book book1 = new Book("123456", "El Principito", "Antoine de Saint-Exupéry");
        Book book2 = new Book("123457", "El Señor de los Anillos", "J. R. R. Tolkien");

        // Crear algunos estudiantes de ejemplo
        Student student1 = new Student("Estudiante1ID", "Estudiante 1", "email1@example.com");
        Student student2 = new Student("Estudiante2ID", "Estudiante 2", "email2@example.com");

        // Crear algunas solicitudes y automáticamente añadirlas al manager
        new BookRequestContext(book1, student1, manager);
        new BookRequestContext(book2, student2, manager);
        new BookRequestContext(book1, student2, manager); // Esta solicitud tendrá estado pendiente por defecto

        // Cambiar el estado de algunas solicitudes manualmente
        manager.getRequests().get(0).setState(new ApprovedState()); // Cambiar el estado de la primera solicitud a
                                                                    // aprobado
        manager.getRequests().get(2).setState(new RejectedState()); // Cambiar el estado de la tercera solicitud a
                                                                    // rechazado

        // Aplicar diferentes estrategias de filtrado y mostrar resultados
        System.out.println("Filtrando solicitudes aprobadas:");
        manager.setFilterStrategy(new ApprovedRequestFilterStrategy());
        manager.applyFilterAndPrint();

        System.out.println("\nFiltrando solicitudes pendientes:");
        manager.setFilterStrategy(new PendingRequestFilterStrategy());
        manager.applyFilterAndPrint();

        System.out.println("\nFiltrando solicitudes rechazadas:");
        manager.setFilterStrategy(new RejectedRequestFilterStrategy());
        manager.applyFilterAndPrint();
    }
}
