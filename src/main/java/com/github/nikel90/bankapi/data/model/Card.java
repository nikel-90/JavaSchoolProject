package com.github.nikel90.bankapi.data.model;

import lombok.Data;

@Data
public class Card {
    private long id;
    private int cardNumber;
    private double cardBalance;
    private long accountId;
    private int pinCode;
}
