
public class Music extends MediaItem {


    private String artist;
    private int durationSeconds;


    public Music(int id, String title, int year, String genre,
                 String artist, int durationSeconds) {


        super(id, title, year, genre);


        if (artist == null || artist.isBlank()) {
            throw new IllegalArgumentException(
                    "Artist cannot be empty."
            );
        }


        if (durationSeconds <= 0) {
            throw new IllegalArgumentException(
                    "Duration must be positive."
            );
        }

        // Store the music-specific information
        this.artist = artist;
        this.durationSeconds = durationSeconds;
    }

    // Getters, return the music-specific information
    public String getArtist() {
        return artist;
    }

    public int getDurationSeconds() {
        return durationSeconds;
    }


    @Override
    public void displayInfo() {
        System.out.println("Type: Music");
        System.out.println("ID: " + getId());
        System.out.println("Title: " + getTitle());
        System.out.println("Year: " + getYear());
        System.out.println("Genre: " + getGenre());
        System.out.println("Artist: " + artist);
        System.out.println("Duration: " + durationSeconds + " seconds");
    }


    @Override
    public String getMediaType() {
        return "Music";
    }
}