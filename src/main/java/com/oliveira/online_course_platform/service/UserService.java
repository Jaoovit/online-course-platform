package com.oliveira.online_course_platform.service;

import com.oliveira.online_course_platform.domain.user.User;
import com.oliveira.online_course_platform.exceptions.RepeatedException;
import com.oliveira.online_course_platform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    protected void findUserByUserName() {
        User user = userRepository.findByUsername();

        if (user != null) {
            throw new RepeatedException("This username already exist");
        }
    }

    protected void findUserByEmail() {
        User user = userRepository.findByUsername();

        if (user != null) {
            throw new RepeatedException("This email already exist");
        }
    }
}
