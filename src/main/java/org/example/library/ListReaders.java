package org.example.library;

import java.time.LocalDate;

public class ListReaders {
    private Reader reader;
    private LocalDate whenTook;
    private LocalDate whenMustReturn;
    private LocalDate whenReturn;

    public ListReaders(Reader reader, LocalDate whenMustReturn,LocalDate whenTook) {
        this.reader = reader;
        this.whenMustReturn = whenMustReturn;
        this.whenTook = whenTook;
    }

    public Reader getReader() {
        return reader;
    }
    public LocalDate getWhenTook(){
        return whenTook;
    }
    public LocalDate getWhenReturn() {
        return whenReturn;
    }
    public LocalDate getWhenMustReturn() {
        return whenMustReturn;
    }

}
