// James Lehnen, CEN-3024C, 5-26-24
// Software Development I
// Library Class collects Book class information and manages the adding, removal and searching or Books

import java.util.ArrayList;
import java.util.List;

public class Library {
    static List<Book> books;
    // Constructor
    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public static void InStockBook(String checkInTitle) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(checkInTitle) && !book.isStocked()) {
                book.setStock(true);
                System.out.println("Book successfully stocked.");
                return;
            }
        }
    }

    public static void listAllBooks() {
        System.out.println("Database of Books:");
        for (Book book : books) {
            System.out.println(book);
        }
    }
    public static void removeBookByID(int bookId) {
        books.removeIf(book -> book.getId() == bookId);
        System.out.println("Book successfully removed from Database.");
    }
    public static void removeBookByTitle(String bookTitle) {
        books.removeIf(book -> book.getTitle().equalsIgnoreCase(bookTitle));
        System.out.println("Book successfully removed from Database.");
    }

    public static void WithdrawBook(String checkOutTitle) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(checkOutTitle) && book.isStocked()) {
                book.setStock(false);
                System.out.println("Book successfully withdrawn.");
                return;}
        }
    }
}
