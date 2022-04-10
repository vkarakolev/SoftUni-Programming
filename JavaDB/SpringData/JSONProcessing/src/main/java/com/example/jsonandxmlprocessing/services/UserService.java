package com.example.jsonandxmlprocessing.services;

import com.example.jsonandxmlprocessing.entities.users.UserWithSoldProductsDTO;

import java.util.List;

public interface UserService {
    List<UserWithSoldProductsDTO> getAllWithSoldProducts();
}
