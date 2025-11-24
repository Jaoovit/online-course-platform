package com.oliveira.online_course_platform.repository;

import com.oliveira.online_course_platform.domain.lessonprogress.LessonProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface LessonProgressRepository extends JpaRepository<LessonProgress, UUID> {

    public LessonProgress findByUserIdAndLessonId(@Param("userId") UUID userId, @Param("lessonId") UUID lessonId);
}
