package com.oliveira.online_course_platform.controller;

import com.oliveira.online_course_platform.domain.course.Course;
import com.oliveira.online_course_platform.domain.course.RequestCourseDTO;
import com.oliveira.online_course_platform.domain.course.ResponseCourseDTO;
import com.oliveira.online_course_platform.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<ResponseCourseDTO> createCourse(@RequestBody RequestCourseDTO data) {
        Course course = courseService.createCourse(data);
        ResponseCourseDTO courseDTO = new ResponseCourseDTO(
                course.getTitle(),
                course.getDescription(),
                List.of());
        return ResponseEntity.ok(courseDTO);
    }

    @GetMapping
    public ResponseEntity<List<ResponseCourseDTO>> getCourses() {
        List<Course> courses = courseService.getCourses();
        List<ResponseCourseDTO> coursesDTO = courses.stream()
                .map(course ->  new ResponseCourseDTO(
                        course.getTitle(),
                        course.getDescription(),
                        course.getModules()
                ))
                .toList();

        return ResponseEntity.ok(coursesDTO);
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<ResponseCourseDTO> getCourseById(@RequestParam UUID courseId) {
        Course course = courseService.getCourseById(courseId);
        ResponseCourseDTO courseDTO = new ResponseCourseDTO(
                course.getTitle(),
                course.getDescription(),
                course.getModules()
        );
        return ResponseEntity.ok(courseDTO);
    }

    @PutMapping("/{courseId}")
    public ResponseEntity<ResponseCourseDTO> updateCourse(@RequestBody RequestCourseDTO data, @RequestParam UUID courseId) {
        Course course = courseService.updateCourse(data, courseId);
        ResponseCourseDTO courseDTO = new ResponseCourseDTO(
                course.getTitle(),
                course.getDescription(),
                course.getModules()
        );
        return ResponseEntity.ok(courseDTO);
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity deleteCourse(@RequestParam UUID courseId) {
        courseService.deleteCourse(courseId);
        return ResponseEntity.ok().build();
    }
}
