package africa.semicolon.toDoApplication.exception;

public class UsernameAlreadyExistException extends ErrorAccessingToDoAppException{
    public UsernameAlreadyExistException(String message){
        super(message);

    }
}
