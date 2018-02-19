package DAO;

import model.Book;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookIterator implements Iterator {

        private List<Book> list;
        private int index;

        BookIterator(ArrayList<Book> list){
            this.list = list;
        }

        public boolean hasNext(){

            return index < list.size();

        }

        public Book next(){
            if(this.hasNext()){
                return list.get(index++);
            }
            return null;
        }

    }
}
