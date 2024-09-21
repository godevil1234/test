package org.example.library;

import java.util.ArrayList;

public class Reader {
    private String name;

    public ArrayList<Book> listBooks = new ArrayList<>();

    public Reader(String name) {
        this.name = name;
    }

    public void addBook(Book book) {
        listBooks.add(book);
    }

}
