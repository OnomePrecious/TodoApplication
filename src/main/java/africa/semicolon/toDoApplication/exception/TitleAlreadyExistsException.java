package africa.semicolon.toDoApplication.exception;

public class TitleAlreadyExistsException extends ErrorAccessingToDoAppException{
    public TitleAlreadyExistsException(String message){
        super(message);
    }
}
