package org.example.controller;

import org.example.model.dto.Instructor;
import org.example.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class InstructorConroller {
    @Autowired
    private InstructorService instructorService;

    @GetMapping("/instructor")
    public Instructor getInstructorByName(@RequestParam String name) {
        return instructorService.getInstructorByName(name);
    }

    @GetMapping("/instructor/{id}")
    public Instructor getInstructorById(@PathVariable Long id) {
        return instructorService.getInstructorById(id);
    }

    @PostMapping("/instructor")
    public ResponseEntity<String> registInstructor(@RequestBody Map<String, Object> params) {
        return ResponseEntity.ok().body(instructorService.saveInstructor(params));
    }
}
