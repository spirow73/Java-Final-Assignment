package facade;

import books.Book;
import commands.Command;
import commands.LendBookCommand;
import commands.ReturnBookCommand;
import context.BookRequestContext;
import context.BookRequestManager;
import repository.BookRepository;
import strategy.RequestFilterStrategy;
import users.*;
import factory.*;
import proxy.BookRequestProxy;

public class LibraryFacade {
    private BookRepository bookRepository;
    private BookRequestProxy requestProxy;
    private BookRequestManager requestManager;
    private UserFactory userFactory; // Assuming a general factory, can be more specific if needed

    private AdminFactory adminFactory;
    private StudentFactory studentFactory;

    // Constructor modificado para incluir las fábricas de usuarios
    public LibraryFacade(BookRepository bookRepository, BookRequestManager requestManager,
            AdminFactory adminFactory, StudentFactory studentFactory) {
        this.bookRepository = bookRepository;
        this.requestProxy = new BookRequestProxy(requestManager);
        this.requestManager = requestManager;
        this.adminFactory = adminFactory;
        this.studentFactory = studentFactory;
    }

    // Método para crear un estudiante
    public User createStudent(String id, String name, String email) {
        return studentFactory.createUser(id, name, email);
    }

    // Método para crear un administrador
    public User createAdmin(String id, String name, String email) {
        return adminFactory.createUser(id, name, email);
    }

    // Method to request a book
    public void requestBook(Book book, User user) {
        BookRequestContext request = new BookRequestContext(book, (Student) user, requestManager);
        requestProxy.addRequest(request, user); // Assuming the proxy handles additional logic
    }

    // Method to approve a request
    public void approveRequest(BookRequestContext request, User user) {
        requestProxy.approveRequest(request, user); // Assuming the proxy handles additional logic
    }

    // Method to reject a request
    public void rejectRequest(BookRequestContext request, User user) {
        requestProxy.rejectRequest(request, user); // Assuming the proxy handles additional logic
    }

    // Method to add a book to the repository
    public void addBook(String isbn, String title, String author) {
        Book book = new Book(isbn, title, author);
        bookRepository.addBook(book);
    }

    // Method to create a user
    public User createUser(String type, String id, String name, String email) {
        // Logic to determine the type of UserFactory to use based on 'type'
        return userFactory.createUser(id, name, email); // Assuming a generic createUser method
    }

    // Method to display books based on certain criteria
    public void displayBooks(RequestFilterStrategy strategy) {
        strategy.filterAndPrintRequests(requestManager);
    }

    public void lendBook(BookRequestContext request, User user) {
        if (user instanceof Admin) {
            Command lendBookCommand = new LendBookCommand(request.getBook(), user);
            lendBookCommand.execute();
        } else {
            System.out.println("Only administrators can lend books.");
        }
    }

    public void returnBook(Book book, User user) {
        if (user instanceof Admin) {
            Command returnBookCommand = new ReturnBookCommand(book, user);
            returnBookCommand.execute();
        } else {
            System.out.println("Only administrators can return books.");
        }
    }

    // Método para mostrar todos los libros
    public void showAllBooks() {
        bookRepository.showAllBooks();
    }

    // Método para mostrar libros disponibles (opcional)
    public void showAvailableBooks() {
        bookRepository.showAvailableBooks();
    }
}