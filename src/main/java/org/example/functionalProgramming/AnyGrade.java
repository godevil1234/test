package org.example.functionalProgramming;

import java.security.spec.RSAOtherPrimeInfo;

public class AnyGrade {
    public static void main(String[] args) {

        int[] array = {5, 5, 5, 2, 5};
        printArray(array);
        anyGrade(array);
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void anyGrade(int[] array) {
        boolean flag = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 5) {
                flag = true;
            }
            else if (array[i] < 3){
                flag = false;
                System.out.println("Двоечник");
                break;
            }
            else if (array[i] < 5 && array[i] >= 3) {
                flag = false;
                System.out.println("Ученик обычный");
                break;
            }
        }
        if (flag) {
            System.out.println("Отличник");
        }

    }
}
