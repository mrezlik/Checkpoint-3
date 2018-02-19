package DAO;

import model.Book;

import java.sql.SQLException;

public interface BookDAO {

    BookIterator getAllBooks() throws SQLException;
    void addNewBook(Book book) throws SQLException;
    void deleteBook(Book book) throws SQLException;
    BookIterator searchByISBN(String ISBN) throws SQLException;
    BookIterator searchByTitle(String title) throws SQLException;
    BookIterator searchByAuthor(String author) throws SQLException;
    BookIterator searchByPublicationYear(String publication_year) throws SQLException;
    BookIterator searchByPublishersName(String publisher_name) throws SQLException;
    void updateBook(Book book) throws SQLException;

}
