## spring-mybatis

#### spring-jdbc 기반에서 추가적으로 아래 실습들 진행
#### Mybatis 설정 in Spring boot autoconfiguration
#### Mybatis 설정 in Spring boot (exclude autoconfig)
#### data process with mybatis
```sql
-- 학생별 수강 현황
select id, name, cource_name
, case when cource_name is null then '미수강' else '수강' end status
from (
select t1.id
, t1.name
, (select title from lecture_course where id = t2.lecture_course_id) cource_name
from student t1
left outer join lecture_applicants t2 on t1.id = t2.student_id
) result;

-- 강사별 강의 과목 갯수 현황
select t1.id, t1.name, count(t2.id) AS lectureCnt
from instructor t1
left outer join lecture_course t2 on t1.id = t2.instructor_id
group by t1.id, t1.name;

-- 과목 & 일자별 출결 현황
select
(select title from lecture_course where id = t1.lecture_course_id) AS title
, date_format(t1.created_at, '%y-%m-%d') as date
, count(1) as attendanceCnt
from attendance t1
group by t1.lecture_course_id, date_format(t1.created_at, '%y-%m-%d');
```


#### TODO
1. 학생 정보 등록 (신규학생)
2. 학생 정보 수정 (나이 또는 이름 수정하기
    => 나이와 이름을 항상 같이 수정하기 vs 나이만 수정하기 vs 이름만 수정하기.
3. 강사 정보 등록하기 (수정은 만들지 않는다 => 수정 불가능)
4. 강의 정보 등록/수정하기 
   => 강의는 강사ID를 가지고 있습니다.
   => 등록시 : 해당 강사가 이미 담당 강의가 2개라면 추가 등록 불가능하게
   => 강의 정보 수정은 담당강사정보 변경만 가능하다.
       => 꼭 존재하는 강사의 ID를 사용해야 함.(무결성을 확보할 수 있는 비지니스코드)
       => 만약 변경하려는 강사가 이미 2개의 수업을 담당하고 있다면 해당강의의 담당 강사 변경이 불가능

5. 수강신청하기 (lecture_applicants)테이블에 저장하기
    => 강의정보에 capacity : 70 => 70명까지만 수강신청이 가능한것.
    => 70명까지 찼으면 더이상 신청못하게(신청요청을 받더라도 처리안하고 "수강인원이 다 찼습니다")
6. 수강신청한 학생들이 매일마다 출석체크(attendance)
    => 중복 출석 체크를 못하도록 잘 작성을 해야된다.




