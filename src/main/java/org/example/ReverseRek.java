package org.example;

import java.util.Scanner;

public class ReverseRek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число: ");
        int n = scanner.nextInt();

        reverse(n);
    }

    public static void reverse(int n) {
        if (n >= 0 && n < 10) {
            System.out.print(n);
            return;
        }
        System.out.print(n % 10);

        reverse(n / 10);

    }
}