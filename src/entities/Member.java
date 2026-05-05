//package for grouping related classes
package entities;// Must be matches with our file name
// its means that this class is inside folder called entities
//Using to organize the project

import java.util.ArrayList;//
import java.util.List;//

/**
 * This is the 'Member' class. Notice how it "has-a" relationship with Address.
 * This is Composition: instead of repeating street/city here, we just use the Address object.
 */

// "final" means: once we set them, they cannot change later
// Create variables store the author information of member
public class Member {
    private final String memberId;
    private final String name;
    private final Address address; // Composition: Member HAS AN Address

    // A list to track what this member currently has at home
    private final List<LibraryItem> borrowedItems;
     //Create the objects and store it values
    public Member(String memberId, String name, Address address) {
        this.memberId = memberId;
        this.name = name;
        this.address = address;
        this.borrowedItems = new ArrayList<>(); // Start with an empty bag of books
    }

    /**
     * This method asks the Address object to describe itself.
     * I don't need to know HOW the address is formatted; I just trust the Address class.
     */
    public String getFullMemberDetails() {
        return String.format("Member [ID: %s] Name: %s | Address: %s",
                memberId, name, address.getFullAddress());
    }

    // Standard Getters
    public String getMemberId() { return memberId; }
    public String getName() { return name; }
    public Address getAddress() { return address; }
    public List<LibraryItem> getBorrowedItems() { return borrowedItems; }

    // Helper methods for borrowing/returning logic later
    public void borrowItem(LibraryItem item) {
        borrowedItems.add(item);
    }

    public void returnItem(LibraryItem item) {
        borrowedItems.remove(item);
    }
}