package com.oliveira.online_course_platform.controller;

import com.oliveira.online_course_platform.domain.lesson.Lesson;
import com.oliveira.online_course_platform.domain.lesson.RequestLessonDTO;
import com.oliveira.online_course_platform.domain.lesson.ResponseLessonDTO;
import com.oliveira.online_course_platform.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @PostMapping("{moduleId}")
    public ResponseEntity<ResponseLessonDTO> createLesson(@RequestBody RequestLessonDTO data, @RequestParam UUID moduleId) {
        Lesson lesson = lessonService.createLesson(data, moduleId);
        ResponseLessonDTO lessonDTO = new ResponseLessonDTO(lesson.getTitle(), lesson.getDescription());
        return ResponseEntity.ok(lessonDTO);
    }
}
