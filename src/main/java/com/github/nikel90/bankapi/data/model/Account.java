package com.github.nikel90.bankapi.data.model;

import lombok.Data;

@Data
public class Account {
    private long id;
    private int accountNumber;
    private long userId;
}
