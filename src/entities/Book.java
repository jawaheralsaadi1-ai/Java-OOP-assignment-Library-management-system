package entities;

/**
 *
 *  After implement abstract LibraryItem as a base
 *  I used 'extends' here. This means Book gets everything from LibraryItem
 * I only had to add the 'author' field because that's what makes a Book unique.
 */

public class Book extends LibraryItem {
    // "final" means: once we set them, they cannot change later
    // Create variable store the author information which makes a Book unique
    private final String author;

    // Create the objects and store it values
    public Book(String id, String title, String author) {
        // 'super' calls the Constructor of the  (LibraryItem)
        // It's like saying: "This is  the ID and Title for me".
        super(id, title);
        this.author = author;
    }

    /**
     *  Remember how getDetails was 'abstract' in the LibraryItem?
     * So now , get the  specific details for a Book.
     */
    @Override
    public String getDetails() {
        String status = isAvailable() ? "Available" : "Borrowed";
        return String.format("Book [ID: %s] Title: %s | Author: %s | Status: %s",
                getId(), getTitle(), author, status);
    }

    // Getter for the unique field
    public String getAuthor() { return author; }
}