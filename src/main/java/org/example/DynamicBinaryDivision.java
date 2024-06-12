package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class DynamicBinaryDivision {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    public static void main(String[] args) {
        ArrayList<Integer> array = generateRandomDynamicArray(10, 1, 10);
        printDynamicArrayPretty(array);

        System.out.print("Введите число: ");
        int n = scanner.nextInt();

        System.out.println("------");

        Collections.sort(array);
        printDynamicArrayPretty(array);
        int x = printSearch(array, n);
        if (x == -1) {
            System.out.println("Элемент не найден");
        } else {
            System.out.println(x);
        }
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
    private static int printSearch(ArrayList<Integer> array, int n) {
        int start = 0;
        int end = array.size() - 1;
        int index = -1;
        while(start <= end) {
            int center = (start + end + 1) / 2;
            if (array.get(center) == n) {
                index = center;
                break;
            } else if (array.get(center) < n) {
                start = center + 1;
            } else if (array.get(center) > n) {
                end = center - 1;
            }
        }
        return index;
    }
}
