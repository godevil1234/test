package org.example;

import java.util.Scanner;

public class Fibonnachi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число: ");
        int n = scanner.nextInt();

        int f = fibonnachi(n);

        System.out.println("fib(" + n + ") = " + f);
    }

    private static int fibonnachi(int n) {
        int fib = 1, fib2 = 1, sum = 1;

        // for (int i = 3; i <= n; i++) {
            // sum = fib + fib2;
            // fib2 = fib;
           // fib = sum;
           // }
     //   int i = 3;
        // while(i <= n) {
           // sum = fib + fib2;
            // fib2 = fib;
            // fib = sum;
           // i++;
        // }
        //do {
          //  sum = fib + fib2;
         //   fib2 = fib;
         //   fib = sum;
         //   i++;
      //  }while(i <= n);

        return sum;
    }
}