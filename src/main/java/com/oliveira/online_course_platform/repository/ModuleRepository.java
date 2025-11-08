package com.oliveira.online_course_platform.repository;

import com.oliveira.online_course_platform.domain.module.Module;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ModuleRepository extends JpaRepository<Module, UUID> {
}
