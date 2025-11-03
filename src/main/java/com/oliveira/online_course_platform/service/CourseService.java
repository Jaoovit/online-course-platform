package com.oliveira.online_course_platform.service;

import com.oliveira.online_course_platform.domain.course.Course;
import com.oliveira.online_course_platform.domain.course.RequestCourseDTO;
import com.oliveira.online_course_platform.exceptions.BadRequest;
import com.oliveira.online_course_platform.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public Course createCourse(RequestCourseDTO data) {

        if (data.title().length() > 75) throw new BadRequest("Title can't have more then 75 characters");
        if (data.title().length() > 150) throw new BadRequest("Description can't have more then 150 characters");

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
}
