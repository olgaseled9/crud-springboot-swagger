package by.seledtsovaos.swagger.exeption;

/**
 * Thrown if it is not possible to find user by id.
 */
public class UserNotFoundException extends RuntimeException {

    /**
     * Constructs a new exception with the specified detail message.
     * @param id entity id
     */
    public UserNotFoundException(Long id) {
        super(String.format("No user with id = %d found", id));
    }
}
