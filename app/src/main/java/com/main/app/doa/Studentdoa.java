package com.main.app.doa;

import com.main.app.entity.Student;

import java.util.List;

public interface Studentdoa {
    Student saveStudent(Student student);
    Student updateStudentName(Student student);
    Student updateStudent(Student student);
    Student getByID(int id);
    String deleteById(int id);
    List<Student> allStudent();
}
