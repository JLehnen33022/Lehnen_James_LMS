// James Lehnen, CEN-3024C, 5-26-24
// Software Development I
// Book Class collects the information of the text file - the ID, Title and Author.

public class Book {
    private int id;
    private String title;
    private String author;

    // Constructor
    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // toString method to represent the book as a string
    @Override
    public String toString() {
        return id + ". " + title + "," + author;
    }
}
