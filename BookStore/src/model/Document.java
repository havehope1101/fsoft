package model;

public class Document {
    private String documentId;
    private String publisherName;
    private int releaseNumber;

    public Document() {
    }

    public Document(String documentId, String publisherName, int releaseNumber) {
        this.documentId = documentId;
        this.publisherName = publisherName;
        this.releaseNumber = releaseNumber;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public int getReleaseNumber() {
        return releaseNumber;
    }

    public void setReleaseNumber(int releaseNumber) {
        this.releaseNumber = releaseNumber;
    }
}
