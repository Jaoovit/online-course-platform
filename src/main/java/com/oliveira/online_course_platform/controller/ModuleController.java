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
@RequestMapping("/api/module")
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
}
