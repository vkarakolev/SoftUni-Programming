package org.example.service;

import org.example.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findYoungestUser();
}
