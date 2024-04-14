package africa.semicolon.toDoApplication.services;

import africa.semicolon.toDoApplication.dto.TaskRequest;
import africa.semicolon.toDoApplication.dto.CreateTaskResponse;
import africa.semicolon.toDoApplication.dto.UpdateTaskRequest;
import africa.semicolon.toDoApplication.models.Task;

import java.util.List;

public interface UserService {
    CreateTaskResponse createTask(TaskRequest taskRequest);

    List<Task> viewAllTasks(String username);

    Task findTaskByTitle(String title);

    CreateTaskResponse updateTask(UpdateTaskRequest updateTaskRequest);

    String deleteTask(String title);
}
