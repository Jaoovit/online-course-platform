package com.oliveira.online_course_platform.controller;

import com.oliveira.online_course_platform.domain.user.RequestUserDTO;
import com.oliveira.online_course_platform.domain.user.ResponseUserDTO;
import com.oliveira.online_course_platform.domain.user.User;
import com.oliveira.online_course_platform.service.AuthService;
import com.oliveira.online_course_platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/register")
    ResponseEntity<ResponseUserDTO> registerUser(RequestUserDTO data) {
        User user = authService.registerUser(data);
        ResponseUserDTO userDTO = new ResponseUserDTO(
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getUsername());
        return ResponseEntity.ok(userDTO);
    }
}
