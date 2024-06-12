package org.example;

import java.util.Random;

public class MarchTemp {
    public static void main(String[] args) {
        Random random = new Random();
        int n = 5;
        int[] array = generateRandomArray(n, -5, 5);
        printArray(array);
        marchTemp(array);
    }

    private static int[] generateRandomArray(int size, int randomStart, int randomEnd) {
        Random random = new Random();
        int[] randomArray = new int[size];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextInt(randomStart, randomEnd);
        }
        return randomArray;
    }
    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " " + "| ");
        }
    }
    private static void marchTemp(int[] array) {
        boolean flag = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println("В этом месяце были холода");
        }
        if (!flag) {
            System.out.println("Месяц был без холодов");
        }
    }
}