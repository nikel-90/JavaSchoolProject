package ru.sbrf.server.common.messages;


import java.math.BigDecimal;
import java.util.Objects;

public class Response {
    String message;
    BigDecimal balance;

    public Response() {
    }

    public Response(String message, BigDecimal balance) {
        this.message = message;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Response{" +
                "message='" + message + '\'' +
                ", balance=" + balance +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Response response = (Response) o;
        return balance == response.balance &&
                Objects.equals(message, response.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, balance);
    }
}
