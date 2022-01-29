package edu.hahu.user.controller;

import edu.hahu.user.dto.UserDto;
import edu.hahu.user.model.User;
import edu.hahu.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    private List<UserDto> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    private ResponseEntity<UserDto> getById(@PathVariable Long id) {
        Optional<UserDto> user = userService.findById(id);
        if (user.isEmpty()) return ResponseEntity.notFound().build();

        return ResponseEntity.of(user);
    }

    @PostMapping
    private ResponseEntity<UserDto> save(@Valid @RequestBody User user, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        Optional<UserDto> savedUser = userService.save(user);
        return ResponseEntity.of(savedUser);
    }

    @PutMapping("/{id}")
    private ResponseEntity<UserDto> update(@Valid @RequestBody User user, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        Optional<UserDto> updatedUser = userService.update(user);
        return ResponseEntity.of(updatedUser);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<UserDto> delete(@PathVariable Long id) {
        Optional<UserDto> deletedUser = userService.delete(id);
        if (deletedUser.isEmpty()) return ResponseEntity.notFound().build();

        return ResponseEntity.of(deletedUser);
    }

}
