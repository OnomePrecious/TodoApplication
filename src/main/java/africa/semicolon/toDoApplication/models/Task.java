package africa.semicolon.toDoApplication.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document("to do list")
public class Task {
    @Id
    private String id;
    private String title;
    private String description;
    private LocalDateTime dateCreated;
}