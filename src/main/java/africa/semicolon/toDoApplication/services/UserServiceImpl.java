package africa.semicolon.toDoApplication.services;

import africa.semicolon.toDoApplication.dto.TaskRequest;
import africa.semicolon.toDoApplication.dto.TaskResponse;
import africa.semicolon.toDoApplication.dto.UpdateTaskRequest;
import africa.semicolon.toDoApplication.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TaskServices taskServices;

    @Override
    public TaskResponse createTask(TaskRequest taskRequest) {

        return taskServices.createTask(taskRequest);
    }
@Override
public TaskResponse incompleteTask(TaskRequest taskRequest){
        return taskServices.incompleteTask(taskRequest);
}
@Override
public TaskResponse completedTask(TaskRequest taskRequest){
        return taskServices.completedTask(taskRequest);
}
    @Override
    public Task findTaskByTitle(String title) {

        return taskServices.findTaskByTitle(title);
    }

    @Override
    public TaskResponse updateTask(UpdateTaskRequest updateTaskRequest) {
        return taskServices.updateTask(updateTaskRequest);
    }
    @Override
    public TaskResponse deleteTask(TaskRequest taskRequest){
        return taskServices.deleteTask(taskRequest);
    }

}

