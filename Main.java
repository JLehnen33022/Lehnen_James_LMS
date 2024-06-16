// James Lehnen, CEN-3024C, 5-26-24 UPDATED 6-16-24
// Software Development I
// Main Class acts as the repository for the code that will guide the program along, pulling up the other classes.
// "Main" is the actual program that is interacted with, other classes are just the puzzle pieces that fall in.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library ManageLibrary = new Library();
        Scanner scanner = new Scanner(System.in);

        // Read books from the text file and add them to the library
        System.out.print("Enter Title of Book: ");
        String fileName = scanner.nextLine();
        ManageLibrary.addBookFromFile("books.txt");

        // Method to list all books in the library
        System.out.println("\nLibrary stock:");
        ManageLibrary.listAllBooks();

        // Method to remove a book from the library using its ID
        System.out.print("\nBook ID for removal: ");
        int bookId = Integer.parseInt(scanner.nextLine());
        ManageLibrary.removeBookByID(bookId);
        System.out.println("Database Updated:");
        ManageLibrary.listAllBooks();

        // For removal of book by the title
        System.out.print("\nBook Title for removal: ");
        String bookTitle = scanner.nextLine();
        ManageLibrary.removeBookByTitle(bookTitle);
        System.out.println("Database Updated:");
        ManageLibrary.listAllBooks();

        // To check out a book, and update the database
        System.out.print("\nTitle to be Checked Out: ");
        String checkOutTitle = scanner.nextLine();
        ManageLibrary.WithdrawBook(checkOutTitle);
        System.out.println("Database Updated:");
        ManageLibrary.listAllBooks();

        // To check in a book, and update the database
        System.out.print("\nTitle to be Checked In: ");
        String checkInTitle = scanner.nextLine();
        ManageLibrary.InStockBook(checkInTitle);
        System.out.println("Database Updated:");
        ManageLibrary.listAllBooks();

        scanner.close();
    }
}
