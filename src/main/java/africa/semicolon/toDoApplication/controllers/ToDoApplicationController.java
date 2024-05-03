package africa.semicolon.toDoApplication.controllers;

import africa.semicolon.toDoApplication.data.models.Task;
import africa.semicolon.toDoApplication.dto.*;
import africa.semicolon.toDoApplication.exception.ErrorAccessingToDoAppException;
import africa.semicolon.toDoApplication.services.TaskService;
import africa.semicolon.toDoApplication.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/toDo")
public class ToDoApplicationController {
    @Autowired
    private UserService userService;
    @Autowired
    private TaskService taskService;


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        try {
            var result = userService.register(registerRequest);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
        } catch (ErrorAccessingToDoAppException e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_REQUEST);
        }

    }

    @PostMapping("/logIn")
    public ResponseEntity<?> logIn(@RequestBody LogInRequest request) {
        try {
            var result = userService.logIn(request);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
        } catch (ErrorAccessingToDoAppException e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }

    @PostMapping("/logOut")
    public ResponseEntity<?> logOut(@RequestBody LogInRequest request) {
        try {
            var result = userService.logOut(request);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
        } catch (ErrorAccessingToDoAppException e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }


    @PostMapping("/create-task")
    public ResponseEntity<?> createTask(@RequestBody TaskRequest taskRequest) {
        try {
            var result = taskService.createTask(taskRequest);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
        } catch (ErrorAccessingToDoAppException e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }

    @PostMapping("/incomplete-Task")
    public ResponseEntity<?> incompleteTask(@RequestBody TaskRequest taskRequest) {
        try {
            var result = taskService.incompleteTask(taskRequest);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
        } catch (ErrorAccessingToDoAppException e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }

    @PostMapping("/completed-Task")
    public ResponseEntity<?> completedTask(@RequestBody TaskRequest taskRequest) {
        try {
            var result = taskService.completedTask(taskRequest);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
        } catch (ErrorAccessingToDoAppException e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_REQUEST);
        }

    }

    @PutMapping("/task-update")
    public ResponseEntity<?> taskUpdate(@RequestBody UpdateTaskRequest updateTaskRequest) {
        try {
            var result = taskService.updateTask(updateTaskRequest);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
        } catch (ErrorAccessingToDoAppException e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete-task")
    public ResponseEntity<?> taskDelete(@RequestBody TaskRequest taskRequest) {
        try {
            var result = taskService.deleteTask(taskRequest);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
        } catch (ErrorAccessingToDoAppException e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }
    @GetMapping("/findAllTask")
    public ResponseEntity<?> findAllTask() {
        try {
            List<Task> findAllTask = taskService.findAllTask();
            return new ResponseEntity<>(new ApiResponse(true, findAllTask), CREATED);
        } catch (ErrorAccessingToDoAppException e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }
}
