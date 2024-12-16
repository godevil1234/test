package org.example.functionalProgramming;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число: ");
        int n = scanner.nextInt();

        int f = factorial(n);

        System.out.println(n + "! = " + f);
    }

    private static int factorial(int n) {
        int result = 1;

        for (int i = 1; i <= n; i++) {
            result *= i;
       }

        //int i = 1;

        //while(i <= n) {
          //i++;
          //result *= i - 1;
        // }

        //do {
            //i++;
           //result *= i - 1;
        // } while(i <= n);

        return result;
    }
}