package org.example.controller;

import org.example.model.dto.Student;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 요청을 담당할 컨트롤러이다라고 스프링한테 알려주기 위한것 ==> @RestController
 */
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * curl -X GET "http://localhost:8080/student
     * @param name
     * @return
     */
    @GetMapping("/student")
    public Student getStudent(@RequestParam(required = false) String name) {
        return studentService.getStudentByName(name);
    }

    @PostMapping("/student")
    public ResponseEntity<String> registStudent(@RequestBody Map<String, Object> params) {
        return ResponseEntity.ok().body(studentService.saveStudent(params));
    }
}
