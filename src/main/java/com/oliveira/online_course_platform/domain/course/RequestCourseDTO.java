package com.oliveira.online_course_platform.domain.course;

import com.oliveira.online_course_platform.domain.validation.RequestData;

public record RequestCourseDTO(String title, String description) implements RequestData {
}
