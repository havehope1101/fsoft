package ioFile;

import model.Comics;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ComicsIOFile implements IOFile<Comics> {
    private File file = new File("BookStore/data/comics.csv");

    @Override
    public void writerFile(List<Comics> comics) throws IOException {
        String data = "";
        for (Comics comic : comics) {
            data += comic.getDocumentId() + "," +
                    comic.getPublisherName() + "," +
                    comic.getReleaseNumber() + "," +
                    comic.getComicsName() + "," +
                    comic.getAuthorName() + "," +
                    comic.getCategory() + "," +
                    comic.getPageNumber() + "," +
                    comic.getComicsPrice() + "\n";
        }

        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(data);
        bufferedWriter.close();
    }

    @Override
    public List<Comics> readerFile() throws IOException {
        List<Comics> list = new ArrayList<>();
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            String[] data = line.split(",");
            list.add(new Comics(data[0], data[1], Integer.parseInt(data[2]), data[3], data[4], data[5], Integer.parseInt(data[6]), Double.parseDouble(data[7])));
        }
        bufferedReader.close();
        return list;
    }
}
