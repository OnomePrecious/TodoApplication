package africa.semicolon.toDoApplication.services;

import africa.semicolon.toDoApplication.dto.TaskRequest;
import africa.semicolon.toDoApplication.dto.TaskResponse;
import africa.semicolon.toDoApplication.dto.UpdateTaskRequest;
import africa.semicolon.toDoApplication.models.Task;

public interface UserService {
    TaskResponse createTask(TaskRequest taskRequest);

    TaskResponse incompleteTask(TaskRequest taskRequest);

    TaskResponse completedTask(TaskRequest taskRequest);

    Task findTaskByTitle(String title);

    TaskResponse updateTask(UpdateTaskRequest updateTaskRequest);

    TaskResponse deleteTask(TaskRequest taskRequest);
}
