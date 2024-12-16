package org.example.functionalProgramming;

import java.util.Scanner;

public class FactRec {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите факториал: ");
        int n = scanner.nextInt();

        int f = fact(n);

        System.out.println(n + "! = " + f);
    }

    private static int fact(int n) {
        if (n == 0) return 1;
        return n * fact(n - 1);
    }
}