import java.util.ArrayList;

public class MediaLibrary {

    // Collection that stores all books, movies, and music
    private ArrayList<MediaItem> mediaItems;

    // Constructor, create an empty media library
    public MediaLibrary() {
        mediaItems = new ArrayList<>();
    }

    // Add media, add a new item to the collection
    public void addMediaItem(MediaItem item) {

        if (findById(item.getId()) != null) {
            throw new IllegalArgumentException("An item with this ID already exists.");
        }

        mediaItems.add(item);
        System.out.println("Media item added successfully.");
    }

    // Display all media, show every item in the collection
    public void displayAllMedia() {

        // Check whether the collection is empty
        if (mediaItems.isEmpty()) {
            System.out.println("The media library is empty.");
            return;
        }

        // Loop through the collection using the superclass type
        for (MediaItem item : mediaItems) {
            // Java calls the correct displayInfo() method for each object
            item.displayInfo();
            System.out.println("--------------------");
        }
    }

    // Search by title, find items whose titles contain the search text
    public void searchByTitle(String searchTitle) {
        boolean found = false;

        // Check every item in the collection
        for (MediaItem item : mediaItems) {
            // Ignore uppercase and lowercase differences
            if (item.getTitle().toLowerCase().contains(searchTitle.toLowerCase())) {
                item.displayInfo();
                System.out.println("--------------------");
                found = true;
            }
        }

        // Display a message if no matching items were found
        if (!found) {
            System.out.println("No media found with that title.");
        }
    }

    // Find by ID, return the item with the requested ID
    // Return null if the ID does not exist
    public MediaItem findById(int id) {
        for (MediaItem item : mediaItems) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    // Remove media, delete an item using its ID
    public void removeMediaItem(int id) {
        MediaItem item = findById(id);

        if (item == null) {
            System.out.println("No media item found with that ID.");
            return;
        }
        mediaItems.remove(item);
        System.out.println("Media item removed successfully.");
    }

    // Filter by genre
    public void filterByGenre(String searchGenre) {
        boolean found = false;

        for (MediaItem item : mediaItems) {
            if (item.getGenre().equalsIgnoreCase(searchGenre)) {
                item.displayInfo();
                System.out.println("--------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No media found in that genre.");
        }
    }

    // Count by type, count how many items belong to a media type
    public int countByType(String mediaType) {
        int count = 0;
        for (MediaItem item : mediaItems) {

            // Compare the requested type with the item's actual type
            if (item.getMediaType().equalsIgnoreCase(mediaType)) {
                count++;
            }
        }
        return count;
    }

    // Count all media, return the total number of items
    public int getTotalCount() {
        return mediaItems.size();
    }

    // Borrow or return media using the Loanable interface
    public void manageLoan(int id, boolean borrow) {
        MediaItem item = findById(id);
        if (item == null) {
            System.out.println("No media item found with that ID.");
            return;
        }

        // Check whether the item supports being loaned
        if (item instanceof Loanable) {
            // Use the interface reference polymorphically
            Loanable loanableItem = (Loanable) item;

            // Call the correct method based on the requested action
            if (borrow) {
                loanableItem.borrow();
            } else {
                loanableItem.returnItem();
            }

        } else {
            // Music does not implement Loanable in this project
            System.out.println(
                    "This type of media cannot be borrowed."
            );
        }
    }
}