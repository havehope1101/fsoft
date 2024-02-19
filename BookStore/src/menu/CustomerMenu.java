package menu;

import check.Check;
import check.ConsoleColors;
import management.manager.CustomerManagement;
import model.Customer;

import java.util.List;
import java.util.Scanner;

public class CustomerMenu {
    private CustomerManagement customerManagement = new CustomerManagement();
    private Check check = new Check();
    private Scanner input = new Scanner(System.in);

    public void customerMenu() {
        int choice = -1;
        do {
            String str = ConsoleColors.BLUE_BOLD_BRIGHT + "===== Quản Lý Khách Hàng =====\n" + ConsoleColors.RESET +
                    "1. Thêm Khách Hàng\n" +
                    "2. Sửa Khách Hàng\n" +
                    "3. Xóa Khách Hàng\n" +
                    "4. Tìm Kiếm Khách Hàng\n" +
                    "5. Hiển Thị Khách Hàng\n" +
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
                    showAllCustomer();
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
        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "+++++ Thêm Khách Hàng +++++" + ConsoleColors.RESET);
        String customerId;
        while (true) {
            String regex = "^kh\\d+$";
            String str = "Nhập Id Khách Hàng(vd: kh01): ";
            customerId = check.checkRegex(str, regex);
            if (customerManagement.findIndexById(customerId) == -1) {
                break;
            }
            System.out.println(ConsoleColors.RED_BOLD + "Id Khách Hàng Đã Có !!!" + ConsoleColors.RESET);
        }

        System.out.print("Nhập Tên Khách Hàng: ");
        String name = input.nextLine();

        String strPhone = "Nhập Số Điện Thoại: ";
        String regexPhone = "^\\d+$";
        String phone = check.checkRegex(strPhone, regexPhone);

        System.out.print("Nhập Địa Chỉ: ");
        String address = input.nextLine();

        Customer customer = new Customer(customerId, name, phone, address);
        customerManagement.add(customer);

        System.out.println("//////////");
    }

    private void editMenu() {
        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "!!!!! Sửa Khách Hàng !!!!!" + ConsoleColors.RESET);
        String regex = "^kh\\d+$";
        String str = "Nhập Id Khách Hàng(vd: kh01): ";
        String customerId = check.checkRegex(str, regex);
        if (customerManagement.findIndexById(customerId) == -1) {
            System.out.println(ConsoleColors.RED_BOLD + "Không Có Id Muốn Sửa" + ConsoleColors.RESET);
        } else {
            System.out.println(customerManagement.getAll().get(customerManagement.findIndexById(customerId)).toString());

            System.out.print("Nhập Tên Khách Hàng: ");
            String name = input.nextLine();

            String strPhone = "Nhập Số Điện Thoại: ";
            String regexPhone = "^\\d+$";
            String phone = check.checkRegex(strPhone, regexPhone);

            System.out.print("Nhập Địa Chỉ: ");
            String address = input.nextLine();

            Customer customer = new Customer(customerId, name, phone, address);
            customerManagement.edit(customerId, customer);

            System.out.println("//////////");
        }
    }

    private void deleteMenu() {
        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "----- Xóa Khách Hàng -----" + ConsoleColors.RESET);
        String regex = "^kh\\d+$";
        String str = "Nhập Id Khách Hàng(vd: kh01): ";
        String customerId = check.checkRegex(str, regex);
        customerManagement.delete(customerId);

        System.out.println("//////////");
    }

    private void findMenu() {
        int choice = -1;
        do {
            String str = ConsoleColors.BLUE_BOLD_BRIGHT + "%%%%% Tìm Khách Hàng %%%%%\n" + ConsoleColors.RESET +
                    "1. Tìm Khách Hàng Theo Id\n" +
                    "2. Tìm Khách Hàng Theo Tên\n" +
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
        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "%%%%% Tìm Khách Hàng Theo Id %%%%%" + ConsoleColors.RESET);
        String regex = "^kh\\d+$";
        String str = "Nhâp Id Khách Hàng(vd: kh01): ";
        String customerId = check.checkRegex(str, regex);
        System.out.println(ConsoleColors.CYAN_BOLD + "----------" + ConsoleColors.RESET);
        int index = customerManagement.findIndexById(customerId);
        if (index != -1) {
            System.out.println(customerManagement.getAll().get(index).toString());

            System.out.println("//////////");
        } else {
            System.out.println(ConsoleColors.RED_BOLD + "Không Tìm Thấy Khách Hàng !!!" + ConsoleColors.RESET);

            System.out.println("//////////");
        }
    }

    private void findByName() {
        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "%%%%% Tìm Khách Hàng Theo Tên %%%%%" + ConsoleColors.RESET);
        System.out.print("Nhập Tên Khách Hàng: ");
        String name = input.nextLine();
        System.out.println(ConsoleColors.CYAN_BOLD + "----------" + ConsoleColors.RESET);
        List<Customer> list = customerManagement.findByName(name);
        if (list.size() != 0) {
            for (Customer customer : list) {
                System.out.println(customer.toString());
                System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "**********" + ConsoleColors.RESET);
            }
        } else {
            System.out.println(ConsoleColors.RED_BOLD + "Không Tìm Thấy Khách Hàng !!!" + ConsoleColors.RESET);

            System.out.println("//////////");
        }
    }

    private void showAllCustomer() {
        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "***** Danh Sách Khách Hàng *****" + ConsoleColors.RESET);
        for (Customer customer : customerManagement.getAll()) {
            System.out.println(customer.toString());
            System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "**********" + ConsoleColors.RESET);
        }
        System.out.println("//////////");
    }

}
