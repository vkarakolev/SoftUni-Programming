package AutoMappingObjectsEx.services.impl;

import AutoMappingObjectsEx.entities.users.LoginDTO;
import AutoMappingObjectsEx.entities.users.RegisterDTO;
import AutoMappingObjectsEx.entities.users.User;
import AutoMappingObjectsEx.exceptions.UserAlreadyLoggedException;
import AutoMappingObjectsEx.exceptions.UserNotLoggedException;
import AutoMappingObjectsEx.repositories.UserRepository;
import AutoMappingObjectsEx.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private User currentUser;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.currentUser = null;
        this.userRepository = userRepository;
    }

    @Override
    public User register(RegisterDTO registerData) {
        ModelMapper mapper = new ModelMapper();
        User toRegister = mapper.map(registerData, User.class);

        long userCount = this.userRepository.count();

        if(userCount == 0) {
            toRegister.setAdmin(true);
        }

        return this.userRepository.save(toRegister);
    }

    @Override
    public Optional<User> login(LoginDTO loginData) {
        if (this.currentUser != null) {
            throw new UserAlreadyLoggedException();
        }

        Optional<User> user = this.userRepository.findByEmailAndPassword(
                loginData.getEmail(), loginData.getPassword());

        user.ifPresent(value -> this.currentUser = value);

        return user;
    }

    public User getLoggedUser() {
        if (this.currentUser == null) {
            throw new UserNotLoggedException();
        }

        return this.currentUser;
    }

    @Override
    public void logout() {
        if (this.currentUser == null) {
            throw new UserNotLoggedException();
        }

        this.currentUser = null;
    }
}
