// inherits the common properties of MediaItem
// also implements the Loanable interface
public class Book extends MediaItem implements Loanable {

    // Fields specific to books
    private String author;
    private int pages;

    // Availability
    private boolean available;

    // Constructor, creates a book
    public Book(int id, String title, int year, String genre,
                String author, int pages) {


        super(id, title, year, genre);


        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Author cannot be empty.");
        }


        if (pages <= 0) {
            throw new IllegalArgumentException(
                    "Number of pages must be positive."
            );
        }

        // Store the book-specific information
        this.author = author;
        this.pages = pages;

        // A new book is available by default
        this.available = true;
    }

    // Getters, allow other classes to read the book-specific fields
    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    // Override, display information specific to a book
    @Override
    public void displayInfo() {
        System.out.println("Type: Book");
        System.out.println("ID: " + getId());
        System.out.println("Title: " + getTitle());
        System.out.println("Year: " + getYear());
        System.out.println("Genre: " + getGenre());
        System.out.println("Author: " + author);
        System.out.println("Pages: " + pages);


        System.out.println(
                "Available: " + (available ? "Yes" : "No")
        );
    }

    // Override, return the media type
    @Override
    public String getMediaType() {
        return "Book";
    }

    // Implement Loanable, borrow the book
    @Override
    public void borrow() {


        if (available) {
            available = false;
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("This book is already borrowed.");
        }
    }

    // Implement Loanable, return the book
    @Override
    public void returnItem() {

        // Only return the book if it is currently borrowed
        if (!available) {
            available = true;
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("This book was not borrowed.");
        }
    }

    // Implement Loanable, check availability
    @Override
    public boolean isAvailable() {
        return available;
    }
}