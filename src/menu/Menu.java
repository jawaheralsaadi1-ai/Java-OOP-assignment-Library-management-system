package menu;

import entities.Address;
import entities.Book;
import entities.Magazine;
import entities.Member;
import services.BorrowService;
import services.LibraryService;
import services.MemberService;
import java.util.Scanner;

/**
 * This is the User Interface (UI). It doesn't do "logic" - it just talks to the user
 * and calls the right Service to do the job.
 */
public class Menu {
    private final LibraryService libraryService;
    private final MemberService memberService;
    private final BorrowService borrowingService;
    private final Scanner scanner;

    public Menu(LibraryService lib, MemberService mem, BorrowService borrow) {
        this.libraryService = lib;
        this.memberService = mem;
        this.borrowingService = borrow;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. Add Magazine");
            System.out.println("3. List Available Items");
            System.out.println("4. Register Member");
            System.out.println("5. List All Members");
            System.out.println("6. Borrow Item");
            System.out.println("7. Return Item");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addBook();
                case 2 -> addMagazine();
                case 3 -> libraryService.listAvailableItems();
                case 4 -> registerMember();
                case 5 -> memberService.listAllMembers();
                case 6 -> borrowProcess();
                case 7 -> returnProcess();
                case 0 -> {
                    System.out.println("Exiting... Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void addBook() {
        System.out.print("Enter ID: "); String id = scanner.nextLine();
        System.out.print("Enter Title: "); String title = scanner.nextLine();
        System.out.print("Enter Author: "); String author = scanner.nextLine();
        libraryService.addItem(new Book(id, title, author));
        System.out.println("Book added successfully!");
    }

    private void addMagazine() {
        System.out.print("Enter ID: "); String id = scanner.nextLine();
        System.out.print("Enter Title: "); String title = scanner.nextLine();
        System.out.print("Enter Issue Number: "); String issue = scanner.nextLine();
        libraryService.addItem(new Magazine(id, title, issue));
        System.out.println("Magazine added successfully!");
    }

    private void registerMember() {
        System.out.print("Enter Member ID: "); String mid = scanner.nextLine();
        System.out.print("Enter Name: "); String name = scanner.nextLine();
        System.out.print("Enter Street: "); String street = scanner.nextLine();
        System.out.print("Enter City: "); String city = scanner.nextLine();
        System.out.print("Enter Postal Code: "); String zip = scanner.nextLine();

        Address addr = new Address(street, city, zip);
        memberService.registerMember(new Member(mid, name, addr));
        System.out.println("Member registered!");
    }

    private void borrowProcess() {
        System.out.print("Enter Member ID: "); String mid = scanner.nextLine();
        System.out.print("Enter Item ID to borrow: "); String iid = scanner.nextLine();
        borrowingService.borrowItem(mid, iid);
    }

    private void returnProcess() {
        System.out.print("Enter Member ID: "); String mid = scanner.nextLine();
        System.out.print("Enter Item ID to return: "); String iid = scanner.nextLine();
        borrowingService.returnItem(mid, iid);
    }
}