package africa.semicolon.toDoApplication.utils;

import africa.semicolon.toDoApplication.data.models.User;
import africa.semicolon.toDoApplication.dto.*;
import africa.semicolon.toDoApplication.data.models.Task;

import java.time.LocalDateTime;

public class Mappers {
        public static TaskRequest mapCreateTaskRequest(TaskRequest taskRequest, Task task) {
        taskRequest.setTitle(task.getTitle());
        taskRequest.setDescription(task.getDescription());
        taskRequest.setDateCreated(task.getDateCreated());
        return taskRequest;
    }
public static TaskResponse mapTaskResponse(Task task){
        TaskResponse taskResponse = new TaskResponse();
        taskResponse.setTitle(task.getTitle());
        taskResponse.setDescription(task.getDescription());
        taskResponse.setDateCreated(LocalDateTime.now());
        return taskResponse;
}
public static void mapUpdateTaskRequest(UpdateTaskRequest updateTaskRequest, Task task){
                updateTaskRequest.setTitle(task.getTitle());
                updateTaskRequest.setDescription(task.getDescription());
                updateTaskRequest.setDateUpdated(task.getDateCreated());


}
public static void mapRegisteredResponse(RegisterRequest request, User user) {
            user.setUsername(request.getUsername());
            user.setEmail(request.getEmail());
            user.setPassword(request.getPassword());
    }
public static RegisterResponse mapUserToRegisterResponse(User user){
            RegisterResponse registerResponse = new RegisterResponse();
            registerResponse.setUsername(user.getUsername());
            registerResponse.setMessage("Registered successfully");
            return registerResponse;
}

public static LogInResponse mapLoginResponse(User user, LogInResponse logInResponse) {
            user.setUsername(logInResponse.getUsername());
            user.setTaskList(logInResponse.getTaskList());

    return logInResponse;
}
public static LogInResponse mapUserToLogInResponse(User user){
            LogInResponse logInResponse = new LogInResponse();
            logInResponse.setUsername(user.getUsername());
            logInResponse.setMessage("Logged in successfully");
            return logInResponse;
}
}
