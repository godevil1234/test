package org.example.functionalProgramming;

import java.util.ArrayList;
import java.util.Random;

public class DynamicSorting {
    private static final Random random = new Random();

    public static void main(String[] args) {
        ArrayList<Integer> array = generateRandomDynamicArray(10, 1, 10);
        printDynamicArrayPretty(array);
        System.out.println("-----");
        sortingOfSimpleInsert(array);
        printDynamicArrayPretty(array);
    }

    public static void printDynamicArrayPretty(ArrayList<Integer> array) {
        for (int i = 0; i < array.size(); i++) {
            System.out.println("[" + i + "] = " + array.get(i));
        }
    }

    public static ArrayList<Integer> generateRandomDynamicArray(int size, int from, int to) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            result.add(random.nextInt(from, to + 1));
        }

        return result;
    }
    private static ArrayList<Integer> BubbleSort(ArrayList<Integer> array) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < array.size(); i++) {
                if (array.get(i) < array.get(i - 1)) {
                    int temporary = array.get(i - 1);
                    array.set(i - 1, array.get(i));  // array[i + 1] = array[i];
                    array.set(i, temporary);
                    isSorted = false;
                }
            }
        }
        return array;
    }
    private static ArrayList<Integer> simpleChoiseSorting(ArrayList<Integer> array) {
        for (int i = 0; i < array.size() - 1; i++) {
            int min = i;
            int start = i;
            for (int j = i; j < array.size(); j++) {
                if (array.get(j) < array.get(min)) {
                    min = j;
                }
            }
            int a = array.get(start);
            array.set(start, array.get(min));
            array.set(min, a);
        } return array;
    }
    private static ArrayList<Integer> sortingOfSimpleInsert(ArrayList<Integer> array) {
        for (int i = 1; i < array.size(); i++) {
            int start = i;
            boolean startNotCorrect = false;
            while(!startNotCorrect && start > 0) {
                startNotCorrect = true;
                if (array.get(start) < array.get(start - 1)) {
                    int a = array.get(start - 1);
                    array.set(start - 1, array.get(start));
                    array.set(start, a);
                    startNotCorrect = false;
                    start--;
                }
            }
        }
        return array;
    }
}