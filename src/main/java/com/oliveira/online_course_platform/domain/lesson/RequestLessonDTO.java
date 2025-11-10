package com.oliveira.online_course_platform.domain.lesson;

import com.oliveira.online_course_platform.domain.validation.RequestData;

public record RequestLessonDTO(String title, String description) implements RequestData {
}
