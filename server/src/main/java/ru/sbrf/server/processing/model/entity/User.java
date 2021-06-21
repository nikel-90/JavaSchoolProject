package ru.sbrf.server.processing.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "USERS")
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue
    private long id;

    private String surname;
    private String name;
    private String phoneNumber;
    private int age;
    private String login;
    private String password;

    @OneToMany(mappedBy = "user_id")
    private Set<Account> accounts;
}
