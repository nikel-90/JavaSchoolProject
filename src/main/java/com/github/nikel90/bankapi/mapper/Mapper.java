package com.github.nikel90.bankapi.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.nikel90.bankapi.model.Card;

public class Mapper {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public Card jsonToCard(String date) throws JsonProcessingException {
        return objectMapper.readValue(date, Card.class);
    }
}
