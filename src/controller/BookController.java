package controller;

import DAO.BookDAO;
import DAO.BookDAOSQL;
import model.Book;
import view.View;

import java.sql.SQLException;
import java.util.InputMismatchException;

public class BookController {

    private View view = new View();
    private BookDAO bookDAO = new BookDAOSQL();

    public void run() throws SQLException{
        boolean is_running = true;
        while(is_running) {
            view.showMenu();
            String user_input = view.getUserInput();
            switch (user_input) {
                case "1":
                    addNewBook();
                    break;
                case "2":
                    editBook();
                    break;
                case "3":
                    deleteBook();
                    break;
                case "4":
                    searchInBooks();
                    break;
                case "5":
                    seeAllBooks();
                    break;
                case "6":
                    searchByAuthor();
                    break;
                case "7":
                    is_running = false;
                    break;
                default:
                    view.printMessage("Something wrong! Try again!");

            }
        }
    }

    private void addNewBook() throws SQLException{
        try {
            view.printMessage("Please enter ISBN");
            String ISBN = view.getUserInput();
            view.printMessage("Please enter author ID");
            int authorID = view.getIDFromUser();
            view.printMessage("Please enter title");
            String title = view.getUserInput();
            view.printMessage("Please enter publisher id");
            String publisher = view.getUserInput();
            view.printMessage("Please enter publication year");
            int publication_year = view.getIDFromUser();
            view.printMessage("Please enter price");
            int price = view.getIDFromUser();
            view.printMessage("Please enter type id");
            int type = view.getIDFromUser();
            Book newBook = new Book(ISBN, authorID, title, publisher, publication_year, price, type);
            bookDAO.addNewBook(newBook);

        } catch(InputMismatchException e ){
            view.printMessage("Please enter a valid type!");
            view.continueCommunicate();
        }


    }

    private void editBook() throws SQLException{
        view.showBooks(bookDAO.getAllBooks());
        String word;
        try {
            Book book = view.chooseBook(bookDAO.getAllBooks());
            view.showEditMenu();
            String edit_option = view.getUserInput();
            switch(edit_option){
                case "1":
                    word = view.getUserInput();
                    book.setISBN(word);
                    break;
                case "2":
                    word = view.getUserInput();
                    book.setTitle(word);
                    break;
                case "3":
                    int year = view.getPublicationYear();
                    book.setPublicationYear(year);
                    break;
                case "4":
                    int price = view.getPrice();
                    book.setPrice(price);
                    break;
                case "5":
                    break;
                default:
                    view.printMessage("Something wrong!");
                    break;
            }
            bookDAO.updateBook(book);
        }catch(InputMismatchException e){
            view.printMessage("Something wrong! Try again!");
        }

    }


    private void deleteBook() throws SQLException{
        view.showBooks(bookDAO.getAllBooks());
        try {
            Book book = view.chooseBook(bookDAO.getAllBooks());
            bookDAO.deleteBook(book);
        }catch(InputMismatchException e){
            view.printMessage("This book doesn't exist!");
        }
    }

    private void searchInBooks() throws SQLException{
        boolean is_searching = true;

        while(is_searching) {
            view.showSearchMenu();
            String word;
            String user_choice = view.getUserInput();
            switch(user_choice){
                case "1":
                    word = view.getSearchWord();
                    view.showBooks(bookDAO.searchByISBN(word));
                    break;
                case "2":
                    word = view.getSearchWord();
                    view.showBooks(bookDAO.searchByTitle(word));
                    break;
                case "3":
                    word = view.getSearchWord();
                    view.showBooks(bookDAO.searchByAuthor(word));
                    break;
                case "4":
                    word = view.getSearchWord();
                    view.showBooks(bookDAO.searchByPublicationYear(word));
                    break;
                case "5":
                    word = view.getSearchWord();
                    view.showBooks(bookDAO.searchByPublishersName(word));
                    break;
                case "6":
                    is_searching = false;
                    break;
                default:
                    view.printMessage("Something wrong! Try again!");
                    break;

            }
        }
    }

    private void seeAllBooks(){
        try {
            view.showBooks(bookDAO.getAllBooks());
            view.continueCommunicate();
        }catch(Exception e){
            view.printMessage("Something wrong!");
        }
    }

    private void searchByAuthor() throws SQLException{
        String word = view.getSearchWord();
        view.showBooks(bookDAO.searchByAuthor(word));
     }


}
