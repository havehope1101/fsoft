package menu;

import check.Check;
import check.ConsoleColors;
import ioFile.BookIOFile;
import ioFile.ComicsIOFile;
import management.manager.BookManagement;
import management.manager.ComicsManagement;
import management.manager.CustomerManagement;
import management.manager.InvoiceManagement;
import model.Books;
import model.Comics;
import model.Invoice;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class InvoiceMenu {
    private InvoiceManagement invoiceManagement = new InvoiceManagement();
    private BookManagement bookManagement = new BookManagement();
    private ComicsManagement comicsManagement = new ComicsManagement();
    private CustomerManagement customerManagement = new CustomerManagement();
    private BookIOFile bookIOFile = new BookIOFile();
    private ComicsIOFile comicsIOFile = new ComicsIOFile();
    private Check check = new Check();
    private CustomerMenu customerMenu = new CustomerMenu();

    public void invoiceMenu() {
        int choice = -1;
        do {
            String str = ConsoleColors.BLUE_BOLD_BRIGHT + "===== Bán Sách =====\n" + ConsoleColors.RESET +
                    "1. Thêm Hóa Đơn\n" +
                    "2. Hiển Thị Hóa Đơn\n" +
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
                    showAllInvoice();
                    break;
                case 0:
                    break;
                default:
                    System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Không Có Lựa Chọn !!!" + ConsoleColors.RESET);
                    System.out.println(ConsoleColors.CYAN_BOLD + "----------" + ConsoleColors.RESET);
                    break;
            }
        } while (choice != -0);
    }

    private void addMenu() {
        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "+++++ Thêm Hóa Đơn +++++" + ConsoleColors.RESET);
        String invoiceId;
        while (true) {
            String regex = "^iv\\d+$";
            String str = "Nhâp Id Hóa Đơn(vd: iv01): ";
            invoiceId = check.checkRegex(str, regex);
            if (invoiceManagement.findIndexById(invoiceId) == -1) {
                break;
            }
            System.out.println(ConsoleColors.RED_BOLD + "Id Hóa Đơn Đã Có !!!" + ConsoleColors.RESET);
        }

        String customerId;
        while (true) {
            String regex = "^kh\\d+$";
            String str = "Nhập Id Khách Hàng(vd: kh01): ";
            customerId = check.checkRegex(str, regex);
            if (customerManagement.findIndexById(customerId) != -1) {
                break;
            }
            System.out.println(ConsoleColors.RED_BOLD + "Không Có Id Khách Hàng. Hãy Thêm Khách Hàng !!!" + ConsoleColors.RESET);
            customerMenu.customerMenu();
        }

        String detail = "";
        String bookId;
        String comicsId;
        do {
            while (true) {
                String regexBook = "^b\\d+$";
                String str = "Nhập Id Sách Cần Mua(vd: b01)(Nhập b0 Để Thoát Nhập): ";
                bookId = check.checkRegex(str, regexBook);
                if (bookId.equals("b0")) {
                    break;
                } else if (bookManagement.findIndexById(bookId) != -1) {
                    List<Books> list = bookManagement.getAll();
                    if (list.get(bookManagement.findIndexById(bookId)).getReleaseNumber() > 0) {
                        list.get(bookManagement.findIndexById(bookId)).setReleaseNumber(
                                list.get(bookManagement.findIndexById(bookId)).getReleaseNumber() - 1
                        );
                        try {
                            bookIOFile.writerFile(list);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    } else {
                        System.out.println(ConsoleColors.RED_BOLD + "Đã Hết. Hãy Chọn Sách Khác !!!" + ConsoleColors.RESET);
                        continue;
                    }
                }
                System.out.println(ConsoleColors.RED_BOLD + "Không Có Id Sách !!!" + ConsoleColors.RESET);
            }
            if (!bookId.equals("b0")) {
                detail += bookId + " ";
            }
        } while (!bookId.equals("b0"));

        do {
            while (true) {
                String regexComics = "^c\\d+$";
                String str = "Nhập Id Truyện Cần Mua(vd: c01)(Nhập c0 Để Thoát Nhập): ";
                comicsId = check.checkRegex(str, regexComics);
                if (comicsId.equals("c0")) {
                    break;
                } else if (comicsManagement.findIndexById(comicsId) != -1) {
                    List<Comics> list = comicsManagement.getAll();
                    if (list.get(comicsManagement.findIndexById(comicsId)).getReleaseNumber() > 0) {
                        list.get(comicsManagement.findIndexById(comicsId)).setReleaseNumber(
                                list.get(comicsManagement.findIndexById(comicsId)).getReleaseNumber() - 1
                        );
                        try {
                            comicsIOFile.writerFile(list);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    } else {
                        System.out.println(ConsoleColors.RED_BOLD + "Đã Hết. Hãy Chọn Truyện Khác !!!" + ConsoleColors.RESET);
                        continue;
                    }
                }
                System.out.println(ConsoleColors.RED_BOLD + "Không Có Id Truyện !!!" + ConsoleColors.RESET);
            }
            if (!comicsId.equals("c0")) {
                detail += comicsId + " ";
            }
        } while (!comicsId.equals("c0"));

        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String formattedDate = dateFormat.format(currentDate);

        double total = 0;
        String[] data = detail.split(" ");
        for (String s : data) {
            if (s.contains("b")) {
                total += bookManagement.getAll().get(bookManagement.findIndexById(s)).getBookPrice();
            } else {
                total += comicsManagement.getAll().get(comicsManagement.findIndexById(s)).getComicsPrice();
            }
        }

        System.out.println("Ngày Tạo Hóa Đơn: " + formattedDate);
        System.out.println("Tổng Tiền: " + total + " VNĐ");

        Invoice invoice = new Invoice(invoiceId, customerId, detail, formattedDate, total);
        invoiceManagement.add(invoice);

        System.out.println("//////////");
    }

    private void showAllInvoice() {
        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "***** Danh Sách Hóa Đơn *****" + ConsoleColors.RESET);
        for (Invoice invoice : invoiceManagement.getAll()) {
            System.out.println(invoice.toString());
            System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "**********" + ConsoleColors.RESET);
        }
        System.out.println("//////////");
    }
}
