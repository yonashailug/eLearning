package edu.hahu.auth.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.hahu.auth.model.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
public class UserMoreDetails implements UserDetails {
    private static final long serialVersionUId = 1;
    private long id;
    private String username;
    @JsonIgnore
    private String password;
    private String email;
    private boolean isEnabled;
    private Collection<? extends GrantedAuthority> authorities;

    public UserMoreDetails(Long id, String username, String email, boolean isEnabled, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.isEnabled = isEnabled;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public static UserMoreDetails build(User user) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority( "ROLE_" + user.getRole()));
        return new UserMoreDetails(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.isEnabled(),
                user.getPassword(),
                authorities
        );
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

}
