package com.oliveira.online_course_platform.domain.module;

import com.oliveira.online_course_platform.domain.validation.RequestData;

public record RequestModuleDTO(String title, String description) implements RequestData {
}
