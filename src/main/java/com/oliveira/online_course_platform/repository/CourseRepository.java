package com.oliveira.online_course_platform.repository;

import com.oliveira.online_course_platform.domain.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Modifying;

import java.util.UUID;

public interface CourseRepository extends JpaRepository<Course, UUID> {

    @Transactional
    @Modifying
    @Query("UPDATE Course e SET e.title = :title, e.description = :description WHERE e.id = :id")
    public int updateCourse(@Param("courseId") UUID courseId,
                            @Param("title") String title,
                            @Param("description") String description);
}
