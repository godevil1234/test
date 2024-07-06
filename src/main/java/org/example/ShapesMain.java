package org.example;

import java.util.Scanner;

public class ShapesMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Shape shape;

        while (true) {
            System.out.print("Введите тип фигуры: ");
            String shapeType = scanner.nextLine();

            if (shapeType.equals("c")) {
                shape = inputCircle(scanner);
                break;
            } else if (shapeType.equals("s")) {
                shape = inputSquare(scanner);
                break;
            } else {
                System.out.println("Некорректный тип фигуры");
            }
        }

        System.out.println("Введите координаты точки для проверки");
        System.out.print("x: ");
        double x = scanner.nextDouble();
        System.out.print("y: ");
        double y = scanner.nextDouble();

        if (shape.isInside(x, y)) {
            System.out.println("Точка попала в фигуру");
        } else {
            System.out.println("Точка не попала в фигуру");
        }
    }
    public static Shape inputCircle(Scanner scanner) {
        System.out.println("Введите координаты центра");
        System.out.print("x: ");
        double x = scanner.nextDouble();
        System.out.print("y: ");
        double y = scanner.nextDouble();
        System.out.print("Введите радиус: ");
        double radius = scanner.nextDouble();

        return new Circle(x, y, radius);
    }
    public static Shape inputSquare(Scanner scanner) {
        System.out.println("Введите координаты левого верхнего угла: ");
        System.out.print("x: ");
        double x = scanner.nextDouble();
        System.out.print("y: ");
        double y = scanner.nextDouble();
        System.out.print("Введите размер стороны: ");
        double side = scanner.nextDouble();

        return new Square(x, y, side);
    }
}
