package org.example.library;

import java.time.LocalDate;
import java.util.ArrayList;

public class LibraryMain {
    public static void main(String[] args) {
        Library library = new Library();

        Book onegin = new Book("Онегин");
        library.addBook(onegin);
        Book pushkin = new Book("Пушкин");
        library.addBook(pushkin);
        Book dostoevsky = new Book("Достоевский");
        library.addBook(dostoevsky);

        library.printBooks();
        Reader nikita = new Reader("Nikita");
        LocalDate mustReturnDate = LocalDate.of(2024,9,22);
        library.takeBook("Онегин",nikita,mustReturnDate);
    }
}
