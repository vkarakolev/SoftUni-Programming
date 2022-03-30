package AutoMappingObjectsEx.exceptions;

public class UserNotLoggedException extends RuntimeException {
    public UserNotLoggedException() {
        super("Execute login command first!");
    }
}
