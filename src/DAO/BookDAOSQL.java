package DAO;

import model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDAOSQL implements BookDAO {

    private DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
    private Connection connection = null;

    public BookDAOSQL(){
        connection = databaseConnection.getConnection();
    }

    public BookIterator getAllBooks() throws SQLException{

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT ISBN, author, title, publisher," +
                " publication_year, price, type FROM Books " +
                "ORDER BY title;");
        ResultSet queryResult = preparedStatement.executeQuery();

        return getIterator(queryResult);
    }

    public void addNewBook(Book book) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Books(ISBN, author, title, publisher, publication_year, price, type)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?)");
        preparedStatement.setString(1, book.getISBN());
        preparedStatement.setInt(2, book.getAuthor());
        preparedStatement.setString(3, book.getTitle());
        preparedStatement.setString(4, book.getPublisher());
        preparedStatement.setInt(5, book.getPublication_year());
        preparedStatement.setInt(6, book.getPrice());
        preparedStatement.setInt(7, book.getType());

        preparedStatement.executeUpdate();
    }

    public void deleteBook(Book book) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Books WHERE ISBN = ?");
        preparedStatement.setString(1, book.getISBN());
        preparedStatement.executeUpdate();
    }

    public BookIterator searchByISBN(String ISBN) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT ISBN, author, title, publisher," +
                " publication_year, price, type FROM Books " +
                "WHERE ISBN = ?;");
        preparedStatement.setString(1, ISBN);
        ResultSet queryResult = preparedStatement.executeQuery();
        return getIterator(queryResult);
    }

    public BookIterator searchByTitle(String title) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT ISBN, author, title, publisher," +
                " publication_year, price, type FROM Books " +
                "WHERE Title = ?;");
        preparedStatement.setString(1, title);
        ResultSet queryResult = preparedStatement.executeQuery();
        return getIterator(queryResult);
    }

    public BookIterator searchByAuthor(String author) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT ISBN, author, title, publisher," +
                " publication_year, price, type FROM Books JOIN Authors ON Authors.author_id = author " +
                "WHERE Authors.name = ? OR Authors.surname = ?;");
        preparedStatement.setString(1, author);
        ResultSet queryResult = preparedStatement.executeQuery();
        return getIterator(queryResult);
    }

    public BookIterator searchByPublicationYear(int publication_year) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT ISBN, author, title, publisher," +
                " publication_year, price, type FROM Books " +
                "WHERE publication_year = ?;");
        preparedStatement.setInt(1, publication_year);
        ResultSet queryResult = preparedStatement.executeQuery();
        return getIterator(queryResult);
    }

    public BookIterator searchByPublishersName(String publisher_name) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT ISBN, author, title, publisher," +
                " publication_year, price, type FROM Books JOIN Publishers ON Publishers.publisher_id = publisher " +
                "WHERE Publishers.name = ?");
        preparedStatement.setString(1, publisher_name);
        ResultSet queryResult = preparedStatement.executeQuery();
        return getIterator(queryResult);
    }

    private BookIterator getIterator(ResultSet queryResult) throws SQLException{
        ArrayList<Book> books = new ArrayList<>();

        while (queryResult.next()) {
            String ISBN = queryResult.getString("ISBN");
            int author = queryResult.getInt("author");
            String title = queryResult.getString("title");
            String publisher = queryResult.getString("publisher");
            int publication_year = queryResult.getInt("publication_year");
            int price = queryResult.getInt("price");
            int type = queryResult.getInt("type");

            Book newBook = new Book(ISBN, author, title, publisher, publication_year, price, type);
            books.add(newBook);
        }

        return new BookIterator(books);
    }

}
