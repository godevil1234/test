package org.example;

import java.util.Scanner;

public class SimplePalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите строку: ");
        String s = scanner.nextLine();

        boolean isPalindrome = true;

        int start = 0;
        int end = s.length() - 1;

        // а роза упала на лапу азора

        while (start < end) {
            while (s.charAt(start) == ' ') {
                start++;
            }
            while (s.charAt(end) == ' ') {
                end--;
            }
            if (s.charAt(start) != s.charAt(end)) {
                isPalindrome = false;
                break;
            } else {
                start++;
                end--;
            }
        }

        if (isPalindrome) {
            System.out.println("Палиндром");
        } else {
            System.out.println("Не палиндром");
        }
    }
}