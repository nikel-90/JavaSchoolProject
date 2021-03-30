package com.github.nikel90.bankapi.data.repository;

import com.github.nikel90.bankapi.data.model.Card;
import org.springframework.stereotype.Repository;


@Repository
public class CardRepository {

    public Card addBalance(Long id, double amount) {
        return new Card();
    }

    public Card getById(Long id) {
        return new Card();
    }
}