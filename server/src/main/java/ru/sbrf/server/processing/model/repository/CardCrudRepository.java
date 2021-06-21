package ru.sbrf.server.processing.model.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sbrf.server.processing.model.entity.Card;

import java.util.Optional;

public interface CardCrudRepository extends CrudRepository<Card, Long> {
    Optional<Card> findByCardNumber(String cardNumber);
}
