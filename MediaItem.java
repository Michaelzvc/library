// Abstract superclass for all types of media
public abstract class MediaItem {

    // Fields shared by all media items
    private int id;
    private String title;
    private int year;
    private String genre;

    // Constructor, creates a media item and validates its data
    public MediaItem(int id, String title, int year, String genre) {

        if (id <= 0) {
            throw new IllegalArgumentException("ID must be positive.");
        }

        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be empty.");
        }

        if (year <= 0) {
            throw new IllegalArgumentException("Year must be positive.");
        }

        if (genre == null || genre.isBlank()) {
            throw new IllegalArgumentException("Genre cannot be empty.");
        }

        // Store the validated values in the object's fields
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
    }

    // Getters, allow other classes to read the private fields
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    // Abstract methods, subclasses must provide their own implementations
    public abstract void displayInfo();

    public abstract String getMediaType();
}