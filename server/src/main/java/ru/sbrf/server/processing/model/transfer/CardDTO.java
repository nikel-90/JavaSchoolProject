package ru.sbrf.server.processing.model.transfer;

import lombok.Data;
import ru.sbrf.server.processing.model.entity.Account;

@Data
public class CardDTO {

    private final long cardId;

    private final int cardNumber;

    private final String expirationDate;

    private final int PIN;

    private final int CVV;

    private final Account account_id;
}
