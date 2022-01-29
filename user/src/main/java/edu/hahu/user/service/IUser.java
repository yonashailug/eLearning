package edu.hahu.user.service;

import edu.hahu.user.dto.UserDto;
import edu.hahu.user.model.Role;
import edu.hahu.user.model.User;

import java.util.List;
import java.util.Optional;

public interface IUser {
    List<UserDto> getAll();
    Optional<UserDto> findById(Long id);
    Optional<UserDto> save(User user);
    Optional<UserDto> delete(Long id);
    Optional<UserDto> update(User user);
    List<UserDto> findUsersByRole(Role role);
    List<Object> getCoursesByUser(Long id);
}
