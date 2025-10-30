package com.oliveira.online_course_platform.repository;

import com.oliveira.online_course_platform.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    public User findByUsername(String username);

    public User findByEmail(String email);
}
