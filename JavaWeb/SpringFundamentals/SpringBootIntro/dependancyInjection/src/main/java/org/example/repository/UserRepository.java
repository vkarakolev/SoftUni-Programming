package org.example.repository;

import org.example.model.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();
}
