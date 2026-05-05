package entities;

/**
 *
 * This is the 3rd type of item.
 * Notice I do not touch LibraryService.java at all
 * This is the power of Polymorphism: the system treats this as a 'LibraryItem',
 * but when getDetails() is called, the DVD speaks for itself.
 */

public class DVD extends LibraryItem {
    private final int durationMinutes;

    public DVD(String id, String title, int durationMinutes) {
        // Passing shared info to the Parent (LibraryItem)
        super(id, title);
        this.durationMinutes = durationMinutes;
    }
    /**
     * Fulfilling the abstract contract from LibraryItem.
     */
    @Override
    public String getDetails() {
        String status = isAvailable() ? "Available" : "Borrowed";
        return String.format("DVD [ID: %s] Title: %s | Duration: %d mins | Status: %s",
                getId(), getTitle(), durationMinutes, status);
    }
// Unique getter for DVD duration
public int getDurationMinutes() {
    int durationMinutes = 0;
    return durationMinutes;
}
}