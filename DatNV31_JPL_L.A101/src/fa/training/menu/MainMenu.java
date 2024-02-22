package fa.training.menu;

import fa.training.entities.Book;
import fa.training.entities.Magazine;
import fa.training.services.manager.BookManagement;
import fa.training.services.manager.MagazineManagement;
import fa.training.utils.Validate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MainMenu {
    private Validate validate = new Validate();
    private List<Book> bookList = new ArrayList<>();
    private BookManagement bookManagement = new BookManagement();
    private List<Magazine> magazineList = new ArrayList<>();
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

            switch (choice) {
                case 1:
                    this.addBook();
                    break;
                case 2:
                    this.addMagazine();
                    break;
                case 3:
                    this.displayBooksAndMagazines();
                    break;
                case 4:
                    this.addAuthor();
                    break;
                case 5:
                    this.displayTop10Magazines();
                    break;
                case 6:
                    this.searchBook();
                    break;
                default:
                    break;
            }
        } while (choice != 0);
    }

    private void addBook()  {
        String bookIsbn;
        System.out.println("--------Add Book-------");
        while (true) {
            String regex = "^\\d{3,4}-\\d{1,4}-\\d{1,4}-\\d{4}$";
            String str = "Input isbn: ";
            bookIsbn = validate.checkRegex(str, regex);
            if (bookManagement.findIndexById(bookIsbn) == -1) {
                break;
            }
            System.out.println("Please add new isbn!");
        }
        System.out.println("");
        System.out.println("Input Publication Price:");
        String publicationPrice = input.nextLine();

        System.out.println("Input Author: ");
        String author = input.nextLine();
        Set<String> authorName = bookManagement.inputAuthor(author);

        System.out.println("Input Publication Year of book:");
        int pubYear = Integer.parseInt(input.nextLine());

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

        Book book = new Book(pubYear, publisher, date, bookIsbn, authorName, publicationPrice);
        bookManagement.add(book);

        System.out.println("Book Added");
    }

    private void addMagazine()  {

        System.out.println("Input Author of Magazine:");

        String authorMagazine = input.nextLine();

        System.out.println("Input Volume: ");
        int volume = Integer.parseInt(input.nextLine());

        System.out.println("Input Edition: ");
        int edition = Integer.parseInt(input.nextLine());

        System.out.println("Input Publication Year:");
        int pubYear = Integer.parseInt(input.nextLine());

        System.out.println("Input Publisher:");
        String publisher = input.nextLine();

        System.out.println("Input Publication Date(dd/mm/yyyy):");
        String dateStr = input.next();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Error parsing the date. Please use the format dd/MM/yyyy.");
            e.printStackTrace();
        }

        Magazine magazine = new Magazine(pubYear, publisher, date, authorMagazine, volume, edition);
        magazineManagement.add(magazine);

        System.out.println("Magazine Added");
    }

    private void displayBooksAndMagazines() {
        System.out.print("Publisher:");
        String publisher = input.nextLine();
        System.out.print("Publication year:");
        int publicationYear = Integer.parseInt(input.nextLine());
        System.out.println("Books and Magazines have same publisher and publication year");
        System.out.println("===Book===");
        bookManagement.displayData(bookList, publisher, publicationYear);
        System.out.println("===Magazine===");
        magazineManagement.displayData(magazineList, publisher, publicationYear);
    };

    private void addAuthor() {
        String bookIsbn;
        while (true) {
            String regex = ".*";
            String str = "Input Isbn: ";
            bookIsbn = validate.checkRegex(str, regex);
            if (bookManagement.findIndexById(bookIsbn) != -1) {
                System.out.println("Input name of author:");
                input.nextLine();
                String newAuthor = input.nextLine();
                bookManagement.inputAuthor(newAuthor);
                System.out.println("Add successfully");
                break;
            } else {
                System.out.println("Isbn not exists. Please enter a different one\n");
            }
        }
    }

    private void displayTop10Magazines() {
        magazineManagement.displayTop10(magazineList);
    }

    private void searchBook() {
        int choice = -1;
        do {
            String str =  " Search Book \n" +
                    "1. Search Book by isbn\n" +
                    "2. Seach Book by author\n" +
                    "3. Seach Book by publisher\n" ;
            System.out.println(str);
            System.out.println("----------" );
            System.out.print("Input your choice: " );
            choice = validate.checkInput();
            System.out.println("----------" );

            switch (choice) {
                case 1:
                    this.findByIsbn();
                    break;
                case 2:
                    this.findByAuthor();
                    break;
                case 3:
                    this.findByPublisher();
                    break;
                default:
                    break;
            }
        } while (choice != 0);
    }

    private void findByIsbn(){
        System.out.println("Search Book by isbn ");
        System.out.print("Please input Isbn: ");
        String bookIsbn = input.nextLine();
        System.out.println("----------" );
        List<Book> list = bookManagement.findByName(bookIsbn);
        if (list.size() != 0) {
            for (Book books : list) {
                System.out.println(books.toString());
                System.out.println( "**********" );
            }
        } else {
            System.out.println("Book Not Found !!!" );

            System.out.println("//////////");
        }
    };

    private void findByAuthor(){
        System.out.println(" Search Book by author ");
        System.out.print("Please input author: ");
        String bookAuthor = input.nextLine();
        System.out.println("----------" );
        List<Book> list = bookManagement.findByAuthor(bookAuthor);
        if (list.size() != 0) {
            for (Book books : list) {
                System.out.println(books.toString());
                System.out.println( "**********" );
            }
        } else {
            System.out.println("Book Not Found !!!" );

            System.out.println("//////////");
        }
    }

    private void findByPublisher(){
        System.out.println("Search Book by Publisher ");
        System.out.print("Please input Publisher: ");
        String bookPublisher = input.nextLine();
        System.out.println("----------" );
        List<Book> list = bookManagement.findByPublisher(bookPublisher);
        if (list.size() != 0) {
            for (Book books : list) {
                System.out.println(books.toString());
                System.out.println( "**********" );
            }
        } else {
            System.out.println("Book Not Found !!!" );

            System.out.println("//////////");
        }
    }
}

