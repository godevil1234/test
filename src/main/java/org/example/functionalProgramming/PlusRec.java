package org.example.functionalProgramming;

import java.util.Scanner;


public class PlusRec {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число: ");
        int n = scanner.nextInt();

        reverse(n);
    }

    private static void reverse(int n) {
        if (n >= 0 && n < 10) {
            System.out.print(shiftDigit(n));
            return;
        }

        reverse(n / 10);

        System.out.print(shiftDigit(n % 10));
    }

    private static int shiftDigit(int digit) {
        return (digit + 1) % 10;
    }
}