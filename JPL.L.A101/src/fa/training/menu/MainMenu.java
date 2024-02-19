package fa.training.menu;

import fa.training.entities.Book;
import fa.training.entities.Magazine;
import fa.training.utils.Validate;

public class MainMenu {
    private Validate validate = new Validate();
    private Book book = new Book();
    private Magazine magazine = new Magazine();

    public void mainMenu() {
        int choice = -1;
        do {
            String str =  "===== LIBRARY MANAGEMENT SYSTEM =====\n"  +
                     "1. Add a book\n"  +
                     "2. Add a magazine\n"  +
                     "3. Display books and magazines\n" +
                     "4. Add author to book\n" +
                     "5. Display top 10 of magazines by volume\n" +
                     "6. Search book by(isbn, author, publisher)";
            System.out.println(str);
            System.out.println( "----------" );
            System.out.print( "Please choose function you'd like to do: " );
            choice = validate.checkInput();
            System.out.println( "----------" );

            switch (choice) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 0:
                    break;
                default:

                    break;
            }
        } while (choice != 0);

    }
}
