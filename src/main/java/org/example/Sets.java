package org.example;

import java.util.Random;
import java.util.Scanner;
import java.util.HashSet;

public class Sets {
    private static final Scanner scanner = new Scanner(System.in);
    public static final Random random = new Random();

    public static void main(String[] args) {
        HashSet<Integer> A;
        HashSet<Integer> B;
        System.out.print("Введите положительное число n: ");
        int n = scanner.nextInt();
        System.out.print("Введите положительное число m: ");
        int m = scanner.nextInt();
        System.out.println("Множество А ");
        A = generateRandomSet(n);
        setPrint(A);
        System.out.println("Дубликатов A: " + (n - A.size()));
        System.out.println("Множество B ");
        B = generateRandomSet(m);
        setPrint(B);
        System.out.println("--------");
        HashSet<Integer> result = new HashSet<>(A);
        HashSet<Integer> res = new HashSet<>(B);
        result.retainAll(B);
        System.out.print(result.size()  + " Одинаковых элементов: " + result);
        System.out.println();
        res.removeAll(A);
        System.out.print("Во множестве A, нет этих элементов из B: ");
        setPrint(res);
    }
    public static HashSet<Integer> generateRandomSet(int size) {
        HashSet<Integer> result = new HashSet<>();

        for (int i = 0; i < size; i++) {
            result.add(random.nextInt(1,9));
        }

        return result;
    }
    public static void setPrint(HashSet<Integer> set) {
        for (int x : set) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
