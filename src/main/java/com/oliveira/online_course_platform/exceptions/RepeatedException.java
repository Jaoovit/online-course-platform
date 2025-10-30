package com.oliveira.online_course_platform.exceptions;

public class RepeatedException extends RuntimeException {
    public RepeatedException(String message) {
        super(message);
    }
}
