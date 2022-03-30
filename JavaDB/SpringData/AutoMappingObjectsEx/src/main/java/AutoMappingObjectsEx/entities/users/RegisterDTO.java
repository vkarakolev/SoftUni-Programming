package AutoMappingObjectsEx.entities.users;

import AutoMappingObjectsEx.exceptions.ValidationException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validate the data for registering a user.
 *
 * Email must contain "@" and "."
 * Password must be...
 *
 */

public class RegisterDTO {
    private final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,}$";


    private String email;
    private String password;
    private String confirmPassword;
    private String fullName;

    /**
     * commandData[0] is skipped, because it contains the name of the command, which is not needed
     */
    public RegisterDTO(String[] commandData) {
        this.email = commandData[1];
        this.password = commandData[2];
        this.confirmPassword = commandData[3];
        this.fullName = commandData[4];
    
        this.validate();
    }

    private void validate() {
        int indexOfAt = email.indexOf("@");
        int indexOfDot = email.lastIndexOf(".");

        if(indexOfAt < 0 || indexOfDot < 0 || indexOfAt > indexOfDot) {
            throw new ValidationException("Email must contain @ and .");
        }

        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);

        if(password.length() < 6 || !matcher.matches()) {
            throw new ValidationException(
                    "Password should contain at least one capital , one small letter and one digit");
        }

        if(!password.equals(confirmPassword)) {
            throw new ValidationException("Password and confirm password must match");
        }
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getFullName() {
        return fullName;
    }
}
