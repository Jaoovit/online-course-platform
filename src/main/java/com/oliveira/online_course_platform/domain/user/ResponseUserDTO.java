package com.oliveira.online_course_platform.domain.user;

import com.oliveira.online_course_platform.domain.course.Course;

import java.util.List;

public record ResponseUserDTO(String firstName,
                              String lastName,
                              String email,
                              String username,
                              List<Course> courses
                              ) {
}
