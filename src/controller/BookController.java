package controller;

import DAO.BookDAO;
import DAO.BookDAOSQL;
import view.View;

public class BookController {

    View view = new View();
    BookDAO bookDAO = new BookDAOSQL();

    public void run(){
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

    public void searchInBooks(){
        view.printMessage("In progress");
    }

    public void seeAllBooks(){
        try {
            view.showBooks(bookDAO.getAllBooks());
            view.continueCommunicate();
        }catch(Exception e){
            view.printMessage("Something wrong!");
        }
    }

    public void searchByAuthor(){
        view.printMessage("In progress");
    }


}
