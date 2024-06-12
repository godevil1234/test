package org.example;

import java.util.Random;
import java.util.Scanner;

public class MassiveRand {
    public static void main(String[] args) {
        Random random = new Random();
        int size = random.nextInt();
        int randomStart = random.nextInt();
        int randomEnd = random.nextInt();

        generateRandomArray(size,randomStart,randomEnd);
    }
    private static int generateRandomArray(int size, int randomStart, int randomEnd) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите начало диапазона массива: ");
        randomStart = scanner.nextInt();
        System.out.println("Введите конец диапазона массива");
        randomEnd = scanner.nextInt();
        size = random.nextInt(randomStart, randomEnd);
        int[] array = new int[size];

         for(int i = 0; i < array.length; i++) {
            size = random.nextInt(randomStart, randomEnd);
            array[i] = i;
            System.out.println("[" + array[i] +  "]" + " = " + size);
        }
         return size;
    }
}
