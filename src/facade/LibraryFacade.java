package facade;

import java.util.List;

import books.Book;
import context.BookRequestContext;
import context.BookRequestManager;
import context.BookRequestState;
import repository.BookRepository;
import strategy.RequestFilterStrategy;
import users.Student;

public class LibraryFacade {
    private BookRepository bookRepository;
    private BookRequestManager requestManager;

    public LibraryFacade(BookRepository bookRepository, BookRequestManager requestManager) {
        this.bookRepository = bookRepository;
        this.requestManager = requestManager;
    }

    // Método para agregar un libro al repositorio
    public void addBook(Book book) {
        bookRepository.addBook(book);
    }

    // Método para solicitar un libro
    public void requestBook(Book book, Student student) {
        BookRequestContext context = new BookRequestContext(book, student, requestManager);
        context.applyState(); // Solicitar el libro (estado pendiente por defecto)
    }

    // Método para aprobar una solicitud de libro
    

    // Método para mostrar todas las solicitudes pendientes
    public void printRequestsByState(Class<? extends BookRequestState> stateClass) {
        List<BookRequestContext> requests = requestManager.getRequestsByState(stateClass);
        if (requests.isEmpty()) {
            System.out.println("No hay solicitudes en el estado: " + stateClass.getSimpleName());
        } else {
            System.out.println("Solicitudes en el estado: " + stateClass.getSimpleName() + ":");
            for (BookRequestContext request : requests) {
                System.out.println(request.getRequestDetails());
            }
        }
    }

    // Método para mostrar todos los libros
    public void printAllBooks() {
        bookRepository.showAllBooks();
    }

    // Método para mostrar todos los libros disponibles
    public void printAvailableBooks() {
        bookRepository.showAvailableBooks();
    }

    // Método para buscar un libro por ISBN
    public Book findBookByIsbn(String isbn) {
        return bookRepository.getBookByIsbn(isbn);
    }

    // Método para buscar un libro por título
    public Book findBookByTitle(String title) {
        for (Book book : bookRepository.getAllBooks()) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    // Método para mostrar la información de un libro
    public void printBookInfo(Book book) {
        bookRepository.showBookInfo(book);
    }

    public void filterAndPrintRequests(RequestFilterStrategy strategy) {
        strategy.filterAndPrintRequests(requestManager);
    }

    // Otros métodos para interactuar con el sistema de biblioteca
    // Por ejemplo, listar todos los libros, buscar libros, etc.
}
