package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentClass {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        String name = " ", middleName = " ", firstname = " ";
        int mark = 0;
        Student student = new Student(firstname, name, middleName, mark);
        int sum = 0;
        boolean noStudent = true;

        System.out.print("Введите фамилию: ");
        firstname = scanner.next();

        while (!firstname.equals("Выход")) {
            System.out.print("Введите имя: ");
            name = scanner.next();
            System.out.print("Введите отчество: ");
            middleName = scanner.next();
            System.out.print("Введите оценку: ");
            mark = scanner.nextInt();
            student = new Student(firstname, name, middleName, mark);
            students.add(student);
            System.out.print("Введите Фамилию: ");
            firstname = scanner.next();
        }
        System.out.println("|============|");
        System.out.print("Введите фамилию, чью оценку вы бы хотели узнать: ");
        String searchLastName = scanner.next();
        for (int i = 0; i < students.size(); i++) {
            sum += students.get(i).mark;
            if (students.get(i).lastName.equals(searchLastName)) {
                System.out.println("Оценка этого студента: " + student.mark);
                noStudent = false;
            }
        } if(noStudent) {
            System.out.println("Такого студента нет в списке!");
        }
        System.out.printf("Средний балл среди всех студентов: %.1f", (double)sum / students.size());
    }

    private static Student createStudent(
            String lastName,
            String firstName,
            String middleName,
            int mark
    ) {
        Student result = new Student();
        result.lastName = lastName;
        result.firstName = firstName;
        result.middleName = middleName;
        result.mark = mark;

        return result;
    }

    private static void printStudent(Student student) {
        System.out.println("Фамилия: " + student.lastName);
        System.out.println("Имя: " + student.firstName);
        System.out.println("Отчество: " + student.middleName);
        System.out.println("Оценка: " + student.mark);
    }
}
