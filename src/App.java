import facade.LibraryFacade;
import books.Book;
import repository.BookRepositoryImpl;
import context.BookRequestManager;
import users.Student;
import repository.BookRepository;

public class App {
    public static void main(String[] args) {
        BookRepository bookRepository = new BookRepositoryImpl();
        BookRequestManager requestManager = new BookRequestManager();
        LibraryFacade library = new LibraryFacade(bookRepository, requestManager);

        // Añadir un libro al sistema
        Book book = new Book("123456", "El Principito", "Antoine de Saint-Exupéry");
        library.addBook(book);

        // Solicitar un libro
        Student student = new Student("S001", "Juan Pérez", "juan.perez@example.com");
        library.requestBook(book, student);
    }
}
