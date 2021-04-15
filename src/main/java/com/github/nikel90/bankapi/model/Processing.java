package com.github.nikel90.bankapi.model;

import com.github.nikel90.bankapi.model.Client;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Processing {
    private List<Client> clients; //  Коллекция из класса Client
}
