package com.oliveira.online_course_platform.domain.user;

import com.oliveira.online_course_platform.domain.role.Role;
import jakarta.persistence.*;


import java.util.UUID;

@Table(name = "users")
@Entity
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;

    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    private Role role;


}
