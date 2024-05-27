// James Lehnen, CEN-3024C, 5-26-24
// Software Development I
// Library Class collects Book class information and manages the adding, removal and searching or Books


import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Book> books;

    // Constructor
    public Library() {
        this.books = new ArrayList<>();
    }

    // Method to add a book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Method to remove a book from the library using its ID
    public void removeBook(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                books.remove(book);
                return;
            }
        }
    }

    // Method to list all books in the library
    public void listBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
