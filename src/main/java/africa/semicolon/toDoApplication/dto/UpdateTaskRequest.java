package africa.semicolon.toDoApplication.dto;

import africa.semicolon.toDoApplication.data.models.Priority;
import africa.semicolon.toDoApplication.data.models.Status;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
@Data
public class UpdateTaskRequest {
    private String username;
    @Id
    private String id;
    private String title;
    private String description;
    private Status status;
    private Priority priority;
    private LocalDateTime dateUpdated;

}
