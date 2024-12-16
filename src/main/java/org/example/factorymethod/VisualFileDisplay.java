package org.example.factorymethod;

public class VisualFileDisplay implements FileDisplay {
    @Override
    public void open(String filename) {
        System.out.println("Читаем визуальный файл");
    }

    @Override
    public void save(String filename) {
        System.out.println("Пишем визуальный файл");
    }

    @Override
    public void display() {
        System.out.println("Показываем визуально файл");
    }
}
