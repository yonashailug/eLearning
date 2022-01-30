package edu.hahu.user.service;

import edu.hahu.user.dao.UserDao;
import edu.hahu.user.dto.UserDto;
import edu.hahu.user.model.Role;
import edu.hahu.user.model.User;
import edu.hahu.user.util.GenericMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService implements IUser {
    private final GenericMapper mapper;
    private final UserDao userDao;
    private final RestTemplate restTemplate;
    private final Environment env;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<UserDto> getAll() {
        return mapper.mapList(userDao.findAll(), UserDto.class);
    }

    @Override
    public Optional<UserDto> findById(Long id) {
        Optional<User> user = userDao.findById(id);
        if (user.isEmpty()) return Optional.empty();
        return Optional.of((UserDto) mapper.mapObject(user.get(), UserDto.class));
    }

    @Override
    public Optional<UserDto> save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User saved = userDao.save(user);
        return Optional.of((UserDto) mapper.mapObject(saved, UserDto.class));
    }

    @Override
    public Optional<UserDto> delete(Long id) {
        Optional<User> user = userDao.findById(id);
        if (user.isEmpty()) return Optional.empty();
        userDao.deleteById(id);
        return Optional.of((UserDto) mapper.mapObject(user.get(), UserDto.class));
    }

    @Override
    public Optional<UserDto> update(User user) {
        if (!userDao.existsById(user.getId())) return Optional.empty();
        User saved = userDao.save(user);
        return Optional.of((UserDto) mapper.mapObject(saved, UserDto.class));
    }

    @Override
    public List<UserDto> findUsersByRole(Role role) {
        return mapper.mapList(userDao.findUsersByRole(role), UserDto.class);
    }

    @Override
    public List<Object> getCoursesByUser(Long id) {
        String path = env.getProperty("course.service.location") + "/users/" + id;
        ResponseEntity<List<Object>> response = restTemplate
                .exchange(path,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<>() {});
        return response.getBody();
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }

}
