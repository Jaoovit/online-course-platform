package com.oliveira.online_course_platform.service;

import com.oliveira.online_course_platform.domain.course.Course;
import com.oliveira.online_course_platform.domain.user.RequestUserDTO;
import com.oliveira.online_course_platform.domain.user.User;
import com.oliveira.online_course_platform.exceptions.BadRequest;
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

        if (data.username().length() > 25) {
            throw new BadRequest("Username can't have more then 25 characters");
        }
        userService.findUserByUserName(data.username());
        user.setUsername(data.username());

        userService.findUserByEmail(data.email());
        user.setEmail(data.email());

        if (!data.password().equals(data.confirmPassword())) {
            throw new BadRequest("Password and confirm password don't match");
        }
        user.setPassword(data.password());

        user.setCourses(new ArrayList<Course>());
        user.setRole(roleService.createUserRole());

        userRepository.save(user);
        return user;
    }
}
