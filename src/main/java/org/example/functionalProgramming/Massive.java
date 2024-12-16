package org.example.functionalProgramming;

import java.util.Random;
import java.util.Scanner;

public class Massive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Введите количество элементов массива: ");
        int n = scanner.nextInt();
        int[] array = enterArray(n);

        printArray(array);

        System.out.println("Сумма: " + sumArray(array));

        System.out.print("Введите размер массива: ");
        int x = scanner.nextInt();
        System.out.print("Введите начало диапазона: ");
        int randStart = scanner.nextInt();
        System.out.print("Введите конец диапазона: ");
        int randEnd = scanner.nextInt();
        int[] randomArray = generateRandomArray(x,randStart,randEnd);
        printArray(randomArray);

        }
    private static int[] enterArray(int size) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            System.out.print("Введите любое число: ");
            array[i] = scanner.nextInt();
        }
        return array;
    }
    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("[" + i +"] = " + arr[i]);
        }
    }
    private static int sumArray(int[] array1) {
        int sum = 0;
        for (int i = 0; i < array1.length; i++) {
            sum += array1[i];
        }
        return sum;
    }
    private static int[] generateRandomArray(int size, int randomStart, int randomEnd) {
        Random random = new Random();
        int[] randomArray = new int[size];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextInt(randomStart,randomEnd);
        }
        return randomArray;
    }
}
