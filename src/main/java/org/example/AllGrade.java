package org.example;

public class AllGrade {
    public static void main(String[] args) {

        int[] array = {5, 5, 3, 5, 5};
        printArray(array);
        anyGrade(array);
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void anyGrade(int[] array) {
        boolean flag = true;
        boolean casual = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 5) {
                flag = true;
            }
            if (array[i] < 3){
                casual = false;
                flag = false;
                break;
            }
            if (array[i] < 5 && array[i] >= 3) {
                casual = true;
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("Отличник");
        }
        if (!casual && !flag) {
            System.out.println("Двоечник");
        }
        if (casual) {
            System.out.println("Ученик обычный");
        }
    }
}