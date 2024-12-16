package org.example.functionalProgramming;

import java.util.Scanner;

public class Check {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n, sum2 = 0;

        System.out.print("Введите положительное число: ");
        n = scanner.nextInt();


        while (n <= 0) {
            System.out.print("Вы ввели некорректное значение! Введите положительное число: ");
            n = scanner.nextInt();

        }
        while (sum2 <= n) {
            System.out.print("Введите число: ");
            int sum = scanner.nextInt();
            sum2 += sum;
        }

        System.out.println(sum2);
    }
}
//задача 2