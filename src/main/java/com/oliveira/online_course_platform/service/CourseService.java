package com.oliveira.online_course_platform.service;

import com.oliveira.online_course_platform.domain.course.Course;
import com.oliveira.online_course_platform.domain.course.RequestCourseDTO;
import com.oliveira.online_course_platform.exceptions.BadRequest;
import com.oliveira.online_course_platform.exceptions.NotFound;
import com.oliveira.online_course_platform.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    ValidationService validationService;

    public Course createCourse(RequestCourseDTO data) {
        validationService.validateInput(data);

        Course course = new Course();
        course.setTitle(data.title());
        course.setDescription(data.description());

        courseRepository.save(course);
        return course;
    }

    public List<Course> getCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses;
    }

    public Course getCourseById(UUID courseId) {
        return courseRepository.findById(courseId)
                .orElseThrow(() -> new NotFound("Course not found"));
    }

    public Course updateCourse(RequestCourseDTO data, UUID courseId) {
        validationService.validateInput(data);

        Course course = getCourseById(courseId);
        course.setTitle(data.title());
        course.setDescription(data.description());

        courseRepository.updateCourse(course.getId(), course.getTitle(), course.getDescription());
        return course;
    }

    public void deleteCourse(UUID courseId) {
        Course course = getCourseById(courseId);
        courseRepository.delete(course);
    }
}
