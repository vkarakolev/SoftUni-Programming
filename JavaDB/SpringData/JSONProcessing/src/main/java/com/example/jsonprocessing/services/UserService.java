package com.example.jsonprocessing.services;

import com.example.jsonprocessing.entities.users.UserWithSoldProductsDTO;

import java.util.List;

public interface UserService {
    List<UserWithSoldProductsDTO> getAllWithSoldProducts();
}
