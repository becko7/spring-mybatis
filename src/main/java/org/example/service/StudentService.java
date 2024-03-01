package org.example.service;

import lombok.AllArgsConstructor;
import org.example.model.Student;
import org.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    @Qualifier("studentNamedParameterJdbcRepository")
    private StudentRepository studentRepository;
    //private final StudentRepository studentJdbcRepository;

    public Integer countOfStudent() {
        return studentRepository.countOfStudents();
    }
    public List<String> getListOfStudentName() {
        return studentRepository.selectListOfStudentName();
    }

    public void registStudent(Map<String, Object> params) {
        studentRepository.insertStudent(params);
    }

    public Map<String, Object> getStudent(int id) {
        return studentRepository.getStudent(id);
    }

    public void registStudent(Student student) {
        studentRepository.insertStudent(student);
    }

    public List<Student> getListOfStudent() {
        return studentRepository.selectListOfStudent();
    }

    public List<Student> findStudents(String name) {
        return studentRepository.findStudents(name);
    }

    public Optional<Student> findStudent(Integer studentId) {
        return studentRepository.selectStudentById(studentId);
    }
}
