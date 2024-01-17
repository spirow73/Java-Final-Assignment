import facade.LibraryFacade;
import factory.*;
import repository.*;
import books.Book;
import users.*;
import context.*;
import strategy.*;


public class App {
    public static void main(String[] args) {
        // Create instances of the necessary classes
        BookRepository bookRepository = new BookRepositoryImpl();
        BookRequestManager requestManager = BookRequestManager.getInstance();
        AdminFactory adminFactory = new AdminFactory();
        StudentFactory studentFactory = new StudentFactory();

        LibraryFacade libraryFacade = new LibraryFacade(bookRepository, requestManager, adminFactory, studentFactory);

        // Simulate the scenario
        // 1. A user requests a book
        Book book1 = new Book("123456", "Example Book", "Example Author");
        libraryFacade.addBook(book1.getIsbn(), book1.getTitle(), book1.getAuthor());
        User student = libraryFacade.createStudent("1", "Example Student", "student@example.com");
        libraryFacade.requestBook(book1, student);

        // Display the requests
        libraryFacade.displayBooks(new AllRequestsFilterStrategy());

        // 2. An admin grants permission
        User admin = libraryFacade.createAdmin("2", "Example Admin", "admin@example.com");
        BookRequestContext request = requestManager.getRequests().get(0); // Get the first request
        libraryFacade.approveRequest(request, admin);

        // 3. The user returns the book
        libraryFacade.returnBook(book1, student);

        libraryFacade.displayBooks(new AvailableBooksFilterStrategy(bookRepository));

        // 5. Another user requests the same book
        User anotherStudent = libraryFacade.createStudent("3", "Another Student", "anotherstudent@example.com");
        libraryFacade.requestBook(book1, anotherStudent);

        // 6. The request is rejected
        BookRequestContext requestToReject = requestManager.getRequests().get(1); // Get the second request, for example
        libraryFacade.rejectRequest(requestToReject, admin);

        // 7. Display the books again
        libraryFacade.displayBooks(new AllRequestsFilterStrategy());
    }
}
