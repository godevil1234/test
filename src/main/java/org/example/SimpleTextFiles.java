package org.example;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class SimpleTextFiles {
    private static final Scanner scanner = new Scanner(System.in);
     public static void main(String[] args) throws Exception {
        File file = new File("test.txt");
        System.out.print("Введите число: ");
        int n = scanner.nextInt();
        try (PrintWriter out = new PrintWriter(file)) {
            for(int i = 1; i <= n; i++) {
                out.print(i + " ");
            }
        }
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextInt()) {
                int x = scanner.nextInt();
                System.out.print(x * 2 + " ");
            }
        }
    }
}
