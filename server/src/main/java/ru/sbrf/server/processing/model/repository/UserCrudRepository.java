package ru.sbrf.server.processing.model.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sbrf.server.processing.model.entity.User;

public interface UserCrudRepository extends CrudRepository<User, Long> {
}
