package ru.sbrf.server.processing.model.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sbrf.server.processing.model.entity.Account;

public interface AccountCrudRepository extends CrudRepository<Account, Long> {
}
