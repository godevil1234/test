package org.example.Command;

public class StudentController {
    private final Menu mainMenu;
    private final StudentRepository studentRepository;
    private final AddStudentScreen addStudentScreen;

    public StudentController(Menu mainMenu, StudentRepository studentRepository, AddStudentScreen addStudentScreen) {
        this.mainMenu = mainMenu;
        this.studentRepository = studentRepository;
        this.addStudentScreen = addStudentScreen;

        initMenu();
    }

    private void initMenu() {
        mainMenu.addItem("Список студентов", this::listStudents);
        mainMenu.addItem("Добавить студента", this::addStudent);
        mainMenu.addSubMenu("Редактировать студента");
    }

    private void listStudents() {
        for(int i = 0; i < studentRepository.getAllStudents().size(); i++) {
            studentRepository.getAllStudents().get(i).showStudent();
        }
    }

    private void addStudent() {
        addStudentScreen.subscribe(this::handleAddStudent);
        addStudentScreen.show();
    }
    private void editStudent() {}

    private void handleAddStudent(String lastName, String firstName, String middleName, String group) {
        Student student = new Student(lastName, firstName, middleName, group);

        studentRepository.add(student);
    }
}
