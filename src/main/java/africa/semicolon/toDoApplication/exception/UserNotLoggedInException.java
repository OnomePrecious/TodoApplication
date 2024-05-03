package africa.semicolon.toDoApplication.exception;

public class UserNotLoggedInException extends ErrorAccessingToDoAppException{
    public UserNotLoggedInException(String message){
        super(message);
    }
}
