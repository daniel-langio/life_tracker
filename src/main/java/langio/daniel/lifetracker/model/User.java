package langio.daniel.lifetracker.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Model representing the app's user
 * */
@Data
public class User {
    private String id;
    private String username;
    private LocalDateTime createdAt;
}
