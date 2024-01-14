package repository;

import books.Book;
import java.util.List;

public interface BookRepository {
    void addBook(Book book);

    void removeBook(Book book);

    Book getBookByIsbn(String isbn);

    void updateBook(Book book); // Para actualizar el estado de un libro

    List<Book> getAllBooks();

    void showAvailableBooks();

    void showLentBooks();

    void showAllBooks();

    void showBookInfo(Book book);

    void lendBook(Book book);

    void returnBook(Book book);
    // Add other methods here
}
