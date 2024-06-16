// James Lehnen, CEN-3024C, 5-26-24 UPDATED 6-16-24
// Software Development I
// Library Class collects Book class information and manages the adding, removal and searching or Books

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Library {
    private List<Book> books;
    // Constructor
    public Library() {
        this.books = new ArrayList<>();
    }
    // Method to add a book to the library
    public void addBookFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0].trim());
                String title = parts[1].trim();
                String author = parts[2].trim();
                Book book = new Book(id, title, author);
            }
        } catch (IOException e) {
            System.err.println("File read error: " + e.getMessage());
        }
    }
    // Method to remove a book from the library using its ID
    public void removeBookByID(int id) {
        books.removeIf(book -> book.getId() == id);
        System.out.println("Book successfully removed from Database.");
    }
    // Method to remove a book from the library using its Title
    public void removeBookByTitle(String title) {
        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
        System.out.println("Book successfully removed from Database.");
    }
    // Method to list all books in the library
    public void listAllBooks() {
        System.out.println("Database of Books:");
        for (Book book : books) {
            System.out.println(book);
        }
    }
    // Method to withdraw books from the library
    public void WithdrawBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isStocked()) {
                book.setStock(false);
                System.out.println("Book successfully withdrawn.");
                return;
            }
        }
        System.out.println("Book currently withdrawn.");
    }
    // Method to stock book returned to library
    public void InStockBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && !book.isStocked()) {
                book.setStock(true);
                System.out.println("Book successfully stocked.");
                return;
            }
        }
        System.out.println("Book previously stocked.");
    }
}

