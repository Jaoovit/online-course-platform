package com.oliveira.online_course_platform.service;

import com.oliveira.online_course_platform.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private ValidationService validationService;

    @Autowired
    private ModuleService moduleService;
}
