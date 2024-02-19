package model;

import check.ConsoleColors;

public class Invoice {
    private String invoiceId;
    private String customerId;
    private String detail;
    private String date;
    private double total;

    public Invoice() {
    }

    public Invoice(String invoiceId, String customerId, String detail, String date, double total) {
        this.invoiceId = invoiceId;
        this.customerId = customerId;
        this.detail = detail;
        this.date = date;
        this.total = total;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Id Hóa Đơn: " + ConsoleColors.PURPLE_BOLD_BRIGHT + getInvoiceId() + "\n" + ConsoleColors.RESET +
                "Id Khách Hàng: " + ConsoleColors.PURPLE_BOLD_BRIGHT + getCustomerId() + "\n" + ConsoleColors.RESET +
                "Chi Tiết: " + ConsoleColors.PURPLE_BOLD_BRIGHT + getDetail() + "\n" + ConsoleColors.RESET +
                "Ngày Mua: " + ConsoleColors.PURPLE_BOLD_BRIGHT + getDate() + "\n" + ConsoleColors.RESET +
                "Tổng Tiền: " + ConsoleColors.PURPLE_BOLD_BRIGHT + getTotal() + " VNĐ" + ConsoleColors.RESET;
    }
}
