package africa.semicolon.toDoApplication.services;

import africa.semicolon.toDoApplication.dto.CreateTaskResponse;
import africa.semicolon.toDoApplication.dto.TaskRequest;
import africa.semicolon.toDoApplication.dto.UpdateTaskRequest;
import africa.semicolon.toDoApplication.models.Task;

import java.util.List;

public interface TaskServices {
    CreateTaskResponse createTask(TaskRequest taskRequest);

    String deleteTask(String title);

    CreateTaskResponse updateTask(UpdateTaskRequest updateTaskRequest);

    Task findTaskByTitle(String title);
    List<Task> findAllTask();

}
