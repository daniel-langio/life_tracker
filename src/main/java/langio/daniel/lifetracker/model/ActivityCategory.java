package langio.daniel.lifetracker.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Model representing an {@link Activity}'s category
 * */
@Data
public class ActivityCategory {
    private String id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
}
