package commands;

import users.Student;
import users.User;
import books.Book;

public class ReturnBookCommand implements Command {
    private Book book;
    private User user;

    public ReturnBookCommand(Book book, User user) {
        this.book = book;
        this.user = user;
    }

    @Override
    public void execute() {
        if (!book.isAvailable() && user instanceof Student) {
            book.returnBook();
            System.out.println("Book returned: " + book.getTitle() + " from " + user.getName());
        }
    }
}