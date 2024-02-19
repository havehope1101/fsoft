package model;

import check.ConsoleColors;

public class Books extends Document {
    private String bookName;
    private String authorName;
    private String category;
    private int pageNumber;
    private double bookPrice;

    public Books() {
    }

    public Books(String documentId, String publisherName, int releaseNumber, String bookName, String authorName, String category, int pageNumber, double bookPrice) {
        super(documentId, publisherName, releaseNumber);
        this.bookName = bookName;
        this.authorName = authorName;
        this.category = category;
        this.pageNumber = pageNumber;
        this.bookPrice = bookPrice;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    @Override
    public String toString() {
        return "Mã Sách: " + ConsoleColors.PURPLE_BOLD_BRIGHT + super.getDocumentId() + "\n" + ConsoleColors.RESET +
                "Nhà Xuất Bản: " + ConsoleColors.PURPLE_BOLD_BRIGHT + super.getPublisherName() + "\n" + ConsoleColors.RESET +
                "Tên Sách: " + ConsoleColors.PURPLE_BOLD_BRIGHT + this.getBookName() + "\n" + ConsoleColors.RESET +
                "Tác Giả: " + ConsoleColors.PURPLE_BOLD_BRIGHT + this.getAuthorName() + "\n" + ConsoleColors.RESET +
                "Thể Loại: " + ConsoleColors.PURPLE_BOLD_BRIGHT + this.getCategory() + "\n" + ConsoleColors.RESET +
                "Số Lượng: " + ConsoleColors.PURPLE_BOLD_BRIGHT + super.getReleaseNumber() + "\n" + ConsoleColors.RESET +
                "Số Trang: " + ConsoleColors.PURPLE_BOLD_BRIGHT + this.getPageNumber() + "\n" + ConsoleColors.RESET +
                "Giá: " + ConsoleColors.PURPLE_BOLD_BRIGHT + this.getBookPrice() + " VNĐ" + ConsoleColors.RESET;
    }
}
