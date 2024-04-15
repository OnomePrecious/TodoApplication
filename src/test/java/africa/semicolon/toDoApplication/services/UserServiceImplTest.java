package africa.semicolon.toDoApplication.services;

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
        TaskRequest taskRequest = new TaskRequest();
        taskRequest.setTitle(taskRequest.getTitle());
        taskRequest.setDescription(taskRequest.getDescription());
        taskRequest.setDateCreated(taskRequest.getDateCreated());
        userService.createTask(taskRequest);
        assertEquals(1, userRepository.count());
    }


    @Test
    public void viewAllTasks() {
    }

    @Test
    public void findTaskByTitle() {
    }

    @Test
    public void updateTask() {
    }

    @Test
   public void deleteTask() {
    }
}