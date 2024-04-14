package africa.semicolon.toDoApplication.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("tasks")
public class User {
    @Id
    private String id;
    private String username;
    private String password;
    @DBRef
    private List<Task> taskList;

}
