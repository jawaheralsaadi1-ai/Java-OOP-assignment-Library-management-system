//package for grouping related classes
package entities;// Must be matches with our file name
// its means that this class is inside folder called entities
//Using to organize the project

// * CHALLENGE 3:
import behaviours.Borrowable;

/* Make this class 'abstract' because a generic "Library Item" doesn't exist in our library.
 * It's just a blueprint that Books and Magazines will follow to stay organized.
 */
/**
 * CHALLENGE 3: LibraryItem now implements the Borrowable contract.
 * It provides the base logic for checking items in and out.
 */
public abstract class LibraryItem implements Borrowable {
    // "final" means: once we set them, they cannot change later
    // These variables store the Id and Title information
    private final String id;
    private final String title;
    private boolean isAvailable; // State: Is it on the shelf or with a member?

    // Create the objects and store it values
    public LibraryItem(String id, String title) {
        this.id = id;
        this.title = title;
        this.isAvailable = true; // Every new item is available by default!
    }

    /**
     * CHALLENGE 3: Implementation of the checkout behavior.
     */
    @Override
    public void checkout() {
        this.isAvailable = false;
    }

    /**
     * CHALLENGE 3: Implementation of the release behavior.
     */
    @Override
    public void release() {
        this.isAvailable = true;
    }
    /**
     * This is a -Contract-
     * Every child (Book/Magazine/DVD) MUST implement this to show unique details.
     */
    public abstract String getDetails();

    // Getters: way for Services to read this data.
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
    // Setter: Kept for flexibility, though checkout/release are preferred now.
    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }
} //

 /*   *//**
     *This is a -Contract-
     * Every child (Book/Magazine) MUST get this to show its unique details.
     *//*
    public abstract String getDetails();

    // Getters:  way for Services to read this data.
    public String getId() { return id; }
    public String getTitle() { return title; }
    public boolean isAvailable() { return isAvailable; }

    // Setter: We only need this for 'isAvailable' because availability changes.
    public void setAvailable(boolean available) { isAvailable = available; }
} }*/