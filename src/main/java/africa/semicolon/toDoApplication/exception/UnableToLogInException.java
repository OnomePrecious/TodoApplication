package africa.semicolon.toDoApplication.exception;

public class UnableToLogInException extends ErrorAccessingToDoAppException{
    public UnableToLogInException(String message){
        super(message);
    }
}
