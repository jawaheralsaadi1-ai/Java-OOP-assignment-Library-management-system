//package for grouping related classes
package entities;// Must be matches with our file name
// its means that this class is inside folder called entities
//Using to organize the project
/**
 *
 *  After implement abstract LibraryItem as a base
 *  Just like the Book class, this Magazine extends LibraryItem.
 It takes ID and Title from the LibraryItem but adds its own 'issueNumber'. */

public class Magazine  extends LibraryItem {

// "final" means: once we set them, they cannot change later
    // Create variable store the  information which makes a Book unique
    private final String issueNumber;

    // Create the objects and store it values
    public Magazine (String id, String title, String issueNumber ) {
        // 'super' calls the Constructor of the  (LibraryItem)
        super(id, title); // Calling to handle shared data
        this.issueNumber = issueNumber;
    }

    /**
     * Implementing the abstract method from LibraryItem.
     * Now showing Magazine specific details.
     */
    @Override
    public String getDetails() {
        String status = isAvailable() ? "Available" : "Borrowed";
        return String.format("Magazine [ID: %s] Title: %s | Issue: %s | Status: %s",
                getId(), getTitle(), issueNumber, status);
    }

    // Getter for the unique field
    public String getAuthor() { return issueNumber; }
}