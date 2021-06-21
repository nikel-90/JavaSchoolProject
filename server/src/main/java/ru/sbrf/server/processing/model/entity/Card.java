package ru.sbrf.server.processing.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "CARDS")
@NoArgsConstructor
@Getter
@Setter
public class Card {
    @Id
    @GeneratedValue
    private long id;

    private String cardNumber;
    private String expirationDate;
    private int PIN;
    private int CVV;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account_id;
}
