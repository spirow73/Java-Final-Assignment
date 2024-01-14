package users;

import books.Book;

public class Student extends User {
    private static final int MAX_ALLOWED_BOOKS = 5; // Example of maximum allowed books
    private int booksBorrowed;

    public Student(String id, String name, String email) {
        super(id, name, email);
        this.booksBorrowed = 0;
    }

    @Override
    public void requestBook(Book book) {
        if (booksBorrowed < MAX_ALLOWED_BOOKS && book.isAvailable()) {
            book.lendBook();
            booksBorrowed++;
            System.out.println(name + " has requested the book: " + book.getTitle());
        } else {
            System.out.println("Cannot request more books or the book is not available.");
        }
    }

    @Override
    public void returnBook(Book book) {
        book.returnBook();
        booksBorrowed--;
        System.out.println(name + " has returned the book: " + book.getTitle());
    }
}
