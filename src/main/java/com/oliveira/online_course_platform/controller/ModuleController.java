package com.oliveira.online_course_platform.controller;

import com.oliveira.online_course_platform.domain.module.Module;
import com.oliveira.online_course_platform.domain.module.RequestModuleDTO;
import com.oliveira.online_course_platform.domain.module.ResponseModuleDTO;
import com.oliveira.online_course_platform.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/modules")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    @PostMapping("/{courseId}")
    public ResponseEntity<ResponseModuleDTO> createModule(@RequestBody RequestModuleDTO data, @RequestParam UUID courseId) {
        Module module = moduleService.createModule(data, courseId);
        ResponseModuleDTO moduleDTO = new ResponseModuleDTO(
                module.getTitle(),
                module.getDescription(),
                List.of());
        return ResponseEntity.ok(moduleDTO);
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<List<ResponseModuleDTO>> getModulesByCourseId(@RequestParam UUID courseId) {
        List<Module> modules = moduleService.getModuleByCourseId(courseId);
        List<ResponseModuleDTO> modulesDTO = modules.stream()
                .map(module -> new ResponseModuleDTO(
                        module.getTitle(),
                        module.getDescription(),
                        module.getLessons()
                ))
                .toList();
        return ResponseEntity.ok(modulesDTO);
    }

    @GetMapping("/{moduleID}")
    public ResponseEntity<ResponseModuleDTO> getModuleById(@RequestParam UUID moduleId) {
        Module module = moduleService.getModuleById(moduleId);
        ResponseModuleDTO moduleDTO = new ResponseModuleDTO(
                module.getTitle(),
                module.getDescription(),
                module.getLessons()
        );
        return  ResponseEntity.ok(moduleDTO);
    }

    @DeleteMapping("/{moduleId}")
    public ResponseEntity deleteModule(@RequestParam UUID moduleId) {
        moduleService.deleteModule(moduleId);
        return ResponseEntity.ok().build();
    }
}
