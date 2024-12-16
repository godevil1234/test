package org.example.Command;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Student {
    private String firstName;
    private String lastName;
    private String middleName;
    private String group;
    private final Map<String, Integer> marks = new HashMap<>();

    public Student() {}

    public Student(String firstName, String lastName, String middleName, String group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.group = group;
    }
    public Set<String> getSubjects() {
        return marks.keySet();
    }

    public int getMarkForSubject(String subject) {
        return marks.get(subject);
    }

    public void addMark(String subject, int mark) {
        if (marks.containsKey(subject)) {
            throw new IllegalArgumentException("Оценка по указанному предмету уже есть");
        }

        marks.put(subject, mark);
    }

    public void changeMark(String subject, int mark) {
        if (!marks.containsKey(subject)) {
            throw new IllegalArgumentException("Оценки по указанному предмету еще нет");
        }

        marks.put(subject, mark);
    }

    public void removeMark(String subject) {
        marks.remove(subject);
    }
    public void showStudent() {
        System.out.println("Имя: "+ firstName);
        System.out.println("Фамилия: "+ lastName);
        System.out.println("Отчество: "+ middleName);
        System.out.println("Группа: "+ group);
        System.out.println();
    }
}
