package com.oliveira.online_course_platform.service;

import com.oliveira.online_course_platform.domain.course.Course;
import com.oliveira.online_course_platform.domain.user.RequestUserDTO;
import com.oliveira.online_course_platform.domain.user.User;
import com.oliveira.online_course_platform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    public User registerUser(RequestUserDTO data) {

        User user = new User();

        user.setFirstName(data.firstName());
        user.setLastName(data.lastName());
        user.setUsername(data.username());
        user.setEmail(data.email());
        user.setPassword(data.password());
        user.setCourses(new ArrayList<Course>());
        user.setRole(roleService.createUserRole());

        return user;
    }
}
