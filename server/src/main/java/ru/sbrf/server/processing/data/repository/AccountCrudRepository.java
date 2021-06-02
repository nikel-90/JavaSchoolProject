package ru.sbrf.server.processing.data.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sbrf.server.processing.data.entity.Account;

public interface AccountCrudRepository extends CrudRepository<Account, Long> {
}
