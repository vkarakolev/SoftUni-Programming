package com.dictionaryapp.service;

import com.dictionaryapp.model.dto.UserLoginDTO;
import com.dictionaryapp.model.dto.UserRegistrationDTO;

public interface UserService {
    boolean register(UserRegistrationDTO userRegistrationDTO);

    boolean login(UserLoginDTO userLoginDTO);

    void logout();
}
