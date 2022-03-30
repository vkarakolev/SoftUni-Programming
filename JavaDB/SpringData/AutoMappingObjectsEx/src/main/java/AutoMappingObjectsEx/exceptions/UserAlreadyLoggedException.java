package AutoMappingObjectsEx.exceptions;

public class UserAlreadyLoggedException extends RuntimeException {
    public UserAlreadyLoggedException() {
        super("User is already logged.");
    }
}
