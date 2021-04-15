package com.github.nikel90.bankapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Card {
    private long cardNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/yy HH:mm:ss")
    private Date expirationDate;
    private int pinCode; // ??? хранить хэш
}
