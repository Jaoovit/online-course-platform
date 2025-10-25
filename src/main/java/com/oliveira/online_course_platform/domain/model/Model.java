package com.oliveira.online_course_platform.domain.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;

public class Model {

    @Id
    @GeneratedValue
    private UUID id;

    private String title;
    private String description;
    private Boolean completed;
}
