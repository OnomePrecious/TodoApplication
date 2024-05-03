package africa.semicolon.toDoApplication.services;

import africa.semicolon.toDoApplication.data.models.User;
import africa.semicolon.toDoApplication.dto.*;
import africa.semicolon.toDoApplication.data.models.Task;

public interface UserService {

    RegisterResponse register (RegisterRequest registerRequest);
    LogInResponse logIn(LogInRequest loginRequest);
    LogInResponse logOut(LogInRequest logInRequest);

}
