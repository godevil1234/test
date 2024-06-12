package org.example;

import java.util.Scanner;

public class FactorialFormula {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число n: ");
        int n = scanner.nextInt();
        System.out.print("Введите число m: ");
        int m = scanner.nextInt();

        int C = factorial(n) / (factorial(n - m) * factorial(m));

        System.out.println("C = "+ C);
    }

    private static int factorial(int n) {
        int result = 1;

        for (int i = 1; i <= n; i++) {
        result *= i;
        }

        return result;
    }
}