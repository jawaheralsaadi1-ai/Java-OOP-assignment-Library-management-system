//package for grouping related classes
package services;// Must be matches with our file name
// its means that this class is inside folder called services
//Using to organize the project

import entities.Member;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the 'Manager' for all library members.
 * Its job is to handle registrations and search for people in our system.
 */
public class MemberService {
    // A list to store all registered members
    private final List<Member> members;

    public MemberService() {
        this.members = new ArrayList<>();
    }

    /**
     * Adds a new member to the library system.
     */
    public void registerMember(Member member) {
        members.add(member);
    }

    /**
     * using the ID to find a member.
     * This is main for the borrowing process later
     */
    public Member findMemberById(String id) {
        for (Member member : members) {
            if (member.getMemberId().equalsIgnoreCase(id)) {
                return member;
            }
        }
        return null; // Member not found
    }

    /**
     * Prints all registered members and their formatted addresses.
     */
    public void listAllMembers() {
        System.out.println("\n--- Registered Library Members ---");
        if (members.isEmpty()) {
            System.out.println("No members registered yet.");
        } else {
            for (Member member : members) {
                // Here, Member asks its Address object for the formatted string
                System.out.println(member.getFullMemberDetails());
            }
        }
    }
}