//package for grouping related classes
package entities;// Must be matches with our file name
// its means that this class is inside folder called entities
//Using to organize the project
/**
 * Address class
 * -----------------------------------------
 * This class represents a person's address.
 * We use it inside Member (Member has an Address).
 *
 * Important idea:
 * Instead of putting street, city, postal code inside Member,
 * we group them in one class → cleaner and easier to manage.
 */
public class Address {

    // These variables store the address information
    // "final" means: once we set them, they cannot change later to date the data
    private final String street;
    private final String city;
    private final String postalCode;

    /**
     * Constructor
     * This runs when we create a new Address object
     *
     * Example:
     * Address a = new Address("St name", "Muscat", "122);
     */

    // Create the objects and store it values
    public Address(String street, String city, String postalCode) {

        // Save values inside the object
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
    }

    /**
     * This method returns the full address as one line of text
     *
     * Example output:
     * "Main St, Muscat 12345"
     */
    public String getFullAddress() {
        return String.format("%s, %s %s", street, city, postalCode);    }

    /**
     * This method is automatically used when printing the object
     * Example: System.out.println(address);
     */
    @Override
    public String toString() {
        return getFullAddress();
    }

    // Getters = methods to read the values

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }
}