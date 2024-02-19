package menu;

import check.Check;
import check.ConsoleColors;

public class MainMenu {
    private Check check = new Check();
    private BookMenu bookMenu = new BookMenu();
    private ComicsMenu comicsMenu = new ComicsMenu();
    private CustomerMenu customerMenu = new CustomerMenu();
    private InvoiceMenu invoiceMenu = new InvoiceMenu();

    public void mainMenu() {
        int choice = -1;
        do {
            String str = ConsoleColors.GREEN_BOLD + "===== Book Store =====\n" + ConsoleColors.RESET +
                    ConsoleColors.YELLOW_BOLD + "1. Quản Lý Cửa Hàng\n" + ConsoleColors.RESET +
                    ConsoleColors.BLUE_BOLD + "2. Quản Lý Khách Hàng\n" + ConsoleColors.RESET +
                    ConsoleColors.PURPLE_BOLD + "3. Bán Sách\n" + ConsoleColors.RESET +
                    ConsoleColors.RED_BOLD + "0. Thoát" + ConsoleColors.RESET;
            System.out.println(str);
            System.out.println(ConsoleColors.CYAN_BOLD + "----------" + ConsoleColors.RESET);
            System.out.print(ConsoleColors.GREEN_BOLD_BRIGHT + "Nhập Lựa Chọn: " + ConsoleColors.RESET);
            choice = check.checkInput();
            System.out.println(ConsoleColors.CYAN_BOLD + "----------" + ConsoleColors.RESET);

            switch (choice) {
                case 1:
                    this.documentMenu();
                    break;
                case 2:
                    customerMenu.customerMenu();
                    break;
                case 3:
                    invoiceMenu.invoiceMenu();
                    break;
                case 0:
                    break;
                default:
                    System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Không Có Lựa Chọn !!!" + ConsoleColors.RESET);
                    System.out.println(ConsoleColors.CYAN_BOLD + "----------" + ConsoleColors.RESET);
                    break;
            }
        } while (choice != 0);
    }

    private void documentMenu() {
        int choice = -1;
        do {
            String str = ConsoleColors.BLUE_BOLD_BRIGHT + "===== Quản Lý Cửa Hàng =====\n" + ConsoleColors.RESET +
                    "1. Quản Lý Sách\n" +
                    "2. Quản Lý Truyện\n" +
                    ConsoleColors.RED_BOLD + "0. Thoát" + ConsoleColors.RESET;
            System.out.println(str);
            System.out.println(ConsoleColors.CYAN_BOLD + "----------" + ConsoleColors.RESET);
            System.out.print(ConsoleColors.GREEN_BOLD_BRIGHT + "Nhập Lựa Chọn: " + ConsoleColors.RESET);
            choice = check.checkInput();
            System.out.println(ConsoleColors.CYAN_BOLD + "----------" + ConsoleColors.RESET);

            switch (choice) {
                case 1:
                    bookMenu.bookMenu();
                    break;
                case 2:
                    comicsMenu.comicsMenu();
                    break;
                case 0:
                    break;
                default:
                    System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Không Có Lựa Chọn !!!" + ConsoleColors.RESET);
                    System.out.println(ConsoleColors.CYAN_BOLD + "----------" + ConsoleColors.RESET);
                    break;
            }
        } while (choice != 0);
    }
}
