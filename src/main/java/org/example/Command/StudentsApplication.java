package org.example.Command;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Scanner;

public class StudentsApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu mainMenu = new Menu();
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("students.json");
        StudentRepository studentRepository = new JsonFileStudentRepository(objectMapper, file);
        Screen addStudentScreen = new AddStudentScreen(scanner);
        StudentController studentController = new StudentController(mainMenu, studentRepository);

        mainMenu.run();
    }
}
