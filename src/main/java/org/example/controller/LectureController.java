package org.example.controller;

import org.example.model.dto.LectureCourseDetail;
import org.example.model.dto.LectureCourseInfo;
import org.example.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class LectureController {
    @Autowired
    private LectureService lectureService;

    @GetMapping("/lecture")
    public List<LectureCourseInfo> getLecture() {
        return lectureService.getLectureCourseInfo();
    }

    @GetMapping("/lecture/details")
    public List<LectureCourseDetail> getListOfStudentName(@RequestParam Map<String, Object> params) {
        // high cohesion, loosed coupling => tight coupling
        // 응집도라는 개념의 대상은 자기만의 고유 속성들끼리만 모여있는것을.
        // controller layer => http로 요청온것에 대한 처리만 주로 담당하고, 나머지는 service layer로 위임한다.

        return lectureService.getLectureCourseDetails(params);
    }
}