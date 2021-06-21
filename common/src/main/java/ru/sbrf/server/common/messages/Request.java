package ru.sbrf.server.common.messages;

import lombok.Value;

@Value
public class Request {
    String cardNumber;
    String expirationDate;
    int PIN;
    int CVV;
    RequestTypes type;
}

