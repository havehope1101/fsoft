package fa.training.entities;

import java.util.Date;
import java.util.Set;

public class Book extends Publication{
    String isbn;
    Set<String> author;
    String publicationPrice;

    public Book() {
        super();
    }

    public void display() {
      }

    public Book(int publicationYear, String publisher, Date publicationDate, String isbn, Set<String> author, String publicationPrice) {
        super(publicationYear, publisher, publicationDate);
        this.isbn = isbn;
        this.author = author;
        this.publicationPrice = publicationPrice;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<String> getAuthor() {
        return author;
    }

    public void setAuthor(Set<String> author) {
        this.author = author;
    }

    public String getPublicationPrice() {
        return publicationPrice;
    }

    public void setPublicationPrice(String publicationPrice) {
        this.publicationPrice = publicationPrice;
    }
}
