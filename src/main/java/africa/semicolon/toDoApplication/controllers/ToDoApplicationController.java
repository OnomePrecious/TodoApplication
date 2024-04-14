package africa.semicolon.toDoApplication.controllers;

import africa.semicolon.toDoApplication.dto.TaskRequest;
import africa.semicolon.toDoApplication.dto.UpdateTaskRequest;
import africa.semicolon.toDoApplication.exception.ErrorAccessingToDoAppException;
import africa.semicolon.toDoApplication.services.TaskServices;
import africa.semicolon.toDoApplication.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
public class ToDoApplicationController {
    @Autowired
    private TaskServices taskServices;


    @PostMapping("/create-task")
    public ResponseEntity<?> createTask(@RequestBody TaskRequest taskRequest) {
        try {
            return new ResponseEntity<>(taskServices.createTask(taskRequest), CREATED);
        } catch (ErrorAccessingToDoAppException e) {
            return new ResponseEntity<>(e.getMessage(), BAD_REQUEST);
        }
    }

    @PostMapping("/task-update")
    public ResponseEntity<?> taskUpdate(@RequestBody UpdateTaskRequest updateTaskRequest) {
        try {
            return new ResponseEntity<>(taskServices.updateTask(updateTaskRequest), CREATED);
        } catch (ErrorAccessingToDoAppException e) {
            return new ResponseEntity<>(e.getMessage(), BAD_REQUEST);
        }
    }

    @GetMapping("/delete-task")
    public void taskDelete(@PathVariable String title) {
        try {
            taskServices.deleteTask(title);
        } catch (ErrorAccessingToDoAppException e) {
        }
    }
}

