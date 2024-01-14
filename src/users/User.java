package users;

import books.Book;

public abstract class User {
    protected String id;
    protected String name;
    protected String email;

    // Constructor
    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Métodos getter
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // Métodos abstractos que las subclases deben implementar
    public abstract void requestBook(Book book);

    public abstract void returnBook(Book book);
}
