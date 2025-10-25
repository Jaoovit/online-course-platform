package com.oliveira.online_course_platform.domain.module;

import com.oliveira.online_course_platform.domain.course.Course;
import com.oliveira.online_course_platform.domain.lesson.Lesson;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "modules")
public class Module {

    @Id
    @GeneratedValue
    private UUID id;

    private String title;
    private String description;
    private Boolean completed;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @OneToMany(mappedBy = "module", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Lesson> lessons = new ArrayList<>();
}
