package com.oliveira.online_course_platform.service;

import com.oliveira.online_course_platform.domain.lesson.Lesson;
import com.oliveira.online_course_platform.domain.lesson.RequestLessonDTO;
import com.oliveira.online_course_platform.domain.module.Module;
import com.oliveira.online_course_platform.exceptions.NotFound;
import com.oliveira.online_course_platform.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<Lesson> getLessonsByModuleId(UUID moduleId) {
        Module module = moduleService.getModuleById(moduleId);
        return lessonRepository.findLessonByModuleId(module.getId());
    }

    public Lesson getLessonById(UUID lessonId) {
        return lessonRepository.findById(lessonId)
                .orElseThrow(() -> new NotFound("Lesson not found"));
    }

    public Lesson updateLesson(RequestLessonDTO data, UUID lessonId) {
        validationService.validateInput(data);

        Lesson lesson = getLessonById(lessonId);
        lesson.setTitle(data.title());
        lesson.setDescription(data.description());

        lessonRepository.updateLesson(lesson.getId(), lesson.getTitle(), lesson.getDescription());
        return lesson;
    }

    public void deleteLesson(UUID lessonId) {
        Lesson lesson = getLessonById(lessonId);
        lessonRepository.delete(lesson);
    }
}
