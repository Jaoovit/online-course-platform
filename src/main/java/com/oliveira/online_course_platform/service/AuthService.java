package com.oliveira.online_course_platform.service;

import com.oliveira.online_course_platform.domain.user.RequestUserDTO;
import com.oliveira.online_course_platform.domain.user.User;
import com.oliveira.online_course_platform.exceptions.BadRequest;
import com.oliveira.online_course_platform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    public User registerUser(RequestUserDTO data) {

        if (data.firstName().length() > 75) throw new BadRequest("First name can't have more then 75 characters");
        if (data.lastName().length() > 75) throw new BadRequest("Last name can't have more then 75 characters");
        if (data.username().length() > 25) throw new BadRequest("Username can't have more then 25 characters");
        if (data.password().length() > 75) throw new BadRequest("Username can't have more then 75 characters");
        if (!data.password().equals(data.confirmPassword())) throw new BadRequest("Password and confirm password don't match");

        userService.findUserByUserName(data.username());
        userService.findUserByEmail(data.email());

        User user = new User();
        user.setFirstName(data.firstName());
        user.setLastName(data.lastName());
        user.setUsername(data.username());
        user.setEmail(data.email());
        user.setPassword(data.password());
        user.setRole(roleService.createUserRole());

        userRepository.save(user);
        return user;
    }
}
