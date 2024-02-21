package fa.training.menu;

import fa.training.entities.Book;
import fa.training.entities.Magazine;
import fa.training.services.manager.BookManagement;
import fa.training.services.manager.MagazineManagement;
import fa.training.utils.Validate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MainMenu {
    private Validate validate = new Validate();
    private Book book = new Book();
    private BookManagement bookManagement = new BookManagement();
    private Magazine magazine = new Magazine();
    private MagazineManagement magazineManagement = new MagazineManagement();
    private Scanner input = new Scanner(System.in);

    public void mainMenu() {
        int choice = -1;
        do {
            String str = "===== LIBRARY MANAGEMENT SYSTEM =====\n" +
                    "1. Add a book\n" +
                    "2. Add a magazine\n" +
                    "3. Display books and magazines\n" +
                    "4. Add author to book\n" +
                    "5. Display top 10 of magazines by volume\n" +
                    "6. Search book by(isbn, author, publisher)";
            System.out.println(str);
            System.out.println("----------");
            System.out.print("Please choose function you'd like to do: ");
            choice = validate.checkInput();
            System.out.println("----------");

            switch (choice) {
                case 1:
                    this.addBook();
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

    private void addBook()  {
        String bookIsbn;
        System.out.println("Add Book");
        while (true) {
            String regex = ".*";
            String str = "Input isbn: ";
            bookIsbn = validate.checkRegex(str, regex);
            if (bookManagement.findIndexById(bookIsbn) == -1) {
                break;
            }
            System.out.println("Please add new isbn!");
        }
        System.out.println("Input Publication Price:");
        String publicationPrice = input.nextLine();

        System.out.println("Input Author: ");
        String author = input.nextLine();

        System.out.println("Input Publication Year:");
        int pubYear = input.nextInt();

        System.out.println("Input Publisher:");
        String publisher = input.nextLine();

        System.out.println("Input Publication Date(dd/mm/yyyy):");
        String dateStr = input.next();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Book book = new Book(pubYear, publisher, date, bookIsbn, author, publicationPrice);
        bookManagement.add(book);

        System.out.println("Book Added");
    }

    private void addMagazine()  {

        System.out.println("Input Author of Magazine:");
        String authorMagazine = input.nextLine();

        System.out.println("Input Volume: ");
        int volume = input.nextInt();

        System.out.println("Input Edition: ");
        int edition = input.nextInt();

        System.out.println("Input Publication Year:");
        int pubYear = input.nextInt();

        System.out.println("Input Publisher:");
        String publisher = input.nextLine();

        System.out.println("Input Publication Date(dd/mm/yyyy):");
        String dateStr = input.next();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Magazine magazine = new Magazine(pubYear, publisher, date, authorMagazine, volume, edition);
        magazineManagement.add(magazine);

        System.out.println("Magazine Added");
    }
}

