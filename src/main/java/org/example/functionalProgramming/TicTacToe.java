package org.example;

import java.util.Scanner;

public class TicTacToe {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int deadHeat = 1;
        char[][] field = new char[][] {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
        char turn = 'X';
        boolean winner = false;
        while (!winner) {
            System.out.println("Ходит пользователь " + turn);

            System.out.print("Введите столбец: ");
            int col = scanner.nextInt();
            System.out.print("Введите строку: ");
            int row = scanner.nextInt();
            while (isOutOfField(row,col) || field[row][col] != ' ') {
                if (isOutOfField(row,col)) {
                    System.out.println("Вы ввели координаты, выходящие за предела поля! Введите еще раз.");
                } else {
                    System.out.println("Клетка уже занята! Введите еще раз.");
                }
                System.out.print("Введите столбец: ");
                col = scanner.nextInt();
                System.out.print("Введите строку: ");
                row = scanner.nextInt();
            }
            field[row][col] = turn;
            printField(field);


            for (int i = 0; i < 3; i++) {
                if (field[i][0] == field[i][1] && field[i][1] == field[i][2] && field[i][2] != ' ' || field[0][i] == field[1][i] && field[1][i] == field[2][i] && field[2][i] != ' ') {
                    System.out.println("Победил пользователь " + turn);
                    winner = true;
                    break;
                }
            }
            if (field[0][2] == field[1][1] && field[1][1] == field[2][0] && field[2][0] != ' ' || field[0][0] == field[1][1] && field[1][1] == field[2][2] && field[2][2] != ' ') {
                System.out.println("Победил пользователь " + turn);
                break;
            }
            deadHeat++;
            if (deadHeat == 10) {
                System.out.println("Ничья!");
                break;
            }
            if (turn == 'X') {
                turn = 'O';
            } else {
                turn = 'X';
            }
        }
    }
    public static void printField(char[][] indexField) {

        System.out.println("+-+-+-+");
        System.out.println("|" + indexField[0][0] + "|" +  indexField[0][1] + "|" + indexField[0][2] + "|");
        System.out.println("+-+-+-+");
        System.out.println("|" + indexField[1][0] + "|" +  indexField[1][1] + "|" + indexField[1][2] + "|");
        System.out.println("+-+-+-+");
        System.out.println("|" + indexField[2][0] + "|" +  indexField[2][1] + "|" + indexField[2][2] + "|");
        System.out.println("+-+-+-+");

    }
    public static boolean isOutOfField(int row, int col) {
        return  row > 2 || col > 2 || row < 0 || col < 0;
    }
}
