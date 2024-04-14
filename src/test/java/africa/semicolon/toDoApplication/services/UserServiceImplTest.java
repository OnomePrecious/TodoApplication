package africa.semicolon.toDoApplication.services;

import africa.semicolon.toDoApplication.dto.CreateTaskResponse;
import africa.semicolon.toDoApplication.dto.TaskRequest;
import africa.semicolon.toDoApplication.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    private UserService userService;
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        userRepository.deleteAll();
    }

    @Test
   public void testThatICanCreateTask() {
        SignInRequest signInRequest = new SignInRequest();
        signInRequest.setUsername("Username");
        signInRequest.setPassword("password");
        TaskRequest taskRequest = new TaskRequest();
        CreateTaskResponse createTaskResponse = new CreateTaskResponse();
        taskRequest.setTitle(taskRequest.getTitle());
        taskRequest.setDescription(taskRequest.getDescription());
        taskRequest.setDateCreated(taskRequest.getDateCreated());
        userService.createTask(taskRequest);
        assertEquals(1, userRepository.count());
    }

    @Test
    public void signIn() {
        SignInRequest signInRequest = new SignInRequest();
        SignInResponse signInResponse = new SignInResponse();
        //User user = new User();
        signInRequest.setUsername("Username");
        signInRequest.setPassword("password");
        assertEquals(signInResponse, userService.signIn(signInRequest));

    }

    @Test void viewAllTasks() {
    }

    @Test
    void findTaskByTitle() {
    }

    @Test
    void updateTask() {
    }

    @Test
    void deleteTask() {
    }
}