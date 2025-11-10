package com.oliveira.online_course_platform.repository;

import com.oliveira.online_course_platform.domain.lesson.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface LessonRepository extends JpaRepository<Lesson, UUID> {

    @Query("SELECT e FROM Lesson e LEFT JOIN e.module a WHERE a.id = :moduleId")
    public List<Lesson> findLessonByModuleId(@Param("moduleId") UUID lessonId);

    @Query("UPDATE Lesson e SET e.title = :title, e.description = :description WHERE e.id = :lessonId")
    public int updateLesson(@Param("lessonId") UUID moduleId,
                                 @Param("title") String title,
                                 @Param("description") String description);
}
