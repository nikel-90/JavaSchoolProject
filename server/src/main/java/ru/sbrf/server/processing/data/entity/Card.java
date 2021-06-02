package ru.sbrf.server.processing.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Cards")
@NoArgsConstructor
@Getter
@Setter
public class Card {

    @Id
    @GeneratedValue
    private long id;

    private int cardNumber;
    private LocalDate expirationDate;
    private int PIN;
    private int CVV;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account_id;
}
