package africa.semicolon.toDoApplication.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data

public class CreateTaskResponse {
        private String title;
        private String description;
        private LocalDateTime dateCreated;
    }

