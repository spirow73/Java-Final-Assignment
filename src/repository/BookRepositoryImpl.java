package repository;

import books.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookRepositoryImpl implements BookRepository {
    private Map<String, Book> books = new HashMap<>();

    @Override
    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
        System.out.println("Book added: " + book.getTitle());
    }

    @Override
    public void removeBook(Book book) {
        books.remove(book.getIsbn());
        System.out.println("Book removed: " + book.getTitle());
    }

    @Override
    public Book getBookByIsbn(String isbn) {
        return books.get(isbn);
    }

    @Override
    public void updateBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    @Override
    public void showAvailableBooks() {
        System.out.println("Available Books:");
        books.values().stream()
                .filter(Book::isAvailable)
                .forEach(book -> System.out.println(book.getTitle()));
    }

    @Override
    public void showLentBooks() {
        System.out.println("Lent Books:");
        books.values().stream()
                .filter(book -> !book.isAvailable())
                .forEach(book -> System.out.println(book.getTitle()));
    }

    @Override
    public void showAllBooks() {
        System.out.println("All Books:");
        books.values().forEach(book -> System.out.println(book.getTitle()));
    }

    @Override
    public void showBookInfo(Book book) {
        // Use the showInfo method from the Book class
        book.showBookInfo();
    }

    @Override
    public void lendBook(Book book) {
        if (book.lendBook()) {
            System.out.println("Book lent: " + book.getTitle());
        } else {
            System.out.println("Book is already lent: " + book.getTitle());
        }
    }

    @Override
    public void returnBook(Book book) {
        if (book.returnBook()) {
            System.out.println("Book returned: " + book.getTitle());
        } else {
            System.out.println("Book is already available: " + book.getTitle());
        }
    }
}
