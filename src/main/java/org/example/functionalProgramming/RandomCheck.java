package org.example.functionalProgramming;

import java.util.Random;
import java.util.Scanner;

public class RandomCheck {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int x = random.nextInt(0, 100);

        System.err.println(x);

        System.out.print("Угадайте число: ");
        int n = scanner.nextInt();
        int attempts = 1;

        while (n != x) {
            if (n > x) {
                System.out.println("Мое число меньше!");
            } else if (n < x) {
                System.out.println("Мое число больше!");
            }
            System.out.println("Введите число: ");
            n = scanner.nextInt();
            attempts++;
        }

        System.out.println("Вы угадали, число ваших попыток: " + attempts);


    }

}