package africa.semicolon.toDoApplication.services;

import africa.semicolon.toDoApplication.data.repository.UserRepository;
import africa.semicolon.toDoApplication.dto.TaskResponse;
import africa.semicolon.toDoApplication.dto.TaskRequest;
import africa.semicolon.toDoApplication.dto.UpdateTaskRequest;
import africa.semicolon.toDoApplication.exception.*;
import africa.semicolon.toDoApplication.data.models.Status;
import africa.semicolon.toDoApplication.data.models.Task;
import africa.semicolon.toDoApplication.data.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static africa.semicolon.toDoApplication.utils.Mappers.*;

@Service
public class TaskServicesImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public TaskResponse createTask(TaskRequest taskRequest) {
        Task task = new Task();
        var user = userRepository.findUserByUsername(taskRequest.getUsername());
        if(user == null) throw new UserNotFoundException("user not found");
        if(!user.isLoggedIn()) throw new UserNotLoggedInException("user not logged in");
       mapTaskRequest(taskRequest,task);
        taskRepository.save(task);
        userRepository.save(user);
        return mapCreateTaskRequest(task);
    }
    @Override
    public TaskResponse incompleteTask(TaskRequest taskRequest){
        Task foundTask = taskRepository.findTaskByTitle(taskRequest.getTitle());
        foundTask.setStatus(Status.INCOMPLETE);
        return mapCreateTaskRequest(foundTask);
    }
    @Override
    public TaskResponse completedTask(TaskRequest taskRequest){
        Task foundTask = taskRepository.findTaskByTitle(taskRequest.getTitle());
        foundTask.setStatus(Status.COMPLETED);
        return mapCreateTaskRequest(foundTask);
    }


    @Override
    public TaskResponse deleteTask(TaskRequest taskRequest) {
        var task = taskRepository.findTaskByTitle(taskRequest.getTitle());
        if(task == null) throw new UnableToDeleteTaskException("no task available for deletion");
        taskRepository.deleteById(task.getId());
        taskRepository.delete(task);
        return mapCreateTaskRequest(task);
    }



    @Override
        public TaskResponse updateTask(UpdateTaskRequest updateTaskRequest) {
        var task = taskRepository.findTaskById(updateTaskRequest.getId());
         if(task == null) throw new TaskNotFoundException("Task not found");
        mapUpdateTaskRequest(updateTaskRequest, task);
         taskRepository.save(task);
        var user = userRepository.findUserByUsername(updateTaskRequest.getUsername());
        if(!user.isLoggedIn())throw new UserNotLoggedInException("user is not logged in");
        userRepository.save(user);
            return mapCreateTaskRequest(task);
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