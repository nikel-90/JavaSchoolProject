package ru.sbrf.server.processing.data.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sbrf.server.processing.data.entity.User;

public interface UserCrudRepository extends CrudRepository<User, Long> {
}
