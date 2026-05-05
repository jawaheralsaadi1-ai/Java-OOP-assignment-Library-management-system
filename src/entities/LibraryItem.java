package entities;

/**Make this class 'abstract' because a generic "Library Item" doesn't exist in our library.
 * It's just a blueprint that Books and Magazines will follow to stay organized.
 */
public abstract class LibraryItem {
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
     *This is a -Contract-
     * Every child (Book/Magazine) MUST get this to show its unique details.
     */
    public abstract String getDetails();

    // Getters:  way for Services to read this data.
    public String getId() { return id; }
    public String getTitle() { return title; }
    public boolean isAvailable() { return isAvailable; }

    // Setter: We only need this for 'isAvailable' because availability changes.
    public void setAvailable(boolean available) { isAvailable = available; }
}