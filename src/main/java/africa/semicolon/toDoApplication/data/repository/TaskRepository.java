package africa.semicolon.toDoApplication.data.repository;

import africa.semicolon.toDoApplication.data.models.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.swing.*;

public interface TaskRepository extends MongoRepository<Task, String> {

    Task findTaskByTitle(String title);

    Task findTaskByUsername(String username);

    Task findTaskById(String id);
}
