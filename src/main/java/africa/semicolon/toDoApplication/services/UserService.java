package africa.semicolon.toDoApplication.services;

import africa.semicolon.toDoApplication.dto.*;
import africa.semicolon.toDoApplication.data.models.Task;

public interface UserService {

    RegisterResponse register (RegisterRequest registerRequest);

    LogInResponse logIn(LogInRequest loginRequest);
    LogInResponse logOut(LogInRequest logInRequest);
    TaskResponse createTask(TaskRequest taskRequest);

    TaskResponse incompleteTask(TaskRequest taskRequest);

    TaskResponse completedTask(TaskRequest taskRequest);

    Task findTaskByTitle(String title);

    TaskResponse updateTask(UpdateTaskRequest updateTaskRequest);

    TaskResponse deleteTask(TaskRequest taskRequest);
}
