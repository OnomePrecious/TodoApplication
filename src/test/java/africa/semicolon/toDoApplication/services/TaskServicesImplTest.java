package africa.semicolon.toDoApplication.services;

import africa.semicolon.toDoApplication.data.models.Priority;
import africa.semicolon.toDoApplication.data.models.Status;
import africa.semicolon.toDoApplication.data.repository.TaskRepository;
import africa.semicolon.toDoApplication.data.repository.UserRepository;
import africa.semicolon.toDoApplication.dto.LogInRequest;
import africa.semicolon.toDoApplication.dto.RegisterRequest;
import africa.semicolon.toDoApplication.dto.TaskRequest;
import africa.semicolon.toDoApplication.dto.UpdateTaskRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TaskServicesImplTest {
@Autowired
private UserRepository userRepository;
@Autowired
private UserService userService;
@Autowired
private TaskService taskService;
@Autowired
private TaskRepository taskRepository;
    @BeforeEach
    void setUp() {
        userRepository.deleteAll();
        taskRepository.deleteAll();

    }

    @Test
  public void that_iCanCreateATask() {
        RegisterRequest request = new RegisterRequest();
        LogInRequest logInRequest = new LogInRequest();
        TaskRequest taskRequest = new TaskRequest();

        request.setUsername("Precious");
        request.setPassword("Oghenebukowho");
        request.setEmail("precious@gmail.com");

        logInRequest.setUsername("Precious");
        logInRequest.setPassword("Oghenebukowho");

        taskRequest.setUsername("Precious");
        taskRequest.setTitle("Buy milk");
        taskRequest.setDescription("Buy 2 litres of milk");
        taskRequest.setDateCreated(LocalDateTime.now());
        taskRequest.setStatus(Status.COMPLETED);
        taskRequest.setPriority(Priority.HIGH);


        userService.register(request);
        userService.logIn(logInRequest);
        taskService.createTask(taskRequest);

        assertEquals(1, taskRepository.count());

    }
    @Test
    public void that_iCanCreateTwoTask() {
        RegisterRequest request = new RegisterRequest();
        LogInRequest logInRequest = new LogInRequest();
        TaskRequest taskRequest = new TaskRequest();
        TaskRequest taskRequest2 = new TaskRequest();

        request.setUsername("Precious");
        request.setPassword("Oghenebukowho");
        request.setEmail("precious@gmail.com");

        logInRequest.setUsername("Precious");
        logInRequest.setPassword("Oghenebukowho");

        taskRequest.setUsername("Precious");
        taskRequest.setTitle("Buy milk");
        taskRequest.setDescription("Buy 2 litres of milk");
        taskRequest.setDateCreated(LocalDateTime.now());
        taskRequest.setStatus(Status.COMPLETED);
        taskRequest.setPriority(Priority.HIGH);

        taskRequest2.setUsername("Precious");
        taskRequest2.setTitle("The love of the world");
        taskRequest2.setDescription("When the skies are blue");
        taskRequest2.setDateCreated(LocalDateTime.now());
        taskRequest2.setStatus(Status.INCOMPLETE);
        taskRequest2.setPriority(Priority.MEDIUM);


        userService.register(request);
        userService.logIn(logInRequest);
        taskService.createTask(taskRequest);
        taskService.createTask(taskRequest2);

        assertEquals(2, taskRepository.count());
    }

    @Test
    public void test_thatICanDeleteATask() {
        RegisterRequest request = new RegisterRequest();
        LogInRequest logInRequest = new LogInRequest();
        TaskRequest taskRequest = new TaskRequest();
        TaskRequest taskRequest2 = new TaskRequest();

        request.setUsername("Precious");
        request.setPassword("Oghenebukowho");
        request.setEmail("precious@gmail.com");

        logInRequest.setUsername("Precious");
        logInRequest.setPassword("Oghenebukowho");

        taskRequest.setUsername("Precious");
        taskRequest.setTitle("Buy milk");
        taskRequest.setDescription("Buy 2 litres of milk");
        taskRequest.setDateCreated(LocalDateTime.now());
        taskRequest.setStatus(Status.COMPLETED);
        taskRequest.setPriority(Priority.HIGH);

        taskRequest2.setUsername("Precious");
        taskRequest2.setTitle("The love of the world");
        taskRequest2.setDescription("When the skies are blue");
        taskRequest2.setDateCreated(LocalDateTime.now());
        taskRequest2.setStatus(Status.INCOMPLETE);
        taskRequest2.setPriority(Priority.MEDIUM);


        userService.register(request);
        userService.logIn(logInRequest);
        taskService.createTask(taskRequest);
        taskService.createTask(taskRequest2);
        taskService.deleteTask(taskRequest2);

        assertEquals(1, taskRepository.count());

    }

    @Test
  public void test_thatICanFindAllMyTask() {
        RegisterRequest request = new RegisterRequest();
        LogInRequest logInRequest = new LogInRequest();
        TaskRequest taskRequest = new TaskRequest();
        TaskRequest taskRequest2 = new TaskRequest();

        request.setUsername("Precious");
        request.setPassword("Oghenebukowho");
        request.setEmail("precious@gmail.com");

        logInRequest.setUsername("Precious");
        logInRequest.setPassword("Oghenebukowho");

        taskRequest.setUsername("Precious");
        taskRequest.setTitle("Buy milk");
        taskRequest.setDescription("Buy 2 litres of milk");
        taskRequest.setDateCreated(LocalDateTime.now());
        taskRequest.setStatus(Status.COMPLETED);
        taskRequest.setPriority(Priority.HIGH);

        taskRequest2.setUsername("Precious");
        taskRequest2.setTitle("The love of the world");
        taskRequest2.setDescription("When the skies are blue");
        taskRequest2.setDateCreated(LocalDateTime.now());
        taskRequest2.setStatus(Status.INCOMPLETE);
        taskRequest2.setPriority(Priority.MEDIUM);


        userService.register(request);
        userService.logIn(logInRequest);
        taskService.createTask(taskRequest);
        taskService.createTask(taskRequest2);
        taskService.findAllTask();

        assertEquals(2, taskRepository.count());
    }
}