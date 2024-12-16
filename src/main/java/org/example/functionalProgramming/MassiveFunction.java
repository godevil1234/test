package org.example.functionalProgramming;

import java.util.Scanner;

public class MassiveFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество элементов массива: ");
        int n = scanner.nextInt();

        sumMas(n);

    }
    private static void sumMas(int n) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[n];
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
            System.out.print("Введите любое число: ");
            n = scanner.nextInt();
            sum += n;
            System.out.println("[" + array[i] + "]" + " = " + n);
        }
        System.out.println("Сумма всех элементов: " + sum);
    }
}