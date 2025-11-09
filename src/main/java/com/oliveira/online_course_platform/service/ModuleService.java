package com.oliveira.online_course_platform.service;

import com.oliveira.online_course_platform.domain.course.Course;
import com.oliveira.online_course_platform.domain.module.Module;
import com.oliveira.online_course_platform.domain.module.RequestModuleDTO;
import com.oliveira.online_course_platform.exceptions.NotFound;
import com.oliveira.online_course_platform.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ModuleService {

    @Autowired
    private ModuleRepository moduleRepository;

    @Autowired
    private ValidationService validationService;

    @Autowired
    private CourseService courseService;

    public Module createModule(RequestModuleDTO data, UUID courseId) {

        validationService.validateInput(data);

        Course course = courseService.getCourseById(courseId);

        Module module = new Module();
        module.setTitle(data.title());
        module.setDescription(data.description());
        module.setCourse(course);

        moduleRepository.save(module);
        return module;
    }

    public List<Module> getModuleByCourseId(UUID courseId) {
        Course course = courseService.getCourseById(courseId);
        return moduleRepository.findModuleByCourseId(course.getId());
    }

    public Module getModuleById(UUID moduleId) {
        return moduleRepository.findById(moduleId)
                .orElseThrow(() -> new NotFound("Module not found"));
    }

    public Module updateModule(RequestModuleDTO data, UUID moduleId) {
        validationService.validateInput(data);

        Module module = getModuleById(moduleId);
        module.setTitle(data.title());
        module.setDescription(data.description());

        moduleRepository.updateModule(module.getId(), module.getTitle(), module.getDescription());
        return module;
    }

    public void deleteModule(UUID moduleId) {
        Module module = getModuleById(moduleId);
        moduleRepository.delete(module);
    }
}
