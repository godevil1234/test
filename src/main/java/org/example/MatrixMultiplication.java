package org.example;

import java.util.Random;
import java.util.Scanner;

public class MatrixMultiplication {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    public static void main(String[] args) {
        System.out.print("Введите кол-во строк матрицы A: ");
        int n = scanner.nextInt();
        System.out.print("Введите общую размерность: ");
        int m = scanner.nextInt();
        System.out.print("Введите кол-во столбцов B: ");
        int k = scanner.nextInt();

        int[][] A = generateStaticArray(n,m,1,9);
        int[][] B = generateStaticArray(m,k,1,9);
        int[][] result = productOfMatrix(A,B);

        printStaticArray(A);

        System.out.println("-------");

        printStaticArray(B);

        System.out.println("------");

        printStaticArray(result);
    }
    public static void printStaticArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[][] generateStaticArray(int rows, int cols, int from, int to) {
        int[][] result = new int[rows][cols];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = random.nextInt(from, to);
            }
        }

        return result;
    }
    public static int[][] productOfMatrix(int[][] A, int[][] B) {
        int[][] result = new int [A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for(int j = 0; j < B[0].length; j++) {
                for (int r = 0; r < B.length; r++) {
                    result[i][j] += A[i][r] * B[r][j];
                }
            }
        } return result;
    }
}
