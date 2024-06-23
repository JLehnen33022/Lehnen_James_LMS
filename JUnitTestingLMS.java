package LMSJUNITTESTING;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class JUnitTestingLMS {

    @Before
    public void setUp() {
        Library ManageLibrary = new Library();
        Book book1 = new Book(10, "The Five Wounds", "Kirstin Valdez Quade");
        Book book2 = new Book(4, "Exit West", "Mohsin Hamid");
    }
    // Testing Adding a book to the database.
    @Test
    public void AddingBookTest() {
        Book newBook = new Book(10, "The Five Wounds", "Kirstin Valdez Quade");
        Library.addBook(newBook);
        assertTrue(Library.listAllBooks().contains(newBook)), "New Book Addition.";
    }
    // Testing removing a book from the database.
    @Test
    public void RemoveBookTest(){
        boolean removed = Library.removeBookByTitle("Exit West");
        assertTrue("Book Removed.", removed);
    }
    // Testing withdrawing a book from the database.
    @Test
    public void WithdrawBookTest(){
        boolean Withdraw = Library.WithdrawBook("The Five Wounds");
        assertTrue("Book Withdrawn.", Withdraw);
    }
    // Testing returning a book to the database.
    @Test
    public void InStockBookTest(){
        Library.WithdrawBook("The Five Wounds");
        boolean InStockBook = Library.InStockBook("The Five Wounds");
        assertTrue("Book Returned to Stock.", InStockBook);
    }
}
