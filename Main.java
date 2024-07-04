// James Lehnen, CEN-3024C, 5-26-24
// Software Development I
// Main Class acts as the repository for the code that will guide the program along, pulling up the other classes.
// "Main" is the actual program that is interacted with, other classes are just the puzzle pieces that fall in.

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        // Read books from the text file and add them to the library
        System.out.print("File to load books into Database Library: ");
        String fileName = scanner.nextLine();
        loadFromFile(fileName, library);


        // Method to list all books in the library
        System.out.println("\nLibrary stock:");
        Library.listAllBooks();

        // Method to remove a book from the library using its ID
        System.out.print("\nBook ID for removal: ");
        int bookId = Integer.parseInt(scanner.nextLine());
        Library.removeBookByID(bookId);
        System.out.println("Database Updated:");
        Library.listAllBooks();

        // For removal of book by the title
        System.out.print("\nBook Title for removal: ");
        String bookTitle = scanner.nextLine();
        Library.removeBookByTitle(bookTitle);
        System.out.println("Database Updated:");
        Library.listAllBooks();

        // To check out a book, and update the database
        System.out.print("\nTitle to be Checked Out: ");
        String checkOutTitle = scanner.nextLine();
        Library.WithdrawBook(checkOutTitle);
        System.out.println("Database Updated:");
        Library.listAllBooks();

    // To check in a book, and update the database
                System.out.print("\nTitle to be Checked In: ");
    String checkInTitle = scanner.nextLine();
                Library.InStockBook(checkInTitle);
                System.out.println("Database Updated:");
                Library.listAllBooks();

                scanner.close();
    }
        private static void loadFromFile(String fileName, Library library) {
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] bookData = line.split(",");
                    if (bookData.length == 3) {
                        Book book = new Book(bookData[0], bookData[1], bookData[2]);
                        library.addBook(book);
                    }
                }
            } catch (IOException e) {
                System.out.println("Error accessing file: " + e.getMessage());


            }
        }
}
