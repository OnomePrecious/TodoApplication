package africa.semicolon.toDoApplication.exception;

public class ErrorUpdatingTaskException extends ErrorAccessingToDoAppException{
    public ErrorUpdatingTaskException(String message){
        super(message);
    }
}
