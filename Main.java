import java.util.Scanner;

public class Main {

    // Scanner: reads input entered by the user
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        MediaLibrary library = new MediaLibrary();
        addSampleMedia(library);

        // boolean = true/false, program runs whilst running == true
        boolean running = true;

        // Menu loop, repeats until the user chooses to exit
        while (running) {
            displayMenu();

            // Read the user's menu choice safely
            int choice = readInt("Choose an option: ");
            switch (choice) {
                case 1:
                    library.displayAllMedia();
                    break;
                case 2:
                    addNewMedia(library);
                    break;
                case 3:
                    searchMedia(library);
                    break;
                case 4:
                    removeMedia(library);
                    break;
                case 5:
                    filterMedia(library);
                    break;
                case 6:
                    displayStatistics(library);
                    break;
                case 7:
                    manageLoan(library);
                    break;
                case 8:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose 1-8.");
            }

            // Add a blank line to make the console easier to read
            System.out.println();
        }
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("===== MEDIA MANAGEMENT SYSTEM =====");
        System.out.println("1. Display all media");
        System.out.println("2. Add media");
        System.out.println("3. Search by title");
        System.out.println("4. Remove media by ID");
        System.out.println("5. Filter by genre");
        System.out.println("6. Display statistics");
        System.out.println("7. Borrow or return media");
        System.out.println("8. Exit");
    }

    // Read an integer
    private static int readInt(String message) {
        while (true) {
            System.out.print(message);
            // Read the whole line instead of using Scanner.nextInt()
            String input = scanner.nextLine().trim();
            try {
                // Convert the text to an integer
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                // Handle letters, empty input, and other invalid numbers
                System.out.println("Invalid input. Please enter a whole number.");
            }
        }
    }

    private static String readText(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            if (!input.isBlank()) {
                return input;
            }
            System.out.println("Input cannot be empty.");
        }
    }

    private static void addSampleMedia(MediaLibrary library) {
        try {
            library.addMediaItem(
                    new Book(101, "Hello", 2000, "Fantasy", "Me, myself and i", 300)
            );
            library.addMediaItem(
                    new Movie(102, "Down", 2001, "Fantasy", "Emil", 120)
            );
            library.addMediaItem(
                    new Music(103, "caller", 2002, "Rap", "MC Mike", 120)
            );
        } catch (IllegalArgumentException e) {

            // Report invalid data or duplicate ID's
            System.out.println(
                    "Could not add sample media: " + e.getMessage()
            );
        }
    }


    private static void addNewMedia(MediaLibrary library) {

        System.out.println("What type of media do you want to add?");
        System.out.println("1. Book");
        System.out.println("2. Movie");
        System.out.println("3. Music");

        int type = readInt("Choose a type: ");
        int id = readInt("Enter ID: ");
        String title = readText("Enter title: ");
        int year = readInt("Enter year: ");
        String genre = readText("Enter genre: ");

        try {
            switch (type) {
                case 1:
                    String author = readText("Enter author: ");
                    int pages = readInt("Enter number of pages: ");
                    library.addMediaItem(
                            new Book(id, title, year, genre, author, pages)
                    );
                    break;
                case 2:
                    String director = readText("Enter director: ");
                    int duration = readInt("Enter duration in minutes: ");
                    library.addMediaItem(
                            new Movie(id, title, year, genre, director, duration)
                    );
                    break;
                case 3:
                    String artist = readText("Enter artist: ");
                    int seconds = readInt("Enter duration in seconds: ");

                    library.addMediaItem(
                            new Music(id, title, year, genre, artist, seconds)
                    );
                    break;
                default:
                    System.out.println("Invalid media type. Choose 1, 2, or 3.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Could not add media: " + e.getMessage());
        }
    }

    // Search media, ask for a title and display matching items
    private static void searchMedia(MediaLibrary library) {
        String title = readText("Enter title to search for: ");
        library.searchByTitle(title);
    }

    // Remove media, ask for the ID of the item to remove
    private static void removeMedia(MediaLibrary library) {
        int id = readInt("Enter the ID of the item to remove: ");
        library.removeMediaItem(id);
    }

    // Filter media, display items belonging to a selected genre
    private static void filterMedia(MediaLibrary library) {
        String genre = readText("Enter the genre to filter by: ");
        library.filterByGenre(genre);
    }


    private static void displayStatistics(MediaLibrary library) {
        System.out.println("===== MEDIA STATISTICS =====");
        // Display the total number of items
        System.out.println("Total media items: " + library.getTotalCount());

        // Count each type using the library's collection
        System.out.println("Books: " + library.countByType("Book"));
        System.out.println("Movies: " + library.countByType("Movie"));
        System.out.println("Music items: " + library.countByType("Music"));
    }

    // Borrow or return media using its ID
    private static void manageLoan(MediaLibrary library) {
        System.out.println("1. Borrow media");
        System.out.println("2. Return media");

        int action = readInt("Choose an action: ");
        int id = readInt("Enter the media ID: ");

        // Pass true to borrow and false to return
        if (action == 1) {
            library.manageLoan(id, true);
        } else if (action == 2) {
            library.manageLoan(id, false);
        } else {
            System.out.println("Invalid action. Choose 1 or 2.");
        }
    }
}