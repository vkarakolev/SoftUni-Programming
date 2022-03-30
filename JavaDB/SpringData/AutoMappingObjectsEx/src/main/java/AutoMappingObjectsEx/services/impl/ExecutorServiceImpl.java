package AutoMappingObjectsEx.services.impl;

import AutoMappingObjectsEx.entities.games.Game;
import AutoMappingObjectsEx.entities.games.AddDTO;
import AutoMappingObjectsEx.entities.users.LoginDTO;
import AutoMappingObjectsEx.entities.users.RegisterDTO;
import AutoMappingObjectsEx.entities.users.User;
import AutoMappingObjectsEx.exceptions.UserAccessException;
import AutoMappingObjectsEx.services.ExecutorService;
import AutoMappingObjectsEx.services.GameService;
import AutoMappingObjectsEx.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExecutorServiceImpl implements ExecutorService {

    private final UserService userService;
    private final GameService gameService;

    @Autowired
    public ExecutorServiceImpl(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
    }

    @Override
    public String execute(String commandLine) {
        String[] commandData = commandLine.split("\\|");
        String commandName = commandData[0];

        return switch (commandName) {
            case REGISTER_USER_COMMAND -> registerUser(commandData);
            case LOGIN_USER_COMMAND -> loginUser(commandData);
            case LOGOUT_USER_COMMAND -> logoutUser();
            case ADD_GAME_COMMAND -> addGame(commandData);
            default -> "unknown command";
        };
    }

    private String addGame(String[] commandData) {
        User loggedUser = this.userService.getLoggedUser();

        if(!loggedUser.isAdmin()) {
            throw new UserAccessException();
        }

        AddDTO addDTO = new AddDTO(commandData);
        Game game = this.gameService.add(addDTO);

        return String.format("Added %s", game.getTitle());
    }

    private String logoutUser() {
        User loggedUser = this.userService.getLoggedUser();

        this.userService.logout();

        return String.format("User %s successfully logged out.", loggedUser.getFullName());
    }

    private String loginUser(String[] commandData) {
        LoginDTO loginData = new LoginDTO(commandData);
        Optional<User> user = this.userService.login(loginData);

        if (user.isPresent()) {
            return String.format("Successfully logged in %s", user.get().getFullName());
        }

        return "Wrong credentials";
    }

    private String registerUser(String[] commandData) {
        RegisterDTO registerData = new RegisterDTO(commandData);
        User user = this.userService.register(registerData);

        return String.format("%s was registered", user.getFullName());
    }
}
