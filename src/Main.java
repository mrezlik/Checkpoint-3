import DAO.BookDAO;
import DAO.BookDAOSQL;
import controller.BookController;
import model.Book;
import view.View;

public class Main {

    public static void main(String[] args) {
        BookDAO bookDAO = new BookDAOSQL();
        try {
           new BookController().run();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
