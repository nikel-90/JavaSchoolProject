package com.github.nikel90.bankapi.data.transfer;

import lombok.Data;

@Data
public class CardDto {
    private long id;
    private int cardNumber;
    private double cardBalance;
    private long accountId;
}
