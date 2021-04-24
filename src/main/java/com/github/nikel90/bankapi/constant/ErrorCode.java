package com.github.nikel90.bankapi.constant;

public enum ErrorCode {
    SUCCESS("0", "Success"),
    INCORRECT_CARD_NUMBER("1", "Incorrect card number"),
    INCORRECT_PIN_CODE("2", "Incorrect pin code"),
    INCORRECT_EXPIRATION_DATE("3", "Incorrect expiration date"),
    INCORRECT_CLIENT_CARD("", "There is no customer with such a card"),
    INCORRECT_PIN_AND_DATE("", "Incorrect pin code relative to the expiration date");

    private final String code;
    private final String codeMessage;

    ErrorCode(String code, String codeMessage) {
        this.code = code;
        this.codeMessage = codeMessage;
    }

    public String getCode() {
        return code;
    }

    public String getCodeMessage() {
        return codeMessage;
    }
}
