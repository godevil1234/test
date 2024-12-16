package org.example.functionalProgramming;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ListStudents {
    public static final Scanner scanner = new Scanner(System.in);
    public static final ObjectMapper objectMapper = new ObjectMapper();
    public static final File file = new File("student.json");
    public static ArrayList<ListStudent> students = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        HashMap<String, Integer> subjectsAndMarks = new HashMap<>();
        String subject = "Математика";
        int mark = 5;
        subjectsAndMarks.put(subject,mark);
        ListStudent student = new ListStudent("Иванов", "Иван", "Иванович","ОП-16", subjectsAndMarks);
        students.add(student);
        subjectsAndMarks = new HashMap<>();
        ListStudent student2 = new ListStudent("Петров", "Петр", "Петрович","ОП-16",subjectsAndMarks);
        students.add(student2);
        boolean exit = false;
        while(!exit) {
            printMenu();
            int numberMenu = scanner.nextInt();
            menu(students,numberMenu);
            if(numberMenu == 7) {
                exit = true;
            }
        }
        System.out.println("Программа завершена.");
    }
    public static void printMenu() {
        System.out.println("1.Список студентов");
        System.out.println("2.Добавить студента");
        System.out.println("3.Редактировать студента");
        System.out.println("4.Удалить студента");
        System.out.println("5.Показать отличников");
        System.out.println("6.Показать неуспевающих");
        System.out.println("7.Выход");
        System.out.print("Введите номер пункта: ");
    }
    public static void printStudent(ListStudent student) {
        System.out.println("Фамилия: " + student.lastName);
        System.out.println("Имя: " + student.firstName);
        System.out.println("Отчество: " + student.middleName);
        System.out.println("Группа: " + student.group);
        System.out.println("Оценки: ");
        if(student.objects.isEmpty()) {
            System.out.println("     " + "Оценок нет.");
        }
        for (String subject : student.objects.keySet()) {
            System.out.println("    " + subject + ": " + student.objects.get(subject));
        }
    }
    public static void printEditStudent() {
        System.out.println("1. Изменить фамилию");
        System.out.println("2. Изменить имя");
        System.out.println("3. Изменить Отчество");
        System.out.println("4. Изменить группу");
        System.out.println("5. Добавить оценку");
        System.out.println("6. Изменить оценку");
        System.out.println("7. Удалить оценку");
        System.out.println("8. Назад");
        System.out.print("Выберите пункт: ");
    }
    public static void simplePrintStudent(ArrayList<ListStudent> students) {
        for(int i = 0; i < students.size(); i++) {
            ListStudent student = students.get(i);
            System.out.println((i + 1) + ". " + student.lastName + " " +  student.firstName + " " +
                    student.middleName + " " + "(" + student.group + ")");
        }
    }
    public static void functionOfFirstSelect(ArrayList<ListStudent> students) {
        for (int i = 0; i < students.size(); i++) {
            System.out.println("|====" + (i + 1) + "====|");
            ListStudent student = students.get(i);
            printStudent(student);
        }
    }
    public static void functionOfSecondSelect(ArrayList<ListStudent> students) {
        System.out.print("Введите фамилию: ");
        String newLastName = scanner.next();
        System.out.print("Введите имя: ");
        String newFirstName = scanner.next();
        System.out.print("Введите отчество: ");
        String newMiddleName = scanner.next();
        System.out.print("Введите группу: ");
        String newGroup = scanner.next();
        ListStudent newStudent = new ListStudent(newLastName, newFirstName, newMiddleName, newGroup);
        students.add(newStudent);
        System.out.println("Вы создали нового студента.");
        System.out.println();
    }
    public static void functionOfThirdSelect(ArrayList<ListStudent> students) {
        simplePrintStudent(students);
        System.out.println();
        System.out.print("Выберите номер студента, которого желаете отредактировать: ");
        int editStudent = scanner.nextInt();
        if (editStudent < 1 || editStudent > students.size()) {
            System.out.println("Упс! Похоже что вы ввели некорректный номер...");
        } else {
            ListStudent refactorStudent = students.get(editStudent - 1);
            boolean exit = false;
            while (!exit) {
                System.out.println("Редактируемый студент: ");
                printStudent(refactorStudent);
                System.out.println();
                printEditStudent();
                int changeStudent = scanner.nextInt();
                subMenu(refactorStudent, changeStudent);
                if (changeStudent == 8) {
                    exit = true;
                }
            }
        }
    }
    public static void subMenu(ListStudent refactorStudent, int changeStudent) {
        if (changeStudent == 1) {
            System.out.print("Новая фамилия: ");
            refactorStudent.lastName = scanner.next();
        } else if (changeStudent == 2) {
            System.out.print("Новое имя: ");
            refactorStudent.firstName = scanner.next();
        } else if (changeStudent == 3) {
            System.out.print("Новое отчество: ");
            refactorStudent.middleName = scanner.next();
        } else if (changeStudent == 4) {
            System.out.print("Новая группа: ");
            refactorStudent.group = scanner.next();
        } else if (changeStudent == 5) {
            System.out.print("Введите предмет: ");
            String newSubject = scanner.next();
            System.out.print("Введите оценку: ");
            int newMark = scanner.nextInt();
            if (refactorStudent.objects.containsKey(newSubject)) {
                System.out.println("У этого студента уже есть оценка!");
            } else {
                refactorStudent.objects.put(newSubject, newMark);
            }
        } else if (changeStudent == 6) {
            System.out.print("Введите предмет: ");
            String changeSubject = scanner.next();
            if(!refactorStudent.objects.containsKey(changeSubject)) {
                System.out.println("У студента еще нет оценки!");
            } else {
                System.out.print("Введите оценку: ");
                int changeMark = scanner.nextInt();
                refactorStudent.objects.replace(changeSubject, changeMark);
            }
        } else if (changeStudent == 7) {
            System.out.print("Введите предмет: ");
            String deleteSubject = scanner.next();
            if (!refactorStudent.objects.containsKey(deleteSubject)) {
                System.out.println("Оценок у этого студента нет! ");
                System.out.println();
            } else {
                System.out.println("Вы уверены, что хотите удалить оценку по " + deleteSubject + "? [Y/N]");
                String yesOrNo = scanner.next();
                if(yesOrNo.equals("y")) {
                    refactorStudent.objects.remove(deleteSubject);
                }
            }
        }
    }
    public static void functionOfFourthSelect(ArrayList<ListStudent> students) {
        simplePrintStudent(students);
        System.out.print("Номер студента для удаления: ");
        int numberOfDeleteStudent = scanner.nextInt();
        if (numberOfDeleteStudent  < 1 || numberOfDeleteStudent > students.size()) {
            System.out.println("Упс! Похоже что вы ввели некорректный номер...");
        } else {
            ListStudent deleteStudent = students.get(numberOfDeleteStudent - 1);
            System.out.println("Вы уверены, что хотите удалить студента? " + deleteStudent.lastName + " " +
                    deleteStudent.firstName + " " +  deleteStudent.middleName + " " + deleteStudent.group + "? [y/n]");
            String yesOrNo = scanner.next();
            if(yesOrNo.equals("y")) {
                students.remove(deleteStudent);
            }
        }
    }
    public static void functionOfFifthSelect(ArrayList<ListStudent> students) {
        boolean zeroExcellent = false;
        for(int i = 0; i < students.size(); i++) {
            boolean excellent = true;
            ListStudent student = students.get(i);
            if (!student.objects.isEmpty()){
                for(int marks : student.objects.values()) {
                    if (marks < 5) {
                        excellent = false;
                    }
                }
                if(excellent) {
                    System.out.println("|====" + (i + 1) + "====|");
                    printStudent(student);
                    zeroExcellent = true;
                }
            }

        }
        if(!zeroExcellent) {
            System.out.println("Нет отличников");
        }
    }
    public static void functionOfSixthSelect(ArrayList<ListStudent> students) {
        boolean zeroUnsuccessful = false;
        for(int i = 0; i < students.size(); i++) {
            boolean unsuccessful = false;
            ListStudent student = students.get(i);
            if (!student.objects.isEmpty()){
                for(int marks : student.objects.values()) {
                    if (marks < 3) {
                        unsuccessful = true;
                    }
                }
                if(unsuccessful) {
                    System.out.println("|====" + (i + 1) + "====|");
                    printStudent(student);
                    zeroUnsuccessful = true;
                }
            }
        }
        if(!zeroUnsuccessful) {
            System.out.println("Нет неуспевающих");
        }
    }
    public static void menu(ArrayList<ListStudent> students, int numberMenu) throws IOException{
        while (numberMenu < 1 || numberMenu > 7) {
            System.out.print("Вы ввели несуществующий пункт! Введите снова: ");
            numberMenu = scanner.nextInt();
        } if (numberMenu == 1) {
            if(students.isEmpty()) {
                System.out.println("Список студентов пуст!");
            }
            functionOfFirstSelect(students);
            System.out.println("|========|");
        } else if (numberMenu == 2) {
            functionOfSecondSelect(students);
            objectMapper.writeValue(file, students);
        } if (numberMenu == 3) {
            functionOfThirdSelect(students);
            objectMapper.writeValue(file, students);
        } else if(numberMenu == 4) {
            functionOfFourthSelect(students);
            objectMapper.writeValue(file, students);
        } else if (numberMenu == 5) {
            functionOfFifthSelect(students);
        } else if (numberMenu == 6) {
            functionOfSixthSelect(students);
        }
    }
}
