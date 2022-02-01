package edu.hahu.user.dto;

import edu.hahu.user.model.Role;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class UserLoginDto implements Serializable {
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
    private Role role;
}
