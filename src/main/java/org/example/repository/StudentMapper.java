package org.example.repository;

import org.apache.ibatis.annotations.Mapper;
import org.example.model.dto.Student;

import java.util.Map;

@Mapper
public interface StudentMapper {
    Student selectStudentByName(String name);

    Boolean isExistsStudent(Long id);

    // TODO request받을 파라미터 정보들도 request dto와 같은 형식의 pojo로 처리하는게 좋음.
    //      전 일단 귀찮아서 Map으로 샘플 예시작성중
    int insertStudent(Map<String, Object> params);
}
