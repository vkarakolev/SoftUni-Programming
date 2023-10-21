package com.dictionaryapp.service.impl;

import com.dictionaryapp.model.dto.UserLoginDTO;
import com.dictionaryapp.model.dto.UserRegistrationDTO;
import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.repo.UserRepository;
import com.dictionaryapp.service.UserService;
import com.dictionaryapp.util.LoggedUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final LoggedUser loggedUser;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.loggedUser = loggedUser;
    }

    @Override
    public boolean register(UserRegistrationDTO userRegistrationDTO) {
        if(userRegistrationDTO == null) {
            return false;
        }

        String username = userRegistrationDTO.username();
        if(getUserByUsername(username) != null){
            return false;
        };

        userRepository.save(map(userRegistrationDTO));
        return true;
    }

    @Override
    public boolean login(UserLoginDTO userLoginDTO) {
        User user = getUserByUsername(userLoginDTO.username());
        if(user != null && passwordEncoder.matches(userLoginDTO.password(), user.getPassword())) {
            loggedUser
                    .setIsLogged(true)
                    .setUsername(user.getUsername());
            return true;
        }
        return false;
    }

    @Override
    public void logout() {
        loggedUser
                .setUsername(null)
                .setIsLogged(false);
    }

    private User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    private User map(UserRegistrationDTO userRegistrationDTO) {
        return new User()
                .setUsername(userRegistrationDTO.username())
                .setEmail(userRegistrationDTO.email())
                .setPassword(passwordEncoder.encode(userRegistrationDTO.password()));
    }
}
