package org.example.repository;

import org.example.model.Student;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface StudentRepository {
    int countOfStudents();
    List<String> selectListOfStudentName();

    int insertStudent(Map<String, Object> params);

    Map<String, Object> getStudent(int id);
    int insertStudent(Student student);
    List<Student> selectListOfStudent();
    List<Student> findStudents(String name);
    Optional<Student> selectStudentById(Integer studentId);

}
