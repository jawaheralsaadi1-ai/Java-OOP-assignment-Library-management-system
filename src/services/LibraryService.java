//package for grouping related classes
package services;// Must be matches with our file name
// its means that this class is inside folder called services
//Using to organize the project

import entities.LibraryItem;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the 'Brain' for our library collection.
 */

public class LibraryService {
    // "final" means: once we set them, they cannot change later
    // This list holds both Books and Magazines | Polymorphism is amazing.
    private final List<LibraryItem> inventory;

    public LibraryService() {
        this.inventory = new ArrayList<>();
    }

    /**
     * Adds a book or magazine to our system.
     */
    public void addItem(LibraryItem item) {
        inventory.add(item);
    }

    /**
     *  Used a loop here to find the exact item by its ID.
     * If found, we return the object; otherwise, we return null.
     */
    public LibraryItem findItemById(String id) {
        for (LibraryItem item : inventory) {
            if (item.getId().equalsIgnoreCase(id)) {
                return item;
            }
        }
        return null; // Item not found
    }

    /**
     * Prints all items that are currently marked as available.
     */
    public void listAvailableItems() {
        System.out.println("\n--- Available Items in Library ---");
        boolean found = false;
        for (LibraryItem item : inventory) {
            if (item.isAvailable()) {
                // Here, getDetails() will automatically know if it's a Book or Magazine!
                System.out.println(item.getDetails());
                found = true;
            }
        }
        if (!found) System.out.println("No items available at the moment.");
    }
}