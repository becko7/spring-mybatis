package org.example.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class LectureCourseDetail {
    private String title;
    private Long lectureCourseId;
    private LocalDate from;
    private LocalDate to;
    private String instructorName;
    private Long instructorId;
    private String studentName;
    private Long studentId;
    private LocalDate registeredAt;
}
