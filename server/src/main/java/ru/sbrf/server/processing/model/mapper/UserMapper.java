package ru.sbrf.server.processing.model.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.sbrf.server.processing.model.entity.User;
import ru.sbrf.server.processing.model.transfer.UserDTO;

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
            @Mapping(target = "id", source = "user.id"),
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
            @Mapping(target = "id", source = "userDTO.id"),
            @Mapping(target = "surname", source = "userDTO.surname"),
            @Mapping(target = "name", source = "userDTO.name"),
            @Mapping(target = "phoneNumber", source = "userDTO.phoneNumber"),
            @Mapping(target = "age", source = "userDTO.age"),
            @Mapping(target = "login", source = "userDTO.login"),
            @Mapping(target = "password", source = "userDTO.password"),
            @Mapping(target = "accounts", source = "userDTO.accounts"),
    })
    User mapUserDtoToUser(UserDTO userDTO);
}

