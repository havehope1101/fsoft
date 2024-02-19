package menu;

import check.Check;
import check.ConsoleColors;
import management.manager.BookManagement;
import model.Books;

import java.util.List;
import java.util.Scanner;

public class BookMenu {
    private BookManagement bookManagement = new BookManagement();
    private Check check = new Check();
    private Scanner input = new Scanner(System.in);

    public void bookMenu() {
        int choice = -1;
        do {
            String str = ConsoleColors.BLUE_BOLD_BRIGHT + "===== Quản Lý Sách =====\n" + ConsoleColors.RESET +
                    "1. Thêm Sách\n" +
                    "2. Sửa Sách\n" +
                    "3. Xóa Sách\n" +
                    "4. Tìm Kiếm Sách\n" +
                    "5. Hiển Thị Sách\n" +
                    ConsoleColors.RED_BOLD + "0. Thoát" + ConsoleColors.RESET;
            System.out.println(str);
            System.out.println(ConsoleColors.CYAN_BOLD + "----------" + ConsoleColors.RESET);
            System.out.print(ConsoleColors.GREEN_BOLD_BRIGHT + "Nhập Lựa Chọn: " + ConsoleColors.RESET);
            choice = check.checkInput();
            System.out.println(ConsoleColors.CYAN_BOLD + "----------" + ConsoleColors.RESET);

            switch (choice) {
                case 1:
                    addMenu();
                    break;
                case 2:
                    editMenu();
                    break;
                case 3:
                    deleteMenu();
                    break;
                case 4:
                    findMenu();
                    break;
                case 5:
                    showAllBooks();
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

    private void addMenu() {
        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "+++++ Thêm Sách +++++" + ConsoleColors.RESET);
        String documentId;
        while (true) {
            String regex = "^b\\d+$";
            String str = "Nhâp Id Sách(vd: b01): ";
            documentId = check.checkRegex(str, regex);
            if (bookManagement.findIndexById(documentId) == -1) {
                break;
            }
            System.out.println(ConsoleColors.RED_BOLD + "Id Sách Đã Có !!!" + ConsoleColors.RESET);
        }

        System.out.print("Nhập Nhà Xuất Bản: ");
        String publisherName = input.nextLine();

        String str1 = "Số Lượng: ";
        System.out.print(str1);
        int releaseNumber = check.checkInputNumber(str1);

        System.out.print("Nhập Tên Sách: ");
        String bookName = input.nextLine();

        System.out.print("Nhập Tên Tác Giả: ");
        String authorName = input.nextLine();

        System.out.print("Nhập Thể Loại: ");
        String category = input.nextLine();

        String str2 = "Nhập Số Trang: ";
        System.out.print(str2);
        int pageNumber = check.checkInputNumber(str2);

        String str3 = "Nhập Giá: ";
        System.out.print(str3);
        double bookPrice = check.checkInputNumber(str3);

        Books books = new Books(documentId, publisherName, releaseNumber, bookName, authorName, category, pageNumber, bookPrice);
        bookManagement.add(books);

        System.out.println("//////////");
    }

    private void editMenu() {
        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "!!!!! Sửa Sách !!!!!" + ConsoleColors.RESET);
        String regex = "^b\\d+$";
        String str = "Nhâp Id Sách(vd: b01): ";
        String documentId = check.checkRegex(str, regex);
        if (bookManagement.findIndexById(documentId) == -1) {
            System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Không Có Id Muốn Sửa !!!" + ConsoleColors.RESET);
        } else {
            System.out.println(bookManagement.getAll().get(bookManagement.findIndexById(documentId)).toString());

            System.out.print("Nhập Nhà Xuất Bản: ");
            String publisherName = input.nextLine();

            String str1 = "Số Lượng: ";
            System.out.print(str1);
            int releaseNumber = check.checkInputNumber(str1);

            System.out.print("Nhập Tên Sách: ");
            String bookName = input.nextLine();

            System.out.print("Nhập Tên Tác Giả: ");
            String authorName = input.nextLine();

            System.out.print("Nhập Thể Loại: ");
            String category = input.nextLine();

            String str2 = "Nhập Số Trang: ";
            System.out.print(str2);
            int pageNumber = check.checkInputNumber(str2);

            String str3 = "Nhập Giá: ";
            System.out.print(str3);
            double bookPrice = check.checkInputNumber(str3);

            Books books = new Books(documentId, publisherName, releaseNumber, bookName, authorName, category, pageNumber, bookPrice);
            bookManagement.edit(documentId, books);

            System.out.println("//////////");
        }
    }

    private void deleteMenu() {
        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "----- Xóa Sách -----" + ConsoleColors.RESET);
        String regex = "^b\\d+$";
        String str = "Nhâp Id Sách(vd: b01): ";
        String documentId = check.checkRegex(str, regex);
        bookManagement.delete(documentId);

        System.out.println("//////////");
    }

    private void findMenu() {
        int choice = -1;
        do {
            String str = ConsoleColors.BLUE_BOLD_BRIGHT + "%%%%% Tìm Sách %%%%%\n" + ConsoleColors.RESET +
                    "1. Tìm Sách Theo Id\n" +
                    "2. Tìm Sách Theo Tên\n" +
                    ConsoleColors.RED_BOLD + "0. Thoát" + ConsoleColors.RESET;
            System.out.println(str);
            System.out.println(ConsoleColors.CYAN_BOLD + "----------" + ConsoleColors.RESET);
            System.out.print(ConsoleColors.GREEN_BOLD_BRIGHT + "Nhập Lựa Chọn: " + ConsoleColors.RESET);
            choice = check.checkInput();
            System.out.println(ConsoleColors.CYAN_BOLD + "----------" + ConsoleColors.RESET);

            switch (choice) {
                case 1:
                    findById();
                    break;
                case 2:
                    findByName();
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

    private void findById() {
        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "%%%%% Tìm Sách Theo Id %%%%%" + ConsoleColors.RESET);
        String regex = "^b\\d+$";
        String str = "Nhâp Id Sách(vd: b01): ";
        String documentId = check.checkRegex(str, regex);
        System.out.println(ConsoleColors.CYAN_BOLD + "----------" + ConsoleColors.RESET);
        int index = bookManagement.findIndexById(documentId);
        if (index != -1) {
            System.out.println(bookManagement.getAll().get(index).toString());

            System.out.println("//////////");
        } else {
            System.out.println(ConsoleColors.RED_BOLD + "Không Tìm Thấy Sách !!!" + ConsoleColors.RESET);

            System.out.println("//////////");
        }
    }

    private void findByName() {
        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "%%%%% Tìm Sách Theo Tên %%%%%" + ConsoleColors.RESET);
        System.out.print("Nhập Tên Sách: ");
        String bookName = input.nextLine();
        System.out.println(ConsoleColors.CYAN_BOLD + "----------" + ConsoleColors.RESET);
        List<Books> list = bookManagement.findByName(bookName);
        if (list.size() != 0) {
            for (Books books : list) {
                System.out.println(books.toString());
                System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "**********" + ConsoleColors.RESET);
            }
        } else {
            System.out.println(ConsoleColors.RED_BOLD + "Không Tìm Thấy Sách !!!" + ConsoleColors.RESET);

            System.out.println("//////////");
        }
    }

    private void showAllBooks() {
        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "***** Danh Sách Sách *****" + ConsoleColors.RESET);
        for (Books books : bookManagement.getAll()) {
            System.out.println(books.toString());
            System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "**********" + ConsoleColors.RESET);
        }
        System.out.println("//////////");
    }
}
