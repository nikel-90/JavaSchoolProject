package ru.sbrf.server.processing.data.transfer;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Set;

@RequiredArgsConstructor
@Getter
public class UserDTO {

    private final long id;

    @NotBlank(message = "Необходимо указать фамилию")
    private final String surname;

    @NotBlank(message = "Необходимо указать имя")
    private final String name;

    @Pattern(regexp = "\\+7[0-9]{10}", message = "Телефонный номер должен начинаться с +7, затем - 10 цифр")
    private final String phoneNumber;

    @NotBlank(message = "Необходимо указать количество лет")
    private final int age;

    @NotBlank(message = "Необходимо указать логин")
    private final String login;

    @NotBlank(message = "Необходимо указать пароль")
    private final String password;

    private final Set<AccountDTO> accountsDTO;
}

