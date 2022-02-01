package edu.hahu.user.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Email
    private String email;

    @NotBlank
    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;
    private String avatar;
    private boolean emailVerified = false;
    private boolean isEnabled = true;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
}
