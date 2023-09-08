package com.kuba.shooting.range.management.database.dao.springdata;

import com.kuba.shooting.range.management.model.User;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDAO extends ListCrudRepository<User, Long> {
    boolean existsByLogin(String login);

    Optional<User> findByLogin(String login);
}