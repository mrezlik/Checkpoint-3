package model;

public class Book {

    private String ISBN;
    private String author;
    private String title;
    private String publisher;
    private int publication_year;
    private int price;
    private String type;

    public Book(String ISBN, String author, String title, String publisher, int publication_year, int price, String type){
        this.ISBN = ISBN;
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.publication_year = publication_year;
        this.price = price;
        this.type = type;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublication_year(int publication_year) {
        this.publication_year = publication_year;
    }

    public int getPublication_year() {
        return publication_year;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
