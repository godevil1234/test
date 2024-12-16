package org.example.Command;

import java.util.List;

public interface StudentRepository {
    void add(Student student);
    Student getById(int index);
    List<Student> getAllStudents();
    void update(int index, Student student);
    void delete(int index);
    void delete(Student student);
}
