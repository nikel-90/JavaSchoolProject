package ru.sbrf.server.processing.model.transfer;

import lombok.Data;

import java.util.Set;

@Data
public class UserDTO {

    private final long id;

    private final String surname;

    private final String name;

    private final String phoneNumber;

    private final int age;

    private final String login;

    private final String password;

    private final Set<AccountDTO> accounts;
}

