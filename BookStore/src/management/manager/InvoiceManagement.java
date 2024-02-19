package management.manager;

import check.ConsoleColors;
import ioFile.InvoiceIOFile;
import model.Invoice;

import java.io.IOException;
import java.util.List;

public class InvoiceManagement {
    private List<Invoice> invoiceList = null;
    private InvoiceIOFile invoiceIOFile = new InvoiceIOFile();

    public InvoiceManagement() {
        try {
            this.invoiceList = this.invoiceIOFile.readerFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void add(Invoice invoice) {
        try {
            this.invoiceList.add(invoice);
            this.invoiceIOFile.writerFile(invoiceList);
            System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "Thêm Thành Công !!!" + ConsoleColors.RESET);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int findIndexById(String id) {
        try {
            this.invoiceList = invoiceIOFile.readerFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < this.invoiceList.size(); i++) {
            if (id.equals(this.invoiceList.get(i).getInvoiceId())) {
                return i;
            }
        }
        return -1;
    }

    public List<Invoice> getAll() {
        try {
            return this.invoiceIOFile.readerFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
