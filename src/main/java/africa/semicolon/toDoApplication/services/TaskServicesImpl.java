package africa.semicolon.toDoApplication.services;

import africa.semicolon.toDoApplication.dto.CreateTaskResponse;
import africa.semicolon.toDoApplication.dto.TaskRequest;
import africa.semicolon.toDoApplication.dto.UpdateTaskRequest;
import africa.semicolon.toDoApplication.exception.*;
import africa.semicolon.toDoApplication.models.Task;
import africa.semicolon.toDoApplication.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static africa.semicolon.toDoApplication.utils.Mappers.*;

@Service
public class TaskServicesImpl implements TaskServices {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
private TaskServices taskServices;
    @Override
    public CreateTaskResponse createTask(TaskRequest taskRequest) {
        Task task = new Task();
        titleExist(taskRequest.getTitle());
        mapCreateTaskRequest(taskRequest, task);
        taskRequest.setDateCreated(taskRequest.getDateCreated());
        taskRepository.save(task);
        return mapTaskResponse(task);
    }

    private void titleExist(String title) {
        var task = taskServices.findTaskByTitle(title);
        if (task.getTitle().equals(title))
            throw new TitleAlreadyExistsException("Title already exists");
    }

    public String deleteTask(String title) {
        Task task = taskRepository.findTaskByTitle(title);
        if (task != null) {
            taskRepository.delete(task);
            return "Successfully deleted";
        } else {
            throw new UnableToDeleteTaskException("task not found");
        }
    }

    public CreateTaskResponse updateTask(UpdateTaskRequest updateTaskRequest) {
        var task = taskRepository.findTaskByTitle(updateTaskRequest.getTitle());
        if (task.getTitle().equals(updateTaskRequest.getTitle())) {
            mapUpdateTaskRequest(updateTaskRequest, task);
            task.setTitle(updateTaskRequest.getTitle());
            task.setDescription(updateTaskRequest.getDescription());
            task.setDateCreated(LocalDateTime.now());
            taskRepository.save(task);
            return mapTaskResponse(task);
        } else {
            throw new ErrorUpdatingTaskException("update task error");
        }
    }

    public Task findTaskByTitle(String title) {
        var task = taskRepository.findTaskByTitle(title);
        if (task.getTitle().equals(title)) {
            return taskServices.findTaskByTitle(title);
        } else {
            throw new InvalidTitleException("This title does not exist");
        }
    }

    @Override
    public List<Task> findAllTask() {
        return taskRepository.findAll();
    }


}