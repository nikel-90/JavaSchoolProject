package com.github.nikel90.bankapi.data.model;

import lombok.Data;

@Data
public class User {
    private long id;
    private String surname;
    private String name;
    private int age;
    private String login;
    private String password;
}
