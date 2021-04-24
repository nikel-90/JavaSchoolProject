package com.github.nikel90.bankapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.nikel90.bankapi.controller.Controller;
import com.github.nikel90.bankapi.mapper.Mapper;
import com.github.nikel90.bankapi.model.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JsonProcessingException, ParseException {
        String date = "{\n" +
                "  \"cardNumber\": 1111222233334444,\n" +
                "  \"expirationDate\": \"10/23 00:00:00\",\n" +
                "  \"pinCode\": 444\n" +
                "}";
        Mapper mapper = new Mapper();
        Controller controller = new Controller();
        controller.authorization(mapper.jsonToCard(date), CreateTestData());
    }

    private static Processing CreateTestData() throws ParseException {
        Balance balance1 = new Balance(new BigDecimal(212321), Currency.getInstance("RUB"));

        Card card1 = new Card();
        card1.setCardNumber(1111222233334444L);
        card1.setExpirationDate(new SimpleDateFormat("MM/yy HH:mm:ss").parse("10/23 03:00:00"));
        card1.setPinCode(444);

        List<Card> cards = new ArrayList<>();
        cards.add(card1);

        Account account1 = new Account();
        account1.setAccountNumber(1);
        account1.setBalance(balance1);
        account1.setCards(cards);

        List<Account> accounts = new ArrayList<>();
        accounts.add(account1);


        Client client1 = new Client(1L, "Bazhenov", "Nikita", 24, accounts);

        List<Client> clients = new ArrayList<>();
        clients.add(client1);

        return new Processing(clients);
    }
}
