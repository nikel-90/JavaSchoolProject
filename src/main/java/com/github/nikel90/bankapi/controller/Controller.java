package com.github.nikel90.bankapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.nikel90.bankapi.constant.ErrorCode;
import com.github.nikel90.bankapi.model.*;

import java.util.Date;
import java.util.List;

public class Controller {
    public void authorization(Card card, Processing processing) throws JsonProcessingException {
        List<Client> clients = processing.getClients();

        if (getCountsOfDigits(card.getCardNumber()) != 16) {
            System.out.println(ErrorCode.INCORRECT_CARD_NUMBER.getCode() + " " + ErrorCode.INCORRECT_CARD_NUMBER.getCodeMessage());
        }
        if (getCountsOfDigits(card.getPinCode()) != 3) {
            System.out.println(ErrorCode.INCORRECT_PIN_CODE.getCode() + " " + ErrorCode.INCORRECT_PIN_CODE.getCodeMessage());
        }
        if (card.getExpirationDate().before(new Date())) {
            System.out.println(ErrorCode.INCORRECT_EXPIRATION_DATE.getCode() + " " + ErrorCode.INCORRECT_EXPIRATION_DATE.getCodeMessage());
        }

        for (Client client : clients) {
            List<Account> accounts = client.getAccounts();
            for (Account account : accounts) {
                List<Card> cards = account.getCards();
                for (Card card1 : cards) {
                    System.out.println(card1.getCardNumber());
                    System.out.println(card1.getExpirationDate());
                    System.out.println(card1.getPinCode());
                    System.out.println();
                    System.out.println(card.getCardNumber());
                    System.out.println(card.getExpirationDate());
                    System.out.println(card.getPinCode());
                    if (card1.equals(card)) {
                        System.out.println("Номер аккаунат: " + account.getAccountNumber() + ", баланс карты: " + account.getBalance().getAmount() + ", валютный счет: " + account.getBalance().getCurrency());
                    }
                }
            }
        }
    }

    private int getCountsOfDigits(long number) {
        return String.valueOf(Math.abs(number)).length();
    }
}
