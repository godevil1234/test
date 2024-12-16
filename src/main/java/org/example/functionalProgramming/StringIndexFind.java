package org.example;


import java.util.Scanner;

public class StringIndexFind {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.print("Введите строку: ");
        String s = scanner.next();
        System.out.print("Введите символ из этой строки: ");
        char ch = scanner.next().charAt(0);
        int index = -1;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ch) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Элемента нет");
        } else {
            System.out.println("Индекс искомого символа: " + index);
        }

    }

}
