package com.oliveira.online_course_platform.controller;

import com.oliveira.online_course_platform.domain.course.Course;
import com.oliveira.online_course_platform.domain.course.RequestCourseDTO;
import com.oliveira.online_course_platform.domain.course.ResponseCourseDTO;
import com.oliveira.online_course_platform.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    public ResponseEntity<ResponseCourseDTO> createCourse(RequestCourseDTO data) {
        Course course = courseService.createCourse(data);
        ResponseCourseDTO courseDTO = new ResponseCourseDTO(course.getTitle(), course.getDescription());
        return ResponseEntity.ok(courseDTO);
    }
}
