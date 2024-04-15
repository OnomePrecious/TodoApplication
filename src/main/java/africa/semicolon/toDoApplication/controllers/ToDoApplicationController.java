package africa.semicolon.toDoApplication.controllers;

import africa.semicolon.toDoApplication.dto.ApiResponse;
import africa.semicolon.toDoApplication.dto.TaskRequest;
import africa.semicolon.toDoApplication.dto.UpdateTaskRequest;
import africa.semicolon.toDoApplication.exception.ErrorAccessingToDoAppException;
import africa.semicolon.toDoApplication.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/toDo")
public class ToDoApplicationController {
    @Autowired
    private UserService userService;


    @PostMapping("/create-task")
    public ResponseEntity<?> createTask(@RequestBody TaskRequest taskRequest) {
        try {
            var result = userService.createTask(taskRequest);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
        } catch (ErrorAccessingToDoAppException e) {
            return new ResponseEntity<>(new ApiResponse(false,e.getMessage()), BAD_REQUEST);
        }
    }
    @PostMapping("/incomplete-Task")
    public ResponseEntity<?> incompleteTask(@RequestBody TaskRequest taskRequest){
        try{
            var result = userService.incompleteTask(taskRequest);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
        } catch (ErrorAccessingToDoAppException e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }
    @PostMapping("/completed-Task")
    public ResponseEntity<?> completedTask(@RequestBody TaskRequest taskRequest) {
        try {
            var result = userService.completedTask(taskRequest);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
        } catch (ErrorAccessingToDoAppException e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_REQUEST);
        }

    }
        @PostMapping("/task-update")
    public ResponseEntity<?> taskUpdate(@RequestBody UpdateTaskRequest updateTaskRequest) {
        try {
            var result = userService.updateTask(updateTaskRequest);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
        } catch (ErrorAccessingToDoAppException e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete-task")
    public ResponseEntity<?> taskDelete(@RequestBody TaskRequest taskRequest) {
        try {
            var result = userService.deleteTask(taskRequest);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
        } catch (ErrorAccessingToDoAppException e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }
    @GetMapping("/find-task")
    public void findTask(@PathVariable String title){
        try {
            userService.findTaskByTitle(title);
        }catch (ErrorAccessingToDoAppException e){

    }
}
    }

