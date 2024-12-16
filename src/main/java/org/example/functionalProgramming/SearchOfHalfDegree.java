package org.example;

import java.util.Scanner;

public class SearchOfHalfDegree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите искомое число: ");
        int n = scanner.nextInt();

        int[] array = {1,2,4,5,6,7,9,10,11};
        printArray(array);
        printSearch(array, n);
    }
    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    private static void printSearch(int[] array, int n) {
        int start = 0;
        int end = array.length - 1;
        int index = 0;
        boolean flag = false;
        while(start <= end) {
            int center = (start + end + 1) / 2;
            if (array[center] == n) {
                index = center;
                flag = true;
                break;
            } else if (array[center] < n) {
                start = center + 1;
            } else if (array[center] > n) {
                end = center - 1;
            }
        }
        if (flag) {
            System.out.println("Индекс искомого числа: " + index);
        } else {
            System.out.println("Элемент не найден");
        }
    }

}
