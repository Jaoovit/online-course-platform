package com.oliveira.online_course_platform.service;

import com.oliveira.online_course_platform.domain.validation.RequestData;
import com.oliveira.online_course_platform.exceptions.BadRequest;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    protected void validateInput(RequestData data) {
        if (data.title().length() > 75) throw new BadRequest("Title can't have more then 75 characters");
        if (data.description().length() > 150) throw new BadRequest("Description can't have more then 150 characters");
    }
}
