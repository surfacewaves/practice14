package org.example.dao;

import org.example.model.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentDAO {
    private static int STUDENTS_COUNT;
    private List<Student> students;

    {
        students = new ArrayList<>();

        students.add(new Student(++STUDENTS_COUNT, "Andreev", "Nicolay"));
        students.add(new Student(++STUDENTS_COUNT, "Bulshiy", "Kristina"));
    }

    public List<Student> index() {
        return students;
    }

    public Student show(int id) {
        return students.stream().filter(student -> student.getId() == id).findAny().orElse(null);
    }

    public void save(Student student) {
        student.setId(++STUDENTS_COUNT);
        students.add(student);
    }

    public void update(int id, Student student) {
        Student studentToBeUpdated = show(id);
        studentToBeUpdated.setLastName(student.getLastName());
        studentToBeUpdated.setFirstName(student.getFirstName());
    }

    public void delete(int id) {
        students.removeIf(student -> student.getId() == id);
    }
}
