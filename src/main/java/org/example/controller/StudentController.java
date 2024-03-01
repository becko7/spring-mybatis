package org.example.controller;

import org.example.model.Student;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/student/count")
    public Integer countOfStudent() {
        return studentService.countOfStudent();
    }

    @GetMapping("/student/name/list")
    public List<String> getListOfStudentName() {
        return studentService.getListOfStudentName();
    }

    /**
     * curl -X PUT "http://localhost:8080/student/regist?name=이지아&age=29"
     *
     * curl -X PUT -G --data-urlencode "name=김영수" --data-urlencode "age=28" http://localhost:8080/student/regist
     *
     * requestBody
     * curl -X PUT "http://localhost:8080/student/regist" -d '{ "name":"김영수", "age":"28"}'
     * @param params
     */
    @PutMapping("/student/regist")
    public void registStudent(@RequestParam Map<String, Object> params) {
        studentService.registStudent(params);
    }

    @GetMapping("/student/{studentId}")
    public Map<String, Object> getListOfStudentName(@PathVariable Integer studentId) {
        return studentService.getStudent(studentId);
    }

    @PutMapping("/student/regist2")
    public void registStudent(@RequestBody Student student) {
        studentService.registStudent(student);
    }

    @GetMapping("/student/list")
    public List<Student> getListOfStudent() {
        return studentService.getListOfStudent();
    }

    @GetMapping("/student/search")
    public List<Student> searchStudent(@RequestParam String name) {
        return studentService.findStudents(name);
    }

    @GetMapping("/student/search/{studentId}")
    public Optional<Student> getStudent(@PathVariable Integer studentId) {
        return studentService.findStudent(studentId);
    }
}
