package database;

import books.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryDatabaseImpl implements LibraryDatabase {
    private Map<String, Book> books; // Almacena todos los libros por ISBN
    private List<Book> lentBooks; // Lista de libros prestados

    public LibraryDatabaseImpl() {
        books = new HashMap<>();
        lentBooks = new ArrayList<>();
    }

    @Override
    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
        System.out.println("Book added: " + book.getTitle());
    }

    @Override
    public void removeBook(Book book) {
        books.remove(book.getIsbn());
        lentBooks.remove(book);
        System.out.println("Book removed: " + book.getTitle());
    }

    @Override
    public void lendBook(Book book) {
        if (books.containsKey(book.getIsbn()) && book.isAvailable()) {
            book.lendBook();
            lentBooks.add(book);
            System.out.println("Book lent: " + book.getTitle());
        } else {
            System.out.println("Book is not available for lending: " + book.getTitle());
        }
    }

    @Override
    public void returnBook(Book book) {
        if (lentBooks.contains(book)) {
            book.returnBook();
            lentBooks.remove(book);
            System.out.println("Book returned: " + book.getTitle());
        } else {
            System.out.println("This book was not lent out: " + book.getTitle());
        }
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
        lentBooks.forEach(book -> System.out.println(book.getTitle()));
    }

    @Override
    public void showAllBooks() {
        System.out.println("All Books:");
        books.values().forEach(book -> System.out.println(book.getTitle()));
    }

    @Override
    public void showBookInfo(Book book) {
        System.out.println("Book Information:");
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("ISBN: " + book.getIsbn());
        System.out.println("Available: " + (book.isAvailable() ? "Yes" : "No"));
    }
}
