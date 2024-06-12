package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Json {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("student.json");

        ArrayList<NewStudent> students = new ArrayList<>();
        String surname;
        byte mark;
        System.out.print("Введите фамилию студента: ");
        surname = scanner.nextLine();
        while(!surname.equals("выход")) {
            System.out.print("Введите оценку студента: ");
            mark = scanner.nextByte();
            NewStudent student = new NewStudent(surname,mark);
            students.add(student);
            System.out.print("Введите фамилию студента: ");
            surname = scanner.next();
        }

        objectMapper.writeValue(file, students);

        ArrayList<NewStudent> students1 = objectMapper.readValue(file, new TypeReference<>() {});
        boolean noStudent = true;
        System.out.print("Введите фамилию ученика : ");
        String SearchName = scanner.next();
        for (NewStudent studentsX : students1) {
            if (studentsX.name.equals(SearchName)) {
                System.out.println("Оценка этого студента: " + studentsX.mark);
                noStudent = false;
                break;
            }
        }
        if (noStudent) {
            System.out.println("Такого ученика нет в списке!");
        }
    }
}
class NewStudent {
    public String name;
    public byte mark;

    NewStudent(){

    }
    NewStudent(String name, byte mark) {
        this.name = name;
        this.mark = mark;
    }
}