package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class DynamicArrays {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();
        enterElements(array);
        printDynamicArrayPretty(array);
        System.out.println(proizvedenieElements(array));
    }

    public static void printDynamicArrayPretty(ArrayList<Integer> array) {
        for (int i = 0; i < array.size(); i++) {
            System.out.println("[" + i + "] = " + array.get(i));
        }
    }
    private static ArrayList<Integer> enterElements(ArrayList<Integer> array) {
        System.out.print("Введите число: ");
        int n = scanner.nextInt();
        int i = 0;
        while (n != 0) {
            array.add(i,n);
            System.out.print("Введите число: ");
            n = scanner.nextInt();
            i++;
        } return array;
    }
    private static int proizvedenieElements(ArrayList<Integer> array) {
        int result = 1;
        for (int i = 0; i < array.size(); i++) {
            result *= array.get(i);
        }
        return result;
    }
}