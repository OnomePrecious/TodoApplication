package africa.semicolon.toDoApplication.services;

import africa.semicolon.toDoApplication.dto.TaskResponse;
import africa.semicolon.toDoApplication.dto.TaskRequest;
import africa.semicolon.toDoApplication.dto.UpdateTaskRequest;
import africa.semicolon.toDoApplication.models.Task;

import java.util.List;

public interface TaskServices {
    TaskResponse createTask(TaskRequest taskRequest);

    TaskResponse incompleteTask(TaskRequest taskRequest);

    TaskResponse completedTask(TaskRequest taskRequest);

    TaskResponse deleteTask(TaskRequest taskRequest);

    TaskResponse updateTask(UpdateTaskRequest updateTaskRequest);

    Task findTaskByTitle(String title);
    List<Task> findAllTask();

}
