package edu.hahu.user.service;

import edu.hahu.user.dao.UserDao;
import edu.hahu.user.dto.UserDto;
import edu.hahu.user.model.User;
import edu.hahu.user.util.GenericMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService implements IUser {
    private final GenericMapper mapper;
    private final UserDao userDao;

    @Override
    public List<UserDto> getAll() {
        return mapper.mapList(userDao.findAll(), UserDto.class);
    }

    @Override
    public Optional<UserDto> findById(Long id) {
        Optional<User> user = userDao.findById(id);
        if (!user.isPresent()) return Optional.ofNullable(null);
        return Optional.of((UserDto) mapper.mapObject(user.get(), UserDto.class));
    }

    @Override
    public Optional<UserDto> save(User user) {
        User saved = userDao.save(user);
        return Optional.of((UserDto) mapper.mapObject(saved, UserDto.class));
    }

    @Override
    public Optional<UserDto> delete(Long id) {
        Optional<User> user = userDao.findById(id);
        if (!user.isPresent()) return Optional.ofNullable(null);
        userDao.deleteById(id);
        return Optional.of((UserDto) mapper.mapObject(user.get(), UserDto.class));
    }

    @Override
    public Optional<UserDto> update(User user) {
        if (!userDao.existsById(user.getId())) return Optional.ofNullable(null);
        User saved = userDao.save(user);
        return Optional.of((UserDto) mapper.mapObject(saved, UserDto.class));
    }

}
