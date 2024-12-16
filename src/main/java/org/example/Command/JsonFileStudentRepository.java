package org.example.Command;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class JsonFileStudentRepository implements StudentRepository {
    private final ObjectMapper objectMapper;
    private File file;
    private List<Student> students = new ArrayList<>();
    public JsonFileStudentRepository(ObjectMapper objectMapper, File file) {
        this.objectMapper = objectMapper;
        this.file = file;
    }
    @Override
    public void add(Student student){
        try {
            students.add(student);
            objectMapper.writeValue(file, students);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при добавлении студента", e);
        }
    }

    @Override
    public Student getById(int index) {
        try {
            students = objectMapper.readValue(file,new TypeReference<>(){});
            return students.get(index);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при получении студента", e);
        }
    }

    @Override
    public List<Student> getAllStudents() {
        try {
            return objectMapper.readValue(file, new TypeReference<>() {});
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при получении всех студентов", e);
        }
    }

    @Override
    public void update(int index, Student student) {
        try {
            students = objectMapper.readValue(file, new TypeReference<>() {});
            students.set(index, student);
            objectMapper.writeValue(file,student);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при обновлении студента",e);
        }
    }

    @Override
    public void delete(int index) {
        try {
            students = objectMapper.readValue(file, new TypeReference<>() {});
            students.remove(index);
            objectMapper.writeValue(file,students);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при удалении студента",e);
        }
    }

    @Override
    public void delete(Student student) {
        try {
            students = objectMapper.readValue(file, new TypeReference<>() {});
            students.remove(student);
            objectMapper.writeValue(file,students);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при удалении студента",e);
        }
    }
}
