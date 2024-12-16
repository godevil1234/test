package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class StudentHashMap {
    private static final Scanner scanner = new Scanner(System.in);
    public static final String LAST_NAME = "Фамилия";
    public static final String FIRST_NAME = "Имя";
    public static final String MIDDLE_NAME = "Отчество";
    public static final String MARK = "Оценка";

    public static void main(String[] args) {
        ArrayList<HashMap<String, Object>> students = new ArrayList<>();
        int sum = 0,mark;
        boolean noStudent = true;
        String middleName;
        String name;
        System.out.print("Введите Фамилию: ");
        String surname = scanner.next();

        while (!surname.equals("Выход")) {
            System.out.print("Введите имя: ");
            name = scanner.next();
            System.out.print("Введите отчество: ");
            middleName = scanner.next();
            System.out.print("Введите оценку: ");
            mark = scanner.nextInt();
            HashMap<String, Object> student = createStudent(surname, name, middleName, mark);
            students.add(student);

            System.out.print("Введите Фамилию: ");
            surname = scanner.next();
        }
        System.out.println("|===============|");

        System.out.print("Введите фамилию, чью оценку вы хотите узнать: ");
        String searchSurname = scanner.next();

        for (int i = 0; i < students.size(); i++) {
            sum += (int)students.get(i).get(MARK);
            if (students.get(i).get(LAST_NAME).equals(searchSurname)) {
                System.out.println("Оценка этого студента: " + students.get(i).get(MARK));
                noStudent = false;
            }
        } if (noStudent) {
            System.out.print("Такой фамилии нет в списке! ");
        }

        System.out.printf("Средний балл учеников: %.1f", (double)sum / students.size());
    }
    private static HashMap<String, Object> createStudent(
            String lastName,
            String firstName,
            String middleName,
            int mark
    ) {
       HashMap<String, Object> result = new HashMap<>();
        result.put(LAST_NAME, lastName);
        result.put(FIRST_NAME, firstName);
        result.put(MIDDLE_NAME, middleName);
        result.put(MARK, mark);

        return result;
    }
}