package fa.training.entities;

import java.util.Date;

public class Magazine extends Publication{
    String author;
    int volume;
    int edition;

    public Magazine() {
    }

    public void display(){
        System.out.println("Author:"+this.author+", Volume:"+this.volume+", Edition:"+this.edition+", Publication Year:"
                +this.getPublicationYear()+", Publisher:"+this.getPublisher()+", Publication Date:" +this.getPublicationDate());

    }

    public Magazine(int publicationYear, String publisher, Date publicationDate, String author, int volume, int edition) {
        super(publicationYear, publisher, publicationDate);
        this.author = author;
        this.volume = volume;
        this.edition = edition;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }
}
