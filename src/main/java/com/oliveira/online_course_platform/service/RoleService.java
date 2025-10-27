package com.oliveira.online_course_platform.service;

import com.oliveira.online_course_platform.domain.role.Role;
import com.oliveira.online_course_platform.enums.RoleEnum;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RoleService {

    public Role createUserRole() {
        Role role = new Role();

        role.setCreatedAt(new Date());
        role.setName(RoleEnum.USER);

        return role;
    }

}
