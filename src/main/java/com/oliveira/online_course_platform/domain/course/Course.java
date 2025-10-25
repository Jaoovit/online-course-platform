package com.oliveira.online_course_platform.domain.course;

import com.oliveira.online_course_platform.domain.model.Model;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Table(name = "courses")
@Entity
public class Course {

    @Id
    @GeneratedValue
    private UUID id;

    private String title;
    private String description;
    private Boolean completed;

    @ManyToOne
    @JoinColumn(name = "model_id", referencedColumnName = "id", nullable = false)
    private List<Model> models = new ArrayList<>();
}
