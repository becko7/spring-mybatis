package org.example.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class LectureCourseInfo {
    private String title;
    private Long lectureCourseId;
    private LocalDate from;
    private LocalDate to;
    private Integer capacity;
    private Integer registeredStudentCount;
}
