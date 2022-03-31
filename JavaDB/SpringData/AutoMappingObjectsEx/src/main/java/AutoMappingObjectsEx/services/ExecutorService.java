package AutoMappingObjectsEx.services;

public interface ExecutorService {
    String REGISTER_USER_COMMAND = "RegisterUser";
    String LOGIN_USER_COMMAND = "LoginUser";
    String LOGOUT_USER_COMMAND = "LogoutUser";

    String ADD_GAME_COMMAND = "AddGame";
    String EDIT_GAME_COMMAND = "EditGame";
    String DELETE_GAME_COMMAND = "DeleteGame";

    String execute(String command);

    String REGISTER_USER_JSON = """
            RegisterUser|<email>|<password>|<confirmPassword>|<fullName> 
            {               
                "commandName": "RegisterUser",
                "email": "assd@asd.com",
                "password": "111123",
                "confirmPassword": 111123",
                "fullName": "Ivan Ivanov"
            }
            """;
}
