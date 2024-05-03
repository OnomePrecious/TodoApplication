package africa.semicolon.toDoApplication.utils;

import africa.semicolon.toDoApplication.data.models.User;
import africa.semicolon.toDoApplication.dto.*;
import africa.semicolon.toDoApplication.data.models.Task;

import java.time.LocalDateTime;

public class Mappers {
    public static TaskResponse mapCreateTaskRequest(Task task) {
        TaskResponse taskResponse = new TaskResponse();
        taskResponse.setUsername(task.getUsername());
        taskResponse.setTitle(task.getTitle());
        taskResponse.setStatus(task.getStatus());
        taskResponse.setPriority(task.getPriority());
        taskResponse.setDescription(task.getDescription());
        taskResponse.setDateCreated(LocalDateTime.now());
        return taskResponse;

    }

    public static void mapTaskRequest(TaskRequest taskRequest, Task task) {
        task.setUsername(taskRequest.getUsername());
        task.setTitle(taskRequest.getTitle());
        task.setDescription(taskRequest.getDescription());
        task.setPriority(taskRequest.getPriority());
        task.setStatus(taskRequest.getStatus());
        task.setDateCreated(LocalDateTime.now());
    }

    public static void mapUpdateTaskRequest(UpdateTaskRequest updateTaskRequest, Task task) {
        updateTaskRequest.setUsername(task.getUsername());
        updateTaskRequest.setId(task.getId());
        updateTaskRequest.setTitle(task.getTitle());
        updateTaskRequest.setDescription(task.getDescription());
        updateTaskRequest.setPriority(task.getPriority());
        updateTaskRequest.setStatus(task.getStatus());
        updateTaskRequest.setDateUpdated(task.getDateCreated());


    }

    public static void mapRegisteredResponse(RegisterRequest request, User user) {
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
    }

    public static RegisterResponse mapUserToRegisterResponse(User user) {
        RegisterResponse registerResponse = new RegisterResponse();
        registerResponse.setUsername(user.getUsername());
        registerResponse.setMessage("Registered successfully");
        return registerResponse;
    }

    public static LogInResponse mapLogInResponse(User user, LogInResponse logInResponse) {
        logInResponse.setUsername(user.getUsername());
        logInResponse.setMessage("Logged in successfully");
        logInResponse.setTaskList(user.getTaskList());

        return logInResponse;
    }


}