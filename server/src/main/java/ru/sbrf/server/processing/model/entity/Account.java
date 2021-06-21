package ru.sbrf.server.processing.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "ACCOUNTS")
@NoArgsConstructor
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountNumber;
    private BigDecimal accountBalance;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user_id;

    @OneToMany(mappedBy = "account_id")
    private Set<Card> cards;
}
