package africa.semicolon.toDoApplication.repository;

import africa.semicolon.toDoApplication.models.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, String> {

    Task findTaskByTitle(String title);
}
