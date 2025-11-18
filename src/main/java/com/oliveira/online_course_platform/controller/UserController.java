package com.oliveira.online_course_platform.controller;

import com.oliveira.online_course_platform.domain.user.ResponseUserDTO;
import com.oliveira.online_course_platform.domain.user.User;
import com.oliveira.online_course_platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping("{userId}/{courseId}")
    public ResponseEntity<ResponseUserDTO> addCourseToUser(@RequestParam UUID userId, @RequestParam UUID courseId) {
        User user = userService.addCourseToUser(userId, courseId);
        ResponseUserDTO userDTO = new ResponseUserDTO(
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getUsername(),
                user.getCourses());
        return ResponseEntity.ok(userDTO);
    }

    @GetMapping("{userId}")
    public ResponseEntity<ResponseUserDTO> getUserById(@RequestParam UUID userId) {
        User user = userService.getUserById(userId);
        ResponseUserDTO userDTO = new ResponseUserDTO(
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getUsername(),
                user.getCourses());
        return ResponseEntity.ok(userDTO);
    }


    @DeleteMapping("{userId}/{courseId}")
    public ResponseEntity<ResponseUserDTO> removeCourseFromUser(@RequestParam UUID userId, @RequestParam UUID courseId) {
        User user = userService.removeCourseFromUser(userId, courseId);
        ResponseUserDTO userDTO = new ResponseUserDTO(
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getUsername(),
                user.getCourses());
        return ResponseEntity.ok(userDTO);
    }
}
