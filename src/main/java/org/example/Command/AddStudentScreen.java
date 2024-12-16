package org.example.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddStudentScreen implements Screen {
    private final Scanner scanner;
    private final List<StudentAddedListener> listeners = new ArrayList<>();

    public AddStudentScreen(Scanner scanner) {
        this.scanner = scanner;
    }
    public void subscribe(StudentAddedListener listener) {
        listeners.add(listener);
    }
    @Override
    public void show() {
        System.out.print("Фамилия: ");
        String lastName = scanner.nextLine();
        System.out.print("Имя: ");
        String firstName = scanner.nextLine();
        System.out.print("Отчество: ");
        String middleName = scanner.nextLine();
        System.out.print("Группа: ");
        String group = scanner.nextLine();

        for (StudentAddedListener listener : listeners) {
            listener.onAdded(lastName, firstName, middleName, group);
        }
    }
}
