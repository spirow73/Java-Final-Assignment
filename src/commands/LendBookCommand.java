package commands;

import users.Student;
import users.User;
import books.Book;

public class LendBookCommand implements Command {
    private Book book;
    private User user;

    public LendBookCommand(Book book, User user) {
        this.book = book;
        this.user = user;
    }

    @Override
    public void execute() {
        if (book.isAvailable() && user instanceof Student) {
            book.lendBook();
            System.out.println("Book lent: " + book.getTitle() + " to " + user.getName());
        }
    }
}
