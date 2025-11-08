package com.oliveira.online_course_platform.domain.module;

import com.oliveira.online_course_platform.domain.lesson.Lesson;

import java.util.List;

public record ResponseModuleDTO(String title, String description, List<Lesson> lessons) {
}
