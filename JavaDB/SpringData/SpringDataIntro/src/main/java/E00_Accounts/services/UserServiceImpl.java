package E00_Accounts.services;

import E00_Accounts.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import E00_Accounts.repositories.UserRepository;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void registerUser(User user) {
        Optional<User> found = this.userRepository.findUserByName(user.getName());

        if(found.isEmpty()) {
            this.userRepository.save(user);
        }
    }
}
