package ru.sbrf.server.processing.model.transfer;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
public class AccountDTO {

    private final Long id;

    private final String accountNumber;

    private final BigDecimal accountBalance;

    private final UserDTO userId;

    private final Set<CardDTO> cards;
}

