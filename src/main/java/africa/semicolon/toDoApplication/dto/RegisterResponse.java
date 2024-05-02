package africa.semicolon.toDoApplication.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class RegisterResponse {
    @Id
    private String id;
    private String username;
    private String message;
}
