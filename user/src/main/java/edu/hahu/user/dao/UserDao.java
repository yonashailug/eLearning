package edu.hahu.user.dao;

import edu.hahu.user.model.Role;
import edu.hahu.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User, Long> {
    List<User> findUsersByRole(Role role);
}
