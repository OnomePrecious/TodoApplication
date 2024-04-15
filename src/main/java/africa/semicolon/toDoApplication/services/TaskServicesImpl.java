package africa.semicolon.toDoApplication.services;

import africa.semicolon.toDoApplication.dto.TaskResponse;
import africa.semicolon.toDoApplication.dto.TaskRequest;
import africa.semicolon.toDoApplication.dto.UpdateTaskRequest;
import africa.semicolon.toDoApplication.exception.*;
import africa.semicolon.toDoApplication.models.Status;
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
    @Override
    public TaskResponse createTask(TaskRequest taskRequest) {
        Task task = new Task();
        titleExist(taskRequest.getTitle());
        mapCreateTaskRequest(taskRequest, task);
        taskRequest.setDateCreated(taskRequest.getDateCreated());
        task.setStatus(Status.STARTED);
        taskRepository.save(task);
        return mapTaskResponse(task);
    }
    @Override
    public TaskResponse incompleteTask(TaskRequest taskRequest){
        Task foundTask = taskRepository.findTaskByTitle(taskRequest.getTitle());
        foundTask.setStatus(Status.INCOMPLETE);
        return mapTaskResponse(foundTask);
    }
    @Override
    public TaskResponse completedTask(TaskRequest taskRequest){
        Task foundTask = taskRepository.findTaskByTitle(taskRequest.getTitle());
        foundTask.setStatus(Status.COMPLETED);
        return mapTaskResponse(foundTask);
    }
        private void titleExist(String title) {
        var task = taskRepository.findTaskByTitle(title);
        if (task.getTitle().equals(title))
            throw new TitleAlreadyExistsException("Title already exists");
    }
    @Override
    public TaskResponse deleteTask(TaskRequest taskRequest) {
        var task = taskRepository.findTaskByTitle(taskRequest.getTitle());
        if(task == null) throw new UnableToDeleteTaskException("no task available for deletion");
        taskRepository.deleteById(task.getId());
        taskRepository.delete(task);
        return mapTaskResponse(task);
    }

    @Override
        public TaskResponse updateTask(UpdateTaskRequest updateTaskRequest) {
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
        @Override
        public Task findTaskByTitle(String title) {
        var task = taskRepository.findTaskByTitle(title);
        if (task.getTitle().equals(title)) {
            return taskRepository.findTaskByTitle(title);
        } else {
            throw new InvalidTitleException("This title does not exist");
        }
    }

        @Override
        public List<Task> findAllTask() {
        return taskRepository.findAll();
    }


}