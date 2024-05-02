package africa.semicolon.toDoApplication.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document("to do list")
public class Task {
    @Id
    private String id;
    private String title;
    private String description;
    private Status status;
    private LocalDateTime dateCreated;
}
