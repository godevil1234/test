package org.example;

import java.util.Scanner;

public class TriangleStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер фигуры: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i <= j && -i <= j - (n - 1) || i >= j && -i >= j - (n - 1)) {
                    System.out.print("*");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
}
// задача 9
