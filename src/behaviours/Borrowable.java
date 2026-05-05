package behaviours;

/**
 *
 * This is the 'Contract'. Any class implementing this MUST be able to
 * handle being checked out and returned.
 */
public interface Borrowable {
    // These methods define the BEHAVIOUR of a borrowable item
    void checkout(); // What happens when someone takes the item?
    void release();  // What happens when someone brings it back?
}