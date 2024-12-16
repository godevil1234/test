package org.example;

public class Sorting {

    public static void main(String[] args) {
        int[] array = {2,5,3,4,6,1};
        printArray(array);
        System.out.println("Отсортированный массив: ");
        sortingOfSimpleInsert(array);
        printArray(array);
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    private static int[] bubbleSorting(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                  int a = array[j + 1];
                  array[j + 1] = array[j];
                  array[j] = a;
                }
            }
        } return array;
    }
    private static int[] bubbleSortingWhile(int[] array) {
        boolean flag = false;
            while(!flag) {
                flag = true;
                for (int i = 0; i < array.length - 1; i++) {
                    if (array[i] > array[i + 1]) {
                        int a = array[i + 1];
                        array[i + 1] = array[i];
                        array[i] = a;
                        flag = false;
                    }
                }

        } return array;
    }
    private static int[] simpleChoiseSorting(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            int start = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[min]) {
                   min = j;
                }
                int a = array[start];
                array[start] = array[min];
                array[min] = a;
            }
        } return array;
    }
    private static int[] sortingOfSimpleInsert(int[]array) {
        for (int i = 1; i < array.length; i++) {
            int start = i;
            boolean startNotCorrect = false;
            while(!startNotCorrect && start > 0) {
                startNotCorrect = true;
                if (array[start] < array[start - 1]) {
                    int a = array[start - 1];
                    array[start - 1] = array[start];
                    array[start] = a;
                    startNotCorrect = false;
                    start--;
                }
            }
        }
        return array;
    }
}

