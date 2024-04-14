package africa.semicolon.toDoApplication.utils;

import africa.semicolon.toDoApplication.dto.CreateTaskResponse;
import africa.semicolon.toDoApplication.dto.TaskRequest;
import africa.semicolon.toDoApplication.dto.UpdateTaskRequest;
import africa.semicolon.toDoApplication.models.Task;
import africa.semicolon.toDoApplication.models.User;
import africa.semicolon.toDoApplication.repository.TaskRepository;
import africa.semicolon.toDoApplication.repository.UserRepository;

public class Mappers {
        public static TaskRequest mapCreateTaskRequest(TaskRequest taskRequest, Task task) {
        taskRequest.setTitle(task.getTitle());
        taskRequest.setDescription(task.getDescription());
        taskRequest.setDateCreated(task.getDateCreated());
        return taskRequest;
    }
public static CreateTaskResponse mapTaskResponse(Task task){
        CreateTaskResponse createTaskResponse = new CreateTaskResponse();
        createTaskResponse.setTitle(task.getTitle());
        createTaskResponse.setDescription(task.getDescription());
        createTaskResponse.setDateCreated(task.getDateCreated());
        return createTaskResponse;
}
public static void mapUpdateTaskRequest(UpdateTaskRequest updateTaskRequest, Task task){
                updateTaskRequest.setTitle(task.getTitle());
                updateTaskRequest.setDescription(task.getDescription());
                updateTaskRequest.setDateUpdated(task.getDateCreated());


}

}
