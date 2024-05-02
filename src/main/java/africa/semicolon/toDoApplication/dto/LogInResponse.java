package africa.semicolon.toDoApplication.dto;

import africa.semicolon.toDoApplication.data.models.Task;
import lombok.Data;

import java.util.List;

@Data
public class LogInResponse {
    private String username;
    private String message;
    private List<Task> taskList;

}
