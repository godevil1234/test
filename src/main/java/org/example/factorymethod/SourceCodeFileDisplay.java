package org.example.factorymethod;

public class SourceCodeFileDisplay implements FileDisplay {
    @Override
    public void open(String filename) {
        System.out.println("Читаем файл с исходным кодом");
    }

    @Override
    public void save(String filename) {
        System.out.println("Пишем файл с исходным кодом");
    }

    @Override
    public void display() {
        System.out.println("Показываем исходный код");
    }
}
