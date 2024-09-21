package org.example.library;

import java.util.ArrayList;

public class Book {
    public String name;
    public ArrayList<ListReaders> listReaders = new ArrayList<>();

    public Book(String name) {
        this.name = name;
    }
    public void addReader(ListReaders listReader) {
        listReaders.add(listReader);
    }

}
