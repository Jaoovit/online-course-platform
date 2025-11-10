package com.oliveira.online_course_platform.repository;

import com.oliveira.online_course_platform.domain.module.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public interface ModuleRepository extends JpaRepository<Module, UUID> {

    @Query("SELECT e FROM Module e LEFT JOIN e.course a WHERE a.id = :courseId")
    public List<Module> findModuleByCourseId(@Param("courseId") UUID courseId);

    @Transactional
    @Modifying
    @Query("UPDATE Module e SET e.title = :title, e.description = :description WHERE e.id = :moduleId")
    public int updateModule(@Param("moduleId") UUID moduleId,
                               @Param("title") String title,
                               @Param("description") String description);
}
