package ru.sbrf.server.processing.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import ru.sbrf.server.processing.model.entity.User;
import ru.sbrf.server.processing.model.mapper.UserMapper;
import ru.sbrf.server.processing.model.repository.UserCrudRepository;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Mock
    UserCrudRepository userCrudRepository;

    @InjectMocks
    UserService userService;

    private Long userId;

    @Before
    public void setUp() {
        userId = 1L;
    }

    @Test
    public void getUserById() {
        User user = new User();
        user.setId(userId);

        when(userCrudRepository.findById(userId)).thenReturn(java.util.Optional.of(user));
        assertEquals(userService.getUser(userId), userMapper.mapUserToUserDto(user));
    }
}
