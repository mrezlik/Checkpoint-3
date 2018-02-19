package DAO;

import model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class BookDAO {

    private DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
    private Connection connection = null;

    public BookDAO(){
        connection = databaseConnection.getConnection();
    }

    public Iterator getAllBooks() throws SQLException{
        ArrayList<Book> books = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT ISBN, Authors.name as 'author_name', title, Publishers.name as 'publisher_name'," +
                " publication_year, price, TypeBooks.type as 'type' FROM Books JOIN Authors ON Books.author = Authors.author_id" +
                " JOIN Publishers ON Books.publisher = Publishers.publisher_id " +
                "JOIN TypeBooks ON Books.type = TypeBooks.type_id ORDER BY title;");
        ResultSet queryResult = preparedStatement.executeQuery();
        while (queryResult.next()) {
            int ISBN = queryResult.getInt("ISBN");
            String author = queryResult.getString("author_name");
            String title = queryResult.getString("title");
            String publisher = queryResult.getString("publisher_name");
            int publication_year = queryResult.getInt("publication_year");
            int price = queryResult.getInt("price");
            String type = queryResult.getString("type");

            Book newBook = new Book(ISBN, author, title, publisher, publication_year, price, type);
            books.add(newBook);
        }
        return new BookIterator(books);
    }




}
