package com.github.nikel90.bankapi.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Account {
    private int accountNumber;
    private Balance balance;
    private List<Card> cards = new ArrayList<Card>(); //коллекция из привязанных к счету карт(класс Карта), которая может быть пустой (счет без привязанных карт)
}
