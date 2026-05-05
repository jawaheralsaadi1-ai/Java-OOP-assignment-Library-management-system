import menu.Menu;
import services.BorrowService;
import services.LibraryService;
import services.MemberService;

public class Main {
    public static void main(String[] args) {
        // 1. Setup Services (The Engines)
        LibraryService libService = new LibraryService();
        MemberService memService = new MemberService();
//
        // 2. Setup Coordination (The Bridge)
        BorrowService borrowService = new BorrowService(libService, memService);

        // 3. Setup UI (The Dashboard)
        Menu menu = new Menu(libService, memService, borrowService);

        // 4. Start the engine!
        menu.start();
    }
}