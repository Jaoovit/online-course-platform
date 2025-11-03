package com.oliveira.online_course_platform.domain.course;

import com.oliveira.online_course_platform.domain.module.Module;

import java.util.List;

public record ResponseCourseDTO(String title, String description, List<Module> modules) {
}
