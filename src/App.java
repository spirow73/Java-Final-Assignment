import facade.LibraryFacade;
import factory.*;
import repository.*;
import books.Book;
import users.*;
import context.*;
import strategy.*;
import proxy.*;
import commands.*;

public class App {
    public static void main(String[] args) {
        // Crear instancias de las clases necesarias
        BookRepository bookRepository = new BookRepositoryImpl();
        BookRequestManager requestManager = BookRequestManager.getInstance();
        AdminFactory adminFactory = new AdminFactory();
        StudentFactory studentFactory = new StudentFactory();

        LibraryFacade libraryFacade = new LibraryFacade(bookRepository, requestManager, adminFactory, studentFactory);

        // Simular el escenario
        // 1. Un usuario pide un libro
        Book book1 = new Book("123456", "Libro Ejemplo", "Autor Ejemplo");
        libraryFacade.addBook(book1.getIsbn(), book1.getTitle(), book1.getAuthor());
        User student = libraryFacade.createStudent("1", "Estudiante Ejemplo", "estudiante@ejemplo.com");
        libraryFacade.requestBook(book1, student);

        // Mostrar las peticiones
        libraryFacade.displayBooks(new AllRequestsFilterStrategy());

        // 2. Un administrador da permiso
        User admin = libraryFacade.createAdmin("2", "Administrador Ejemplo", "admin@ejemplo.com");
        BookRequestContext request = requestManager.getRequests().get(0); // Obtiene la primera solicitud
        libraryFacade.approveRequest(request, admin);

        // 3. El usuario devuelve el libro
        libraryFacade.returnBook(book1, student);

        libraryFacade.displayBooks(new AvailableBooksFilterStrategy(bookRepository));

        // 5. Otro usuario pide el mismo libro
        User anotherStudent = libraryFacade.createStudent("3", "Otro Estudiante", "otroestudiante@ejemplo.com");
        libraryFacade.requestBook(book1, anotherStudent);

        // 6. La petición es rechazada
        BookRequestContext requestToReject = requestManager.getRequests().get(1); // Obtiene
        // a segunda solicitud, por ejemplo
        libraryFacade.rejectRequest(requestToReject, admin);

        // 7. Mostrar los libros nuevamente
        libraryFacade.displayBooks(new AllRequestsFilterStrategy());
    }
}
