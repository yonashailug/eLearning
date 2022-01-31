package edu.hahu.enrollement.security;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Long id;
    private String username,
            password,
            role, email;
    private boolean isEnabled;
}