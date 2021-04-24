package com.github.nikel90.bankapi.model;

import com.github.nikel90.bankapi.model.Account;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Client {
    private long id;
    private String surname;
    private String name;
    private int age;
    private List<Account> accounts = new ArrayList<>(); // коллекция из классов Счет
}
