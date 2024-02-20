package fa.training.services.manager;

import fa.training.entities.Book;
import fa.training.services.iServices.PublicationManagement;

import java.util.List;

public class BookManagement implements PublicationManagement<Book> {
    private List<Book> bookList = null;


    @Override
    public void add(Book book) {
        this.bookList.add(book);
    }

    @Override
    public int findIndexById(String id) {
        return 0;
    }

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public List findByName(String name) {
        return null;
    }
}
