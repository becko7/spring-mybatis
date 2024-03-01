package org.example.repository;

import lombok.AllArgsConstructor;
import org.example.model.Student;
import org.example.model.StudentRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository("studentJdbcRepository")
@AllArgsConstructor
public class StudentJdbcRepository implements StudentRepository {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public int countOfStudents() {
        return jdbcTemplate.queryForObject("SELECT COUNT(1) FROM student", Integer.class);
    }

    @Override
    public List<String> selectListOfStudentName() {
        List<String> list = jdbcTemplate.queryForList(
                "SELECT name FROM student", String.class);

        return list;
    }

    @Override
    public int insertStudent(Map<String, Object> params) {
        String name = (String) params.get("name");
        int age = Integer.parseInt((String) params.get("age"));

        return jdbcTemplate.update(
                "INSERT INTO student(name, age, created_at) VALUES (?, ?, now())", name, age);
    }

    @Override
    public Map<String, Object> getStudent(int id) {
        //SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        return jdbcTemplate.queryForMap(
                "SELECT id, name FROM student WHERE id = ?", id);
    }


    @Override
    public int insertStudent(Student student) {
        return jdbcTemplate.update(
                "INSERT INTO student(name, age) VALUES(?, ?)",
                student.getName(), student.getAge());
    }

    @Override
    public List<Student> selectListOfStudent() {
        List<Student> list = jdbcTemplate.query("SELECT * FROM student", new StudentRowMapper());

        return jdbcTemplate.query(
                "SELECT * FROM student",
                (rs, rowNum) ->
                        new Student(
                                rs.getLong("id"),
                                rs.getString("name"),
                                rs.getInt("age"),
                                rs.getDate("created_at")
                        )
        );
    }

    @Override
    public List<Student> findStudents(String name) {
        return jdbcTemplate.query(
                "select * from student where name like ?",
                new Object[]{"%" + name + "%"},
                (rs, rowNum) ->
                        new Student(
                                rs.getLong("id"),
                                rs.getString("name"),
                                rs.getInt("age"),
                                rs.getDate("created_at")
                        )
        );
    }

    @Override
    public Optional<Student> selectStudentById(Integer studentId) {
        return jdbcTemplate.queryForObject(
                "select * from student where id = ?",
                new Object[]{studentId},
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