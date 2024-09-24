package org.example.library;

import java.time.LocalDate;
import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void takeBook(String nameBook, Reader reader, LocalDate mustReturnDate) {
        for(int i = 0; i < books.size(); i++) {
            if(nameBook.equals(books.get(i).getName())) {
                ListReaders listReaderTake = new ListReaders(reader, mustReturnDate,LocalDate.now());
                books.get(i).getListReaders().add(listReaderTake);
                reader.addBook(books.get(i));
                books.remove(i);
                break;
            }
        }
    }
    public void returnBook(String nameBook, Reader reader) {
        for (int i = 0; i < books.size(); i++) {
            Book book = reader.listBooks.get(i);
            if(book.getName().equals(nameBook)) {
                books.add(book);
                reader.listBooks.remove(i);
                break;
            }
        }
    }

    public void addBook(Book book){
        books.add(book);
    }
    public void printBooks() {
        for(Book book : books) {
            System.out.println(book.getName());
        }
    }
}
