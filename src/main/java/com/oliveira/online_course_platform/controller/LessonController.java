package com.oliveira.online_course_platform.controller;

import com.oliveira.online_course_platform.domain.lesson.Lesson;
import com.oliveira.online_course_platform.domain.lesson.RequestLessonDTO;
import com.oliveira.online_course_platform.domain.lesson.ResponseLessonDTO;
import com.oliveira.online_course_platform.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping("{moduleId}")
    public ResponseEntity<List<ResponseLessonDTO>> getLessonsByModuleId(@RequestParam UUID moduleId) {
        List<Lesson> lessons = lessonService.getLessonsByModuleId(moduleId);
        List<ResponseLessonDTO> lessonsDTO = lessons.stream()
                .map(lesson -> new ResponseLessonDTO(
                        lesson.getTitle(),
                        lesson.getDescription()
                )).toList();
        return ResponseEntity.ok(lessonsDTO);
    }

    @GetMapping("{lessonId}")
    public ResponseEntity<ResponseLessonDTO> getLessonById(@RequestParam UUID lessonId) {
        Lesson lesson = lessonService.getLessonById(lessonId);
        ResponseLessonDTO lessonDTO = new ResponseLessonDTO(
                lesson.getTitle(),
                lesson.getDescription()
        );
        return ResponseEntity.ok(lessonDTO);
    }

    @DeleteMapping("{lessonId}")
    public ResponseEntity deleteLesson(@RequestParam UUID lessonId) {
        lessonService.deleteLesson(lessonId);
        return ResponseEntity.ok().build();
    }
}
