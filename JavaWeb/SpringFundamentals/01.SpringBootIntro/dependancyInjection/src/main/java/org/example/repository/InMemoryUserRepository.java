package org.example.repository;

import org.example.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

public class InMemoryUserRepository implements UserRepository {
    @Override
    public List<User> findAll() {
        return List.of(
                new User("Ivan", "Ivanov", 20),
                new User("Georgi", "Georgiev", 28),
                new User("Pesho", "Petrov", 28)
        );
    }
}
