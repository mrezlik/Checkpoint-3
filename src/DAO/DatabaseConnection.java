package DAO;

import java.sql.*;


public class DatabaseConnection {

    private static DatabaseConnection instance = null;
    private Connection connection = null;

    private DatabaseConnection(){
            getConnectionToDatabase();
        }

        public static DatabaseConnection getInstance() {
            if (instance == null) {
                instance = new DatabaseConnection();
            }
            return instance;
        }

        private void getConnectionToDatabase(){
            try{
                Class.forName("org.sqlite.JDBC");
                String DBNAME = "jdbc:sqlite:library.db";
                this.connection = DriverManager.getConnection(DBNAME);
            } catch (SQLException | NullPointerException e ){
                System.out.println("Database connection problem.");
            } catch (ClassNotFoundException e) {
                System.out.println("Class not found.");
            }
        }



        public Connection getConnection(){
            return connection;
        }

    }
