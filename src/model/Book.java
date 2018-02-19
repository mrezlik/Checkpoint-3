package model;

public class Book {

    private int ISBN;
    private String author;
    private String title;
    private String publisher;
    private int publication_year;
    private int price;
    private String type;

    public Book(int ISBN, String author, String title, String publisher, int publication_year, int price, String type){
        this.ISBN = ISBN;
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.publication_year = publication_year;
        this.price = price;
        this.type = type;
    }
}
