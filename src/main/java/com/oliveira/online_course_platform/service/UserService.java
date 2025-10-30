package com.oliveira.online_course_platform.service;

import com.oliveira.online_course_platform.domain.user.User;
import com.oliveira.online_course_platform.exceptions.BadRequest;
import com.oliveira.online_course_platform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    protected void findUserByUserName(String username) {
        User user = userRepository.findByUsername(username);

        if (user != null) {
            throw new BadRequest("This username already exist");
        }
    }

    protected void findUserByEmail(String email) {
        User user = userRepository.findByEmail(email);

        if (user != null) {
            throw new BadRequest("This email already exist");
        }
    }
}
