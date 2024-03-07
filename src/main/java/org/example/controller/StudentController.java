package org.example.controller;

import org.example.model.dto.Student;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 요청을 담당할 컨트롤러이다라고 스프링한테 알려주기 위한것 ==> @RestController
 */
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * curl -X GET "http://localhost:8080/student
     * @param name
     * @return
     */
    @GetMapping("/student")
    public Student getStudent(@RequestParam(required = false) String name) {
        return studentService.getStudentByName(name);
    }

    /**
     * curl -H  -X POST "http://localhost:8080/student" -d '{"name": "tom", "age": 19, "desc":"hi tom"}'
     * "Unsupported Media Type"
     * => request 할 데이터 타입을 명시해줘야함 => 잘못요청했기떄문에 4XX 에러 응답받음
     *
     * 정상처리되었으나 curl + jq => 로컬옵션으로 최종처리된 결과 출력하다가 오류남. 실제 처리는 정상적으로 된것임. jq에서 오류.
     * jq는 [ { 이런 기호있어야 정상 파싱함.
     * curl -H "Content-Type: application/json" -X POST "http://localhost:8080/student" -d '{"name": "tom", "age": 19, "desc":"hi tom"}'
     *
     * [DEBUG] 2024-03-07 16:24:55.957 : o.s.w.s.m.m.a.RequestResponseBodyMethodProcessor - Writing ["성공적으로 저장하였습니다."]
     * [DEBUG] 2024-03-07 16:24:55.958 :      o.s.w.s.DispatcherServlet - Completed 200 OK => 성공 처리된것임.
     *
     * ResponseEntity.ok().body(studentService.saveStudent(params));
     * 이렇게 수정후 재실행하면 mac jq로도 응답 확인 가능 X 응답형태를 무조건 json형태로 맞춰줘야함.
     * => ["성공적으로 저장하였습니다."] 이렇게가 아니라 [{"result" : "성공적으로 저장하였습니다."}] 이런식으로. 요건 JQ 에서만 국한된 문제라서 포스트맨은 정상결과 출력된거까지 확인할수 있을것임.
     *
     * curl -H "Content-Type: application/json" -X POST "http://localhost:8080/student" -d '{"name": "tom", "age": 20, "desc":"hi tom"}'
     *
     * @param params
     * @return
     */
    @PostMapping("/student")
    public ResponseEntity<String> registStudent(@RequestBody Map<String, Object> params) {
        return ResponseEntity.ok().body(studentService.saveStudent(params));
    }
}
