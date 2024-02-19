package management.manager;

import check.ConsoleColors;
import ioFile.BookIOFile;
import management.iManagement.DocumentManagement;
import model.Books;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookManagement implements DocumentManagement<Books> {
    private List<Books> booksList = null;
    private BookIOFile bookIOFile = new BookIOFile();

    public BookManagement() {
        try {
            this.booksList = this.bookIOFile.readerFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(Books books) {
        try {
            this.booksList.add(books);
            this.bookIOFile.writerFile(booksList);
            System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "Thêm Thành Công !!!" + ConsoleColors.RESET);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(String id, Books books) {
        int index = findIndexById(id);
        if (index != -1) {
            try {
                this.booksList.set(index, books);
                this.bookIOFile.writerFile(booksList);
                System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "Sửa Thành Công !!!" + ConsoleColors.RESET);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(ConsoleColors.RED_BOLD + "Không Có Id Muốn Sửa !!!" + ConsoleColors.RESET);
        }
    }

    @Override
    public void delete(String id) {
        int index = findIndexById(id);
        if (index != -1) {
            try {
                this.booksList.remove(index);
                this.bookIOFile.writerFile(booksList);
                System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "Xóa Thành Công !!!" + ConsoleColors.RESET);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(ConsoleColors.RED_BOLD + "Không Có Id Muốn Xóa !!!" + ConsoleColors.RESET);
        }
    }

    @Override
    public int findIndexById(String id) {
        try {
            this.booksList = bookIOFile.readerFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < this.booksList.size(); i++) {
            if (id.equals(this.booksList.get(i).getDocumentId())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public List<Books> getAll() {
        try {
            return this.bookIOFile.readerFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Books> findByName(String name) {
        List<Books> list = new ArrayList<>();
        for (Books books : booksList) {
            if (books.getBookName().toLowerCase().contains(name.toLowerCase())) {
                list.add(books);
            }
        }
        return list;
    }
}
