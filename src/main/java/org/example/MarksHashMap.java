package org.example;

import java.util.Objects;
import java.util.Scanner;
import java.util.HashMap;

public class MarksHashMap {
    private  static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        HashMap<String, Integer> marks = new HashMap<>();

        System.out.print("Введите фамилию ученика: ");
        String surname = scanner.next();

        int sum = 0;
        double average;
        while (!surname.equals("Выход")) {
            System.out.println("--------");
            System.out.print("Введите его оценку: ");
            int mark = scanner.nextInt();
            marks.put(surname, mark);
            sum += mark;
            System.out.print("Введите фамилию ученика: ");
            surname = scanner.next();
        }

        System.out.println("---------");

        System.out.print("Напишите фамилию любого ученика: ");
        surname = scanner.next();
        while(!marks.containsKey(surname)) {
            System.out.print("Такой фамилии нет! Введите снова: ");
            surname = scanner.next();
        }
        System.out.println("Его оценка: " + marks.get(surname));

        System.out.println("--------");

        average = (double)sum / marks.size();
        System.out.println("Средний балл учеников: " + average);
    }
}
