package com.oliveira.online_course_platform.domain.user;

public record RequestUserDTO(String firstName,
                             String lastName,
                             String email,
                             String username,
                             String password) {
}
