package ru.sbrf.server.processing.service;

import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import ru.sbrf.server.processing.exception.UserNotFoundException;
import ru.sbrf.server.processing.model.entity.User;
import ru.sbrf.server.processing.model.mapper.UserMapper;
import ru.sbrf.server.processing.model.repository.UserCrudRepository;
import ru.sbrf.server.processing.model.transfer.UserDTO;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserCrudRepository userCrudRepository;

    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    public UserDTO getUser(Long id) {
        User user = userCrudRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
        return userMapper.mapUserToUserDto(user);
    }

    public List<UserDTO> getAllUsers() {
        Iterable<User> userIterable = userCrudRepository.findAll();
        List<UserDTO> users = new ArrayList<>();

        userIterable.forEach(user -> users.add(userMapper.mapUserToUserDto(user)));
        return users;
    }
}
