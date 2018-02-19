import DAO.BookDAO;
import DAO.BookDAOSQL;
import controller.BookController;

public class Main {

    public static void main(String[] args) {
        try {
           new BookController().run();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
