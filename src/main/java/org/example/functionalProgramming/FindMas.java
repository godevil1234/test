package org.example.functionalProgramming;

import java.util.Random;
import java.util.Scanner;

public class FindMas {
    private static final int ELEMENT_NOT_FOUND = -1;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.print("Введите количество элементов: ");
        int n = scanner.nextInt();

        int[] array = generateRandomArray(n, 1, 20);

        printArray(array);

        System.out.print("Какой элемент найти: ");
        int x = scanner.nextInt();

        int index = findInArray(array, x);

        if (index == ELEMENT_NOT_FOUND) {
            System.out.println("Элемент не найден");
        } else {
            System.out.println("Индекс элемента: " + index);
        }
        int max = findMax(array);
        int maxIndex = findMaxIndex(array);
        int min = findMin(array);
        int minIndex = findMinIndex(array);
        System.out.println("Максимальный элемент: " + max + " Индекс максимального элемента: " + maxIndex);
        System.out.println("Минимальный элемент: " + min + " Индекс минимального элемента: " + minIndex);
    }
    private static int findInArray(int[] haystack, int needle) {
        for (int i = 0; i < haystack.length; i++) {
            if (haystack[i] == needle) {
                return i;
            }
        }

        return ELEMENT_NOT_FOUND;
    }
    private static int[] generateRandomArray(int size,int randomStart,int randomEnd) {
        Random random = new Random();
        int[] randomArray = new int[size];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextInt(randomStart, randomEnd);
        }
        return randomArray;
    }
    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("[" + i +"] = " + arr[i]);
        }
    }
    private static int findMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    private static int findMaxIndex(int[] array) {
        int indexMax = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] >= array[indexMax]) {
                indexMax = i;
            }
        }
        return indexMax;
    }
    private static int findMin(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
    private static int findMinIndex(int[] array) {
        int min = array[0];
        int indexMin = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                indexMin = i;
            }
        }
        return indexMin;
    }
}
