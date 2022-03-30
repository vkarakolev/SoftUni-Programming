package AutoMappingObjectsEx.entities.users;

public class LoginDTO {
    //TODO: validate email
    private String email;
    private String password;

    /**
     * commandLine[0] is skipped because it contains the name ot the command
     */
    public LoginDTO(String[] commandLine) {
        this.email = commandLine[1];
        this.password = commandLine[2];
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
