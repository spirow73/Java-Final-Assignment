package database;

import books.Book;

public interface LibraryDatabase {
    void addBook(Book book);

    void removeBook(Book book);

    void lendBook(Book book);

    void returnBook(Book book);

    void showAvailableBooks();

    void showLentBooks();

    void showAllBooks();

    void showBookInfo(Book book);
}