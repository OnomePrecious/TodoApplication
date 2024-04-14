package africa.semicolon.toDoApplication.exception;

public class UnableToSignInException extends ErrorAccessingToDoAppException{
    public UnableToSignInException(String message){
        super(message);
    }
}
