package menu;

import check.Check;
import check.ConsoleColors;
import management.manager.ComicsManagement;
import model.Comics;

import java.util.List;
import java.util.Scanner;

public class ComicsMenu {
    private ComicsManagement comicsManagement = new ComicsManagement();
    private Check check = new Check();
    private Scanner input = new Scanner(System.in);

    public void comicsMenu() {
        int choice = -1;
        do {
            String str = ConsoleColors.BLUE_BOLD_BRIGHT + "===== Quản Lý Truyện =====\n" + ConsoleColors.RESET +
                    "1. Thêm Truyện\n" +
                    "2. Sửa Truyện\n" +
                    "3. Xóa Truyện\n" +
                    "4. Tìm Kiếm Truyện\n" +
                    "5. Hiển Thị Truyện\n" +
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
                    showAllComics();
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
        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "+++++ Thêm Truyện +++++" + ConsoleColors.RESET);
        String documentId;
        while (true) {
            String regex = "^c\\d+$";
            String str = "Nhâp Id Truyện(vd: c01): ";
            documentId = check.checkRegex(str, regex);
            if (comicsManagement.findIndexById(documentId) == -1) {
                break;
            }
            System.out.println(ConsoleColors.RED_BOLD + "Id Truyện Đã Có !!!" + ConsoleColors.RESET);
        }

        System.out.print("Nhập Nhà Xuất Bản: ");
        String publisherName = input.nextLine();

        String str1 = "Số Lượng: ";
        System.out.print(str1);
        int releaseNumber = check.checkInputNumber(str1);

        System.out.print("Nhập Tên Truyện: ");
        String comicsName = input.nextLine();

        System.out.print("Nhập Tên Tác Giả: ");
        String authorName = input.nextLine();

        System.out.print("Nhập Thể Loại: ");
        String category = input.nextLine();

        String str2 = "Nhập Số Trang: ";
        System.out.print(str2);
        int pageNumber = check.checkInputNumber(str2);

        String str3 = "Nhập Giá: ";
        System.out.print(str3);
        double comicsPrice = check.checkInputNumber(str3);

        Comics comics = new Comics(documentId, publisherName, releaseNumber, comicsName, authorName, category, pageNumber, comicsPrice);
        comicsManagement.add(comics);

        System.out.println("//////////");
    }

    private void editMenu() {
        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "!!!!! Sửa Truyện !!!!!" + ConsoleColors.RESET);
        String regex = "^c\\d+$";
        String str = "Nhâp Id Truyện(vd: c01): ";
        String documentId = check.checkRegex(str, regex);
        if (comicsManagement.findIndexById(documentId) == -1) {
            System.out.println(ConsoleColors.RED_BOLD + "Không Có Id Muốn Sửa !!!" + ConsoleColors.RESET);
        } else {
            System.out.println(comicsManagement.getAll().get(comicsManagement.findIndexById(documentId)).toString());

            System.out.print("Nhập Nhà Xuất Bản: ");
            String publisherName = input.nextLine();

            String str1 = "Số Lượng: ";
            System.out.print(str1);
            int releaseNumber = check.checkInputNumber(str1);

            System.out.print("Nhập Tên Truyện: ");
            String comicsName = input.nextLine();

            System.out.print("Nhập Tên Tác Giả: ");
            String authorName = input.nextLine();

            System.out.print("Nhập Thể Loại: ");
            String category = input.nextLine();

            String str2 = "Nhập Số Trang: ";
            System.out.print(str2);
            int pageNumber = check.checkInputNumber(str2);

            String str3 = "Nhập Giá: ";
            System.out.print(str3);
            double comicsPrice = check.checkInputNumber(str3);

            Comics comics = new Comics(documentId, publisherName, releaseNumber, comicsName, authorName, category, pageNumber, comicsPrice);
            comicsManagement.edit(documentId, comics);

            System.out.println("//////////");
        }
    }

    private void deleteMenu() {
        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "----- Xóa Truyện -----" + ConsoleColors.RESET);
        String regex = "^c\\d+$";
        String str = "Nhâp Id Truyện(vd: c01): ";
        String documentId = check.checkRegex(str, regex);
        comicsManagement.delete(documentId);

        System.out.println("//////////");
    }

    private void findMenu() {
        int choice = -1;
        do {
            String str = ConsoleColors.BLUE_BOLD_BRIGHT + "%%%%% Tìm Truyện %%%%%\n" + ConsoleColors.RESET +
                    "1. Tìm Truyện Theo Id\n" +
                    "2. Tìm Truyện Theo Tên\n" +
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
        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "%%%%% Tìm Truyện Theo Id %%%%%" + ConsoleColors.RESET);
        String regex = "^c\\d+$";
        String str = "Nhâp Id Truyện(vd: c01): ";
        String documentId = check.checkRegex(str, regex);
        System.out.println(ConsoleColors.CYAN_BOLD + "----------" + ConsoleColors.RESET);
        int index = comicsManagement.findIndexById(documentId);
        if (index != -1) {
            System.out.println(comicsManagement.getAll().get(index).toString());

            System.out.println("//////////");
        } else {
            System.out.println(ConsoleColors.RED_BOLD + "Không Tìm Thấy Truyện !!!" + ConsoleColors.RESET);

            System.out.println("//////////");
        }
    }

    private void findByName() {
        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "%%%%% Tìm Truyện Theo Tên %%%%%" + ConsoleColors.RESET);
        System.out.print("Nhập Tên Truyện: ");
        String comicsName = input.nextLine();
        System.out.println(ConsoleColors.CYAN_BOLD + "----------" + ConsoleColors.RESET);
        List<Comics> list = comicsManagement.findByName(comicsName);
        if (list.size() != 0) {
            for (Comics comics : list) {
                System.out.println(comics.toString());
                System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "**********" + ConsoleColors.RESET);
            }
        } else {
            System.out.println(ConsoleColors.RED_BOLD + "Không Tìm Thấy Truyện !!!" + ConsoleColors.RESET);

            System.out.println("//////////");
        }
    }

    private void showAllComics() {
        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "***** Danh Sách Truyện *****" + ConsoleColors.RESET);
        for (Comics comics : comicsManagement.getAll()) {
            System.out.println(comics.toString());
            System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "**********" + ConsoleColors.RESET);
        }
        System.out.println("//////////");
    }
}
