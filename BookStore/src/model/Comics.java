package model;

import check.ConsoleColors;

public class Comics extends Document {
    private String comicsName;
    private String authorName;
    private String category;
    private int pageNumber;
    private double comicsPrice;

    public Comics() {
    }

    public Comics(String documentId, String publisherName, int releaseNumber, String comicsName, String authorName, String category, int pageNumber, double comicsPrice) {
        super(documentId, publisherName, releaseNumber);
        this.comicsName = comicsName;
        this.authorName = authorName;
        this.category = category;
        this.pageNumber = pageNumber;
        this.comicsPrice = comicsPrice;
    }

    public String getComicsName() {
        return comicsName;
    }

    public void setComicsName(String comicsName) {
        this.comicsName = comicsName;
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

    public double getComicsPrice() {
        return comicsPrice;
    }

    public void setComicsPrice(double comicsPrice) {
        this.comicsPrice = comicsPrice;
    }

    @Override
    public String toString() {
        return "Mã Truyện: " + ConsoleColors.PURPLE_BOLD_BRIGHT + super.getDocumentId() + "\n" + ConsoleColors.RESET +
                "Nhà Xuất Bản: " + ConsoleColors.PURPLE_BOLD_BRIGHT + super.getPublisherName() + "\n" + ConsoleColors.RESET +
                "Tên Truyện: " + ConsoleColors.PURPLE_BOLD_BRIGHT + this.getComicsName() + "\n" + ConsoleColors.RESET +
                "Tác Giả: " + ConsoleColors.PURPLE_BOLD_BRIGHT + this.getAuthorName() + "\n" + ConsoleColors.RESET +
                "Thể Loại: " + ConsoleColors.PURPLE_BOLD_BRIGHT + this.getCategory() + "\n" + ConsoleColors.RESET +
                "Số Lượng: " + ConsoleColors.PURPLE_BOLD_BRIGHT + super.getReleaseNumber() + "\n" + ConsoleColors.RESET +
                "Số Trang: " + ConsoleColors.PURPLE_BOLD_BRIGHT + this.getPageNumber() + "\n" + ConsoleColors.RESET +
                "Giá: " + ConsoleColors.PURPLE_BOLD_BRIGHT + this.getComicsPrice() + " VNĐ" + ConsoleColors.RESET;
    }
}
