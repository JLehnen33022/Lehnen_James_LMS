// James Lehnen, CEN-3024C, 7-3-24
// Software Development I
// Main acts as the framework and directions of the actual Main form of the GUI.
// The .java is instructions as the .form is the lego set.

import DBGUIDE.BOOKSHELFLMS;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LibraryGUI extends JFrame{
    private JLabel jsTitleName;
    private JTextField pleaseMakeASelectionTextField;
    private JButton checkingInButton;
    private JButton checkingOutButton;
    private JButton displayDatabaseButton;
    private JButton loadBooksButton;
    private JButton removeBooksButton;
    private JButton removeBooksByIDButton;
    private JTextArea libraryDatabaseTextArea;
    private BOOKSHELFLMS database;

    public LibraryGUI() {
        Library = new Library();
        database = new BOOKSHELFLMS();
        setTitle("Library Management System");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200,600);
        setLocationRelativeTo(null);
        setVisible(true);

        //Button to load the library's database from text file
        loadBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = fileName.getText();
                loadFromFile(fileName);
                displayBooks();
            }
        });
        //Button to remove a book by the ID number.
        removeBooksByIDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Library.books.removeIf(book -> book.getId() == bookId);
                System.out.println("Book successfully removed from Database.");
            }
        });
//Button to remove a book by the Title.
        removeBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Library.books.removeIf(book -> book.getTitle().equalsIgnoreCase(bookTitle));
                System.out.println("Book successfully removed from Database.");
            }
        });
        //Button to Check Out a book.
        checkingOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Book book : Library.books) {
                    if (book.getTitle().equalsIgnoreCase(checkOutTitle) && book.isStocked()) {
                        book.setStock(false);
                        System.out.println("Book successfully withdrawn.");
                        return;

                    }
                }
            }
        });
//Button to Check In a book.
        checkingInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Book book : Library.books) {
                    if (book.getTitle().equalsIgnoreCase(checkInTitle) && !book.isStocked()) {
                        book.setStock(true);
                        System.out.println("Book successfully stocked.");
                        return;
                    }
                }
            }
        });
//Button to Display current Stock.
        displayDatabaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Database of Books:");
                for (Book book : Library.books) {
                    System.out.println(book);
                }
            }
        });
    }

//Loads books from the text file into the database - replace fileName with file to be used, information is received.
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
        JOptionPane.showMessageDialog(null, "Error accessing File:" + e.getMessage());
    }
}
//Displays books in library database.
    private void displayBooks() {
        System.out.println("Database of Books:");
        for (Book book : Library.books) {
            System.out.println(book);
        }
        libraryDatabaseTextArea.setText(STR.toString());
    }

public static void main(String[] args) {
            new LibraryGUI();
        }
    }