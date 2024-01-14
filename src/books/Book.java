package books;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private boolean isAvailable;

    // Constructor
    public Book(String isbn, String title, String author) {
        this.isbn = isbn; // isbn is International Standard Book Number
        this.title = title;
        this.author = author;
        this.isAvailable = true; // By defautl, a book is available
    }

    // Getters y Setters
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    // Otros métodos relevantes
    // Por ejemplo, cambiar el estado del libro (prestado o devuelto)
    public boolean lendBook() {
        if (isAvailable) {
            isAvailable = false;
            return true; // Libro prestado con éxito
        }
        return false; // Libro no disponible para préstamo
    }

    public boolean returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            return true; // Libro devuelto con éxito
        }
        return false; // El libro no estaba prestado
    }

    public void showBookInfo() {
        System.out.println("Book Info:");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Available: " + isAvailable);
    }
}
