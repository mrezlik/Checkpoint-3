package DAO;

import java.sql.Connection;

public class BookDAO {

    private DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
    private Connection connection = null;

    public BookDAO(){
        connection = databaseConnection.getConnection();
    }




}
