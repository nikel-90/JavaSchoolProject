package ru.sbrf.server.processing.data.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.sbrf.server.processing.data.entity.User;
import ru.sbrf.server.processing.data.transfer.UserDTO;

@Mapper
public interface UserMapper {

    /**
     * Преобразование объекта БД к формату ответа
     *
     * @param user - входящий объект
     * @return - готовый объект
     */
    @BeanMapping(ignoreByDefault = true)
    @Mappings({
            @Mapping(target = "userId", source = "user.userId"),
            @Mapping(target = "surname", source = "user.surname"),
            @Mapping(target = "name", source = "user.name"),
            @Mapping(target = "phoneNumber", source = "user.phoneNumber"),
            @Mapping(target = "age", source = "user.age"),
            @Mapping(target = "login", source = "user.login"),
            @Mapping(target = "password", source = "user.password"),
            @Mapping(target = "accounts", source = "user.accounts"),
    })
    UserDTO mapUserToUserDto(User user);

    /**
     * Преобразование accountDTO к обекту БД
     *
     * @param userDTO - входящий объект
     * @return - готовый объект
     */
    @BeanMapping(ignoreByDefault = true)
    @Mappings({
            @Mapping(target = "userId", source = "user.userId"),
            @Mapping(target = "surname", source = "user.surname"),
            @Mapping(target = "name", source = "user.name"),
            @Mapping(target = "phoneNumber", source = "user.phoneNumber"),
            @Mapping(target = "age", source = "user.age"),
            @Mapping(target = "login", source = "user.login"),
            @Mapping(target = "password", source = "user.password"),
            @Mapping(target = "accounts", source = "user.accounts"),
    })
    User mapUserDtoToUser(UserDTO userDTO);
}

