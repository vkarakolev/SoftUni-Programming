package E00_Accounts;

import E00_Accounts.models.User;
import E00_Accounts.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleRunner implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        User first = new User("Pesho", 22);
        userService.registerUser(first);

        User second = new User("Pesho", 22);
        userService.registerUser(second);
    }
}
