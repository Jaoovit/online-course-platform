package com.oliveira.online_course_platform.domain.lesson;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "lessons")
public class Lesson {

    @Id
    @GeneratedValue
    private UUID id;

    private String title;
    private String description;
    private Boolean completed;

    @ManyToOne
    @JoinColumn(name = "module_id", nullable = false)
    private Module module;
}
