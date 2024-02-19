package ioFile;

import model.Invoice;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InvoiceIOFile implements IOFile<Invoice> {
    private File file = new File("BookStore/data/invoice.csv");

    @Override
    public void writerFile(List<Invoice> invoices) throws IOException {
        String data = "";
        for (Invoice invoice : invoices) {
            data += invoice.getInvoiceId() + "," +
                    invoice.getCustomerId() + "," +
                    invoice.getDetail() + "," +
                    invoice.getDate() + "," +
                    invoice.getTotal() + "\n";
        }

        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(data);
        bufferedWriter.close();
    }

    @Override
    public List<Invoice> readerFile() throws IOException {
        List<Invoice> list = new ArrayList<>();
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            String[] data = line.split(",");
            list.add(new Invoice(data[0], data[1], data[2], data[3], Double.parseDouble(data[4])));
        }
        return list;
    }
}
