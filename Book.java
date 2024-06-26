// James Lehnen, CEN-3024C, 5-26-24; UPDATED 6-16-24
// Software Development I
// Book Class collects the information of the text file - the ID, Title and Author.

public class Book {
    private int id;
    private String title;
    private String author;
    private boolean ifStocked;
    
    // Constructor
    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.ifStocked = true;
    }

    // Get/Set
    public int getId() { return id; }
    public String getTitle() { return title; }
    public boolean isStocked() { return ifStocked; }
    public void setStock(boolean available) { ifStocked = available; }

    // toString method to represent the book as a string
    @Override
    public String toString() {
        return id + ", " + title + ", " + author + ", " + (ifStocked ? "In Stock" : "Withdrawn");
    }
}
