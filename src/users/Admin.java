package users;

import books.Book;
import commands.Command;
import commands.LendBookCommand;
import commands.ReturnBookCommand;

public class Admin extends User {
    public Admin(String id, String name, String email) {
        super(id, name, email);
    }

    @Override
    public void requestBook(Book book) {
        // Administrators might have special permissions to request books
        if (book.isAvailable()) {
            book.lendBook();
            System.out.println(name + " has requested the book: " + book.getTitle());
        } else {
            System.out.println("The book is not available.");
        }
    }

    @Override
    public void returnBook(Book book) {
        book.returnBook();
        System.out.println(name + " has returned the book: " + book.getTitle());
    }

    // Additional methods specific to administrators
    public void addBook(Book book) {
        // Logic to add a book to the library
    }

    public void removeBook(Book book) {
        // Logic to remove a book from the library
    }

    public void lendBookToUser(Book book, User user) {
        Command lendBook = new LendBookCommand(book, user);
        lendBook.execute();
    }

    public void returnBookFromUser(Book book, User user) {
        Command returnBook = new ReturnBookCommand(book, user);
        returnBook.execute();
    }
}
