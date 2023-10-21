package com.resellerapp.service.impl;

import com.resellerapp.model.dto.UserLoginDTO;
import com.resellerapp.model.dto.UserRegistrationDTO;
import com.resellerapp.model.entity.User;
import com.resellerapp.repository.UserRepository;
import com.resellerapp.service.UserService;
import com.resellerapp.util.LoggedUser;
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
                    .setUsername(user.getUsername())
                    .setLogged(true);
            return true;
        }
        return false;
    }

    @Override
    public void logout() {
        loggedUser
                .setUsername(null)
                .setLogged(false);
    }

    private User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    private User map(UserRegistrationDTO userRegistrationDTO) {
        return new User()
                .setUsername(userRegistrationDTO.username())
                .setPassword(passwordEncoder.encode(userRegistrationDTO.password()))
                .setEmail(userRegistrationDTO.email());
    }
}
