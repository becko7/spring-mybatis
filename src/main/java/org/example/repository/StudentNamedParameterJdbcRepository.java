package org.example.repository;

import org.example.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository("studentNamedParameterJdbcRepository")
public class StudentNamedParameterJdbcRepository implements StudentRepository {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public int countOfStudents() {
        return 0;
    }

    @Override
    public List<String> selectListOfStudentName() {
        return null;
    }

    @Override
    public int insertStudent(Map<String, Object> params) {
        return 0;
    }

    @Override
    public Map<String, Object> getStudent(int id) {
        return null;
    }

    @Override
    public int insertStudent(Student student) {
        return 0;
    }

    @Override
    public List<Student> selectListOfStudent() {
        return null;
    }

    @Override
    public List<Student> findStudents(String name) {
        return null;
    }

    @Override
    public Optional<Student> selectStudentById(Integer studentId) {
        return namedParameterJdbcTemplate.queryForObject(
                "select * from student where id = :id",
                new MapSqlParameterSource("id", studentId),
                (rs, rowNum) ->
                        Optional.of(new Student(
                                rs.getLong("id"),
                                rs.getString("name"),
                                rs.getInt("age"),
                                rs.getDate("created_at")
                        ))
        );
    }
}
