package view;

import DAO.BookIterator;

import java.util.Scanner;

public class View {

    public void showBooks(BookIterator books){
        while(books.hasNext()){
            System.out.println(books.next());
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

    public void printMessage(String text){
        System.out.println(text);
    }

    public void continueCommunicate(){
        System.out.println("Press any key to coninue.");
        Scanner userInput = new Scanner(System.in);
        userInput.nextLine();
    }
}
