package edu.hahu.user.dao;

import edu.hahu.user.model.Role;
import edu.hahu.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserDao extends JpaRepository<User, Long> {
    List<User> findUsersByRole(Role role);

    Optional<User> findUserByUsername(String username);

    User findByUsername(String username);
}
