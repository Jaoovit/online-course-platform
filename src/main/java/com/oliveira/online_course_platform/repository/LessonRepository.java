package com.oliveira.online_course_platform.repository;

import com.oliveira.online_course_platform.domain.lesson.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LessonRepository extends JpaRepository<Lesson, UUID> {
}
