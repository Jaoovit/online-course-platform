package com.oliveira.online_course_platform.repository;

import com.oliveira.online_course_platform.domain.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CourseRepository extends JpaRepository<Course, UUID> {
}
