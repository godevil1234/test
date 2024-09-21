package org.example.library;

import java.time.LocalDate;
import java.util.ArrayList;

public class Library {
    public ArrayList<Book> books = new ArrayList<>();

    public void takeBook(String nameBook, Reader reader, LocalDate mustReturnDate) {
        for(int i = 0; i < books.size(); i++) {
            if(nameBook.equals(books.get(i).name)) {
                reader.addBook(books.get(i));
                books.remove(i);
            }
        }
    }

    public void addBook(Book book){
        books.add(book);
    }
    public void printBooks() {
        for(Book book : books) {
            System.out.println(book.name);
        }
    }
}
