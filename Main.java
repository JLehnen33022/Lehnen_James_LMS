// James Lehnen, CEN-3024C, 5-26-24
// Software Development I
// Main Class acts as the repository for the code that will guide the program along, pulling up the other classes.
// "Main" is the actual program that is interacted with, other classes are just the puzzle pieces that fall in.

import java.awt.print.Book;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Read books from the text file and add them to the library
        try {
            File file = new File("books.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String title = parts[1];
                String author = parts[2];
                Book book = new Book(id,title,author);
                library.addBook(book);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Library Management System");
            System.out.println("1. Add a book");
            System.out.println("2. Remove a book");
            System.out.println("3. List all books");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter book ID: ");
                    int id = input.nextInt();
                    input.nextLine(); // Consume newline
                    System.out.print("Enter book title: ");
                    String title = input.nextLine();
                    System.out.print("Enter book author: ");
                    String author = input.nextLine();
                    Book newBook = new Book(id,title,author);
                    library.addBook(newBook);
                    System.out.println("Book added successfully.");
                    break;
                case 2:
                    System.out.print("Enter book ID to remove: ");
                    int removeId = input.nextInt();
                    library.removeBook(removeId);
                    System.out.println("Book removed successfully.");
                    break;
                case 3:
                    System.out.println("List of all books:");
                    library.listBooks();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        } while (choice != 0);

        input.close();
    }
}