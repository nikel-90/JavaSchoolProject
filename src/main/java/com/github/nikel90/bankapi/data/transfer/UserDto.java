package com.github.nikel90.bankapi.data.transfer;

import lombok.Data;

@Data
public class UserDto {
    private long id;
    private String surname;
    private String name;
    private int age;
    private String login;
}
