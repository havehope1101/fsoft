package fa.training.services.manager;

import fa.training.entities.Book;
import fa.training.services.iServices.PublicationManagement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookManagement implements PublicationManagement<Book> {
    private List<Book> bookList = new ArrayList<>();


    @Override
    public void add(Book book) {
        this.bookList.add(book);
    }

    @Override
    public int findIndexById(String id) {
        for (int i = 0; i < this.bookList.size(); i++) {
            if (id.equals(this.bookList.get(i).getIsbn())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public List getAll() {
        return bookList;
    }

    @Override
    public List<Book> findByName(String name) {
        List<Book> list = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getIsbn().toLowerCase().contains(name.toLowerCase())) {
                list.add(book);
            }
        }
        return list;
    }

    public Set<String> inputAuthor(String author){
        Set<String> auth = new HashSet<>();
        auth.add(author);
        return auth;
    }

    public List<Book> findByAuthor(String author) {
        List<Book> list = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getAuthor().contains(author)) {
                list.add(book);
            }
        }
        return list;
    }

    public List<Book> findByPublisher(String publisher) {
        List<Book> list = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getPublisher().toLowerCase().contains(publisher.toLowerCase())) {
                list.add(book);
            }
        }
        return list;
    }

    public void displayData(List<Book> bookList, String publisher, int publicationYear){
        List<Book> searchBookList = new ArrayList<>();
        for (Book book : bookList) {
            if(publisher.equals(book.getPublisher()) && publicationYear == book.getPublicationYear()){
                searchBookList.add(book);
            }
        }
        for (Book book : searchBookList) {
            book.display();
        }
    }
}
