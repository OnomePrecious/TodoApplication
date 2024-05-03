package africa.semicolon.toDoApplication.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class RegisterResponse {
    private String username;
    private String message;
}
