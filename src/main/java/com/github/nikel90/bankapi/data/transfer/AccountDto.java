package com.github.nikel90.bankapi.data.transfer;

import lombok.Data;

@Data
public class AccountDto {
    private long id;
    private int accountNumber;
    private long userId;
}
