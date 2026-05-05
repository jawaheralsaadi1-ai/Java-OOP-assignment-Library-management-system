//package for grouping related classes
package services;// Must be matches with our file name
// its means that this class is inside folder called services
//Using to organize the project

import entities.LibraryItem;
import entities.Member;

/**
 * This is the 'Logic Hub'. It coordinates between LibraryService and MemberService.
 * I passed them as references so this class doesn't have to manage lists itself.
 */
public class BorrowService {
    private final LibraryService libraryService;
    private final MemberService memberService;

    // Constructor: Needs both services to work
    public BorrowService(LibraryService libraryService, MemberService memberService) {
        this.libraryService = libraryService;
        this.memberService = memberService;
    }

    /**
     * The Borrowing Logic:
     * 1. Find the item and member.
     * 2. Check if they exist and if the item is available.
     */
    public void borrowItem(String memberId, String itemId) {
        Member member = memberService.findMemberById(memberId);
        LibraryItem item = libraryService.findItemById(itemId);

        if (member == null) {
            System.out.println("Error: Member not found!");
            return;
        }
        if (item == null) {
            System.out.println("Error: Item not found!");
            return;
        }
        if (!item.isAvailable()) {
            System.out.println("Error: Item '" + item.getTitle() + "' is already borrowed!");
            return;
        }

        // Action Update both sides
        item.setAvailable(false);
        member.borrowItem(item);
        System.out.println("Success! " + member.getName() + " borrowed " + item.getTitle());
    }

    /**
     * The Return Logic:
     * Reverses the borrowing process.
     */
    public void returnItem(String memberId, String itemId) {
        Member member = memberService.findMemberById(memberId);
        LibraryItem item = libraryService.findItemById(itemId);

        if (member != null && item != null) {
            item.setAvailable(true);
            member.returnItem(item);
            System.out.println("Success! Item '" + item.getTitle() + "' has been returned.");
        } else {
            System.out.println("Error: Could not process return. Check IDs.");
        }
    }
}