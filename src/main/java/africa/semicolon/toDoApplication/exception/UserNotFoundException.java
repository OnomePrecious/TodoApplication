package africa.semicolon.toDoApplication.exception;

public class UserNotFoundException extends ErrorAccessingToDoAppException{
    public UserNotFoundException(String message){
        super(message);
    }
}
