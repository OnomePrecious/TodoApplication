package africa.semicolon.toDoApplication.exception;

public class TaskNotFoundException extends ErrorAccessingToDoAppException{
    public TaskNotFoundException(String message){
        super(message);
    }

}
