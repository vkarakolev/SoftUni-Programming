package AutoMappingObjectsEx.exceptions;

public class UserAccessException extends RuntimeException {
    public UserAccessException() {
        super("This user is not administrator. Access denied!");
    }
}
