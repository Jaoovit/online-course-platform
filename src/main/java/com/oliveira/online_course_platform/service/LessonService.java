package com.oliveira.online_course_platform.service;

import com.oliveira.online_course_platform.domain.lesson.Lesson;
import com.oliveira.online_course_platform.domain.lesson.RequestLessonDTO;
import com.oliveira.online_course_platform.domain.module.Module;
import com.oliveira.online_course_platform.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private ValidationService validationService;

    @Autowired
    private ModuleService moduleService;

    public Lesson createLesson(RequestLessonDTO data, UUID moduleId) {

        validationService.validateInput(data);

        Module module = moduleService.getModuleById(moduleId);

        Lesson lesson = new Lesson();
        lesson.setTitle(data.title());
        lesson.setDescription(data.description());
        lesson.setModule(module);

        lessonRepository.save(lesson);
        return lesson;
    }
}
