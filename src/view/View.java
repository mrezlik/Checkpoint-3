package view;

import DAO.BookIterator;
import model.Book;

import java.util.InputMismatchException;
import java.util.Scanner;

public class View {

    public void showBooks(BookIterator books){
        int i=0;
        while(books.hasNext()){
            System.out.format("%d. %s \n", ++i, books.next());
        }
    }

    public void showMenu(){
        System.out.println("What do you want to do? \n" +
                "(1) Add new book\n" +
                "(2) Edit book\n" +
                "(3) Delete book\n" +
                "(4) Search in books\n" +
                "(5) See all books\n" +
                "(6) See all books of given author\n" +
                "(7) Exit\n" +
                "Enter your choice: ");
    }

    public String getUserInput(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public int getIDFromUser(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }


    public void printMessage(String text){
        System.out.println(text);
    }

    public void continueCommunicate(){
        System.out.println("Press any key to coninue.");
        Scanner userInput = new Scanner(System.in);
        userInput.nextLine();
    }

    public void showSearchMenu(){
        System.out.println("In what parameter you want to search?\n" +
                "(1) ISBN \n" +
                "(2) Title\n" +
                "(3) Author\n" +
                "(4) Publication year\n" +
                "(5) Publisher name\n" +
                "(6) Back\n" +
                "What do you choose:");
    }

    public void showEditMenu(){
        System.out.println("In what parameter you want to edit?\n" +
                "(1) ISBN \n" +
                "(2) Title\n" +
                "(3) Author\n" +
                "(4) Publication year\n" +
                "(5) Publisher name\n" +
                "(6) Type\n" +
                "(7) Price\n" +
                "(8) Back\n" +
                "What do you choose:");
    }


    public String getSearchWord(){
        printMessage("What world do you search?");
        return getUserInput();
    }

    public Book chooseBook(BookIterator books){
        printMessage("Please enter a ISBN number");
        String ISBN = getUserInput();
        while(books.hasNext()) {
            Book book = books.next();
            if(book.getISBN().equals(ISBN)){
                return book;
            }
        }
        throw new InputMismatchException();
    }
}

