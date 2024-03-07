package org.example.service;

import org.example.model.dto.LectureCourseDetail;
import org.example.model.dto.LectureCourseInfo;
import org.example.repository.LectureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LectureService {
    @Autowired
    private LectureMapper lectureMapper;

    public List<LectureCourseInfo> getLectureCourseInfo() {
        return lectureMapper.selectLectureCourseInfos();
    }

    public List<LectureCourseDetail> getLectureCourseDetails(Map<String, Object> params) {
        List<LectureCourseDetail>  list = lectureMapper.selectLectureCourseDetails(params);
        //복호화도 하고
        // 다른비지니스처리르 100개정도한다면
        // => 세분화 대상
        // java convetion rule & code style
        return lectureMapper.selectLectureCourseDetails(params);
    }
}
