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

    //@NotBlank
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String avatar;
    private boolean emailVerified = false;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
}
