package org.example.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Student {
    private Long id;
    private String name;
    private Integer age;
    private String desc;
    private LocalDate createdAt;
}
