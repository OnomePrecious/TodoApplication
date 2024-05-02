package africa.semicolon.toDoApplication.services;

import africa.semicolon.toDoApplication.data.models.User;
import africa.semicolon.toDoApplication.data.repository.UserRepository;
import africa.semicolon.toDoApplication.dto.*;
import africa.semicolon.toDoApplication.data.models.Task;
import africa.semicolon.toDoApplication.exception.UnableToLogInException;
import africa.semicolon.toDoApplication.exception.UnableToLogOutException;
import africa.semicolon.toDoApplication.exception.UsernameAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static africa.semicolon.toDoApplication.utils.Mappers.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TaskServices taskServices;
    @Autowired
    private UserRepository userRepository;

    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        User user = new User();
        mapRegisteredResponse(registerRequest, user);
        if(isAValidUser(user)) userRepository.save(user);
        else throw new UsernameAlreadyExistException("User already exists");
        return mapUserToRegisterResponse(user);
    }

    private boolean isAValidUser(User user) {
       return userRepository.findUserByUsername(user.getUsername()) == null;
    }

    @Override
    public LogInResponse logIn(LogInRequest loginRequest) {
        LogInResponse logInResponse = new LogInResponse();
        var user = userRepository.findUserByUsername(loginRequest.getUsername());
        if(user.getUsername().equalsIgnoreCase(loginRequest.getUsername())) user.setLoggedIn(true);
        else throw new UnableToLogInException("Invalid username or password");
        if(user.getPassword().equalsIgnoreCase(loginRequest.getPassword())) user.setLoggedIn(true);
        else throw new UnableToLogInException("Invalid username or password");
        userRepository.save(user);
        return mapLoginResponse(user, logInResponse);
    }

    @Override
    public LogInResponse logOut(LogInRequest logInRequest) {
        LogInResponse logInResponse = new LogInResponse();
        var user = userRepository.findUserByUsername(logInRequest.getUsername());
        if(user.getUsername().equals(logInRequest.getUsername())) user.setLoggedIn(false);
        else throw new UnableToLogOutException("Unable to log out");
        userRepository.save(user);
        return mapLoginResponse(user, logInResponse);
    }


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

