package org.example;

import java.util.Random;
import java.util.Scanner;

public class Tournament {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    public static void main(String[] args) {
        System.out.print("Введите количество команд: ");
        int teams = scanner.nextInt();
        System.out.print("Введите количество соревнований: ");
        int competitions = scanner.nextInt();
        int[][] array = generateStaticArray(teams, competitions,1,9);
        printStaticArray(array);
        int sumMax = 0, winner = 0;
        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for(int j = 0; j < array[i].length; j++) {
                sum += array[i][j];
            }
            if (sum > sumMax) {
                sumMax = sum;
                winner = i + 1;
            }
        }
        System.out.println("Победителем стала команда № " + winner + " Набрав " + sumMax + " Очков");
        
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


    public static void printStaticArray(int[][] array) {
        int x = 1;
        for (int i = 0; i < array.length; i++) {
            System.out.println("Команда № " + x++ + " ");
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

}
