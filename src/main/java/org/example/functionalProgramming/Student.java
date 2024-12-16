package org.example;

class Student {
    String lastName;     // поле
    String firstName;
    String middleName;
    int mark;

    Student() {}

    // конструктор
    Student(String lastName, String firstName, String middleName, int mark) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.mark = mark;
    }

    String getFullName() {
        return lastName + " " + firstName + " " + middleName;
    }

    // геттер
    public int getMark() {
        return mark;
    }

    // сеттер
    void setMark(int mark) {
        if (mark >= 2 && mark <= 5) {
            this.mark = mark;
        }
    }

    // метод
    void printMe() {
        System.out.println("Фамилия: " + lastName);
        System.out.println("Имя: " + firstName);
        System.out.println("Отчество: " + middleName);
        System.out.println("Оценка: " + mark);
    }
}
