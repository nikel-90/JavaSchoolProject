package ru.sbrf.server.processing.data.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sbrf.server.processing.data.entity.Card;

public interface CardCrudRepository extends CrudRepository<Card, Long> {
}
