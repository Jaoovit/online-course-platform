package com.oliveira.online_course_platform.service;

import com.oliveira.online_course_platform.domain.course.Course;
import com.oliveira.online_course_platform.domain.user.User;
import com.oliveira.online_course_platform.exceptions.BadRequest;
import com.oliveira.online_course_platform.exceptions.NotFound;
import com.oliveira.online_course_platform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private CourseService courseService;

    public User addCourseToUser(UUID userId, UUID courseId) {
        User user = getUserById(userId);
        Course course = courseService.getCourseById(courseId);

        List<Course> courses = user.getCourses();
        courses.add(course);

        user.setCourses(courses);
        return user;
    }

    private User getUserById(UUID userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NotFound("User not found"));
    }

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
