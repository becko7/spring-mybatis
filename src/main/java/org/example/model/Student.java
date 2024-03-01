package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;

@Getter
@Setter
public class Student {
    private Long id;
    private String name;
    private Integer age;
    private String desc;
    private LocalDate createdAt;

    public Student() {}
    public Student(Long id, String name, Integer age, Date createdAt) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.createdAt = createdAt.toLocalDate();
    }
}
