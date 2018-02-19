package controller;

import DAO.BookDAO;
import DAO.BookDAOSQL;
import view.View;

import java.sql.SQLException;

public class BookController {

    View view = new View();
    BookDAO bookDAO = new BookDAOSQL();

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

    public void addNewBook(){
        view.printMessage("In progress");
    }

    public void editBook(){
        view.printMessage("In progress");
    }
    public void deleteBook(){
        view.printMessage("In progress");
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

    public void seeAllBooks(){
        try {
            view.showBooks(bookDAO.getAllBooks());
            view.continueCommunicate();
        }catch(Exception e){
            view.printMessage("Something wrong!");
        }
    }

    public void searchByAuthor() throws SQLException{
        String word = view.getSearchWord();
        view.showBooks(bookDAO.searchByAuthor(word));
     }


}
