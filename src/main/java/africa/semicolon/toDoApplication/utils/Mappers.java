package africa.semicolon.toDoApplication.utils;

import africa.semicolon.toDoApplication.dto.TaskResponse;
import africa.semicolon.toDoApplication.dto.TaskRequest;
import africa.semicolon.toDoApplication.dto.UpdateTaskRequest;
import africa.semicolon.toDoApplication.models.Task;

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


}
