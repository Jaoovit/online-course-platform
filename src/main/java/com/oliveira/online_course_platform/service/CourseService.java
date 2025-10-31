package com.oliveira.online_course_platform.service;

import com.oliveira.online_course_platform.domain.course.Course;
import com.oliveira.online_course_platform.domain.course.RequestCourseDTO;
import com.oliveira.online_course_platform.exceptions.BadRequest;
import com.oliveira.online_course_platform.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public Course createCourse(RequestCourseDTO data) {
        Course course = new Course();

        if (data.title().length() > 75) throw new BadRequest("Title can't have more then 25 characters");
        course.setTitle(data.title());

        if (data.title().length() > 150) throw new BadRequest("Description can't have more then 25 characters");
        course.setDescription(data.description());

        course.setModules(new ArrayList<Module>());

        courseRepository.save(course);
        return course;
    }
}
