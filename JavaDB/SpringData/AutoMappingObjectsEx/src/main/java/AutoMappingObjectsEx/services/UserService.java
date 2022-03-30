package AutoMappingObjectsEx.services;

import AutoMappingObjectsEx.entities.users.LoginDTO;
import AutoMappingObjectsEx.entities.users.RegisterDTO;
import AutoMappingObjectsEx.entities.users.User;

import java.util.Optional;

public interface UserService {
    User register(RegisterDTO registerData);

    Optional<User> login(LoginDTO loginData);

    User getLoggedUser();

    void logout();
}
