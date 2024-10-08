package org.example.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Instructor {
    private Long id;
    private String name;
    private boolean left;
    private String desc;
    private LocalDate createdAt;
}
