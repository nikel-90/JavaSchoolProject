package com.github.nikel90.bankapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Currency;

@Data
@AllArgsConstructor
public class Balance {
    private BigDecimal amount;
//    @Setter(AccessLevel.NONE)
    private Currency currency;
}
