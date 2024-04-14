package africa.semicolon.toDoApplication.services;

import africa.semicolon.toDoApplication.dto.TaskRequest;
import africa.semicolon.toDoApplication.dto.CreateTaskResponse;
import africa.semicolon.toDoApplication.dto.UpdateTaskRequest;
import africa.semicolon.toDoApplication.models.Task;
import africa.semicolon.toDoApplication.repository.TaskRepository;
import africa.semicolon.toDoApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TaskServices taskServices;

    @Override
    public CreateTaskResponse createTask(TaskRequest taskRequest) {
        return taskServices.createTask(taskRequest);
    }


    @Override
    public List<Task> viewAllTasks(String username) {

        return taskServices.findAllTask();
    }

    @Override
    public Task findTaskByTitle(String title) {
        return taskServices.findTaskByTitle(title);
    }

    @Override
    public CreateTaskResponse updateTask(UpdateTaskRequest updateTaskRequest) {
        return taskServices.updateTask(updateTaskRequest);
    }

    @Override
    public String deleteTask(String title) {
        return taskServices.deleteTask(title);

    }
}

