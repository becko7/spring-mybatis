package org.example.repository;

import org.apache.ibatis.annotations.Mapper;
import org.example.model.dto.Instructor;

import java.util.Map;

@Mapper
public interface InstructorMapper {
    Instructor selectInstructorByName(String name);
    Instructor selectInstructorById(Long id);
    int insertInstructor(Map<String, Object> params);
}
