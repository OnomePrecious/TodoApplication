package africa.semicolon.toDoApplication.exception;

public class InvalidTitleException extends ErrorAccessingToDoAppException{
    public InvalidTitleException(String message){
        super(message);
    }
}
