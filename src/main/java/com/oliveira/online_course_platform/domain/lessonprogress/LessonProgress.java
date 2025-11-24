package com.oliveira.online_course_platform.domain.lessonprogress;

import com.oliveira.online_course_platform.enums.StatusEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "lesson_progress")
public class LessonProgress {

    @Id
    private UUID userId;

    @Id
    private UUID lessonId;
    private StatusEnum status;
}
