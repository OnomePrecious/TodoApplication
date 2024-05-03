package africa.semicolon.toDoApplication.dto;

import africa.semicolon.toDoApplication.data.models.Priority;
import africa.semicolon.toDoApplication.data.models.Status;
import lombok.Data;

import java.time.LocalDateTime;
@Data

public class TaskResponse {
        private String username;
        private String title;
        private String description;
        private LocalDateTime dateCreated;
        private Status status;
        private Priority priority;
    }

