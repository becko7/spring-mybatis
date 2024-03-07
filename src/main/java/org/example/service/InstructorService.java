package org.example.service;

import org.example.model.dto.Instructor;
import org.example.repository.InstructorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class InstructorService {
    @Autowired
    private InstructorMapper instructorMapper;
    public Instructor getInstructorByName(String name) {
        return instructorMapper.selectInstructorByName(name);
    }

    public Instructor getInstructorById(Long id) {
        return instructorMapper.selectInstructorById(id);
    }

    public String saveInstructor(Map<String, Object> params) {
        int result = instructorMapper.insertInstructor(params);

        return result == 1 ? "성공적으로 저장하였습니다." : "요청하신 학생정보 등록에 실패하였습니다.";
    }
}
