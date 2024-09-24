package org.example.library;

import java.util.ArrayList;

public class Book {
    private String name;
    private ArrayList<ListReaders> listReaders = new ArrayList<>();
    public Book(String name) {
        this.name = name;
    }
    public void printReaders(ListReaders listReaders){
        System.out.println("Имя читателя: " + listReaders.getReader().getName() + " " + "Взял книгу: " + name);
        System.out.println("Когда взял: " + listReaders.getWhenTook());
        System.out.println("Когда должен вернуть: " + listReaders.getWhenMustReturn());
        System.out.println("Когда вернул: " + listReaders.getWhenReturn());
    }
    public ArrayList<ListReaders >getListReaders(){
        return listReaders;
    }
    public String getName() {
        return name;
    }

}
