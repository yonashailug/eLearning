package edu.hahu.auth;

import java.util.Objects;

public class AppUser {
    private Long id;
    private String username;
    private String password;
    private String role;

    public AppUser(Long id, String username, String password, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser user = (AppUser) o;
        return id.equals(user.id) && username.equals(user.username) && password.equals(user.password) && role.equals(user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, role);
    }
}
