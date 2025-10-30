package com.oliveira.online_course_platform.domain.user;

public record ResponseUserDTO(String firstName,
                              String lastName,
                              String email,
                              String username
                              ) {
}
