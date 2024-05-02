package africa.semicolon.toDoApplication.exception;

public class UnableToLogOutException extends ErrorAccessingToDoAppException{
    public UnableToLogOutException(String message){
        super(message);
    }
}
