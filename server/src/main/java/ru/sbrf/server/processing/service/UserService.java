package ru.sbrf.server.processing.service;

import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sbrf.server.processing.data.entity.User;
import ru.sbrf.server.processing.data.mapper.UserMapper;
import ru.sbrf.server.processing.data.repository.UserCrudRepository;
import ru.sbrf.server.processing.data.transfer.UserDTO;
import ru.sbrf.server.processing.exception.UserNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserCrudRepository userCrudRepository;
    //private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);


    public User getUser(Long id) {
        User user = userCrudRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
        //return userMapper.mapUserToUserDto(user);
        return user;
    }

    public List<User> getAllUsers() {
        Iterable<User> userIterable = userCrudRepository.findAll();
        List<User> users = new ArrayList<>();

        //userIterable.forEach(user -> users.add(userMapper.mapUserToUserDto(user)));
        userIterable.forEach(users::add);
        return users;
    }
}
