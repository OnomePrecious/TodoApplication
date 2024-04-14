package africa.semicolon.toDoApplication.exception;

public class UnableToDeleteTaskException extends ErrorAccessingToDoAppException{
    public UnableToDeleteTaskException(String message){
        super(message);
    }
}
