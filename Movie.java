
public class Movie extends MediaItem implements Loanable {

    // Fields specific to movies
    private String director;
    private int durationMinutes;

    // Availability
    private boolean available;


    public Movie(int id, String title, int year, String genre,
                 String director, int durationMinutes) {


        super(id, title, year, genre);


        if (director == null || director.isBlank()) {
            throw new IllegalArgumentException(
                    "Director cannot be empty."
            );
        }


        if (durationMinutes <= 0) {
            throw new IllegalArgumentException(
                    "Duration must be positive."
            );
        }

        // Store the movie-specific information
        this.director = director;
        this.durationMinutes = durationMinutes;


        this.available = true;
    }

    // Getters, return the movie-specific information
    public String getDirector() {
        return director;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }


    @Override
    public void displayInfo() {
        System.out.println("Type: Movie");
        System.out.println("ID: " + getId());
        System.out.println("Title: " + getTitle());
        System.out.println("Year: " + getYear());
        System.out.println("Genre: " + getGenre());
        System.out.println("Director: " + director);
        System.out.println("Duration: " + durationMinutes + " minutes");


        System.out.println(
                "Available: " + (available ? "Yes" : "No")
        );
    }


    @Override
    public String getMediaType() {
        return "Movie";
    }

    // Implement Loanable, borrow the movie
    @Override
    public void borrow() {


        if (available) {
            available = false;
            System.out.println("Movie borrowed successfully.");
        } else {
            System.out.println("This movie is already borrowed.");
        }
    }

    // Implement Loanable, return the movie
    @Override
    public void returnItem() {


        if (!available) {
            available = true;
            System.out.println("Movie returned successfully.");
        } else {
            System.out.println("This movie was not borrowed.");
        }
    }

    // Implement Loanable, check availability
    @Override
    public boolean isAvailable() {
        return available;
    }
}