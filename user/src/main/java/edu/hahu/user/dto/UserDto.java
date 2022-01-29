package edu.hahu.user.dto;

import edu.hahu.user.model.Role;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private Role role;
    private String avatar;
    private boolean emailVerified;
}
