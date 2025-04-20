package langio.daniel.lifetracker.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Model representing a {@link User}'s activity
 * */
@Data
public class Activity {
    private String id;
    private String title;
    private String description;
    private LocalDateTime startedAt;
    private LocalDateTime finishedAt;
    private ActivityCategory category;
    private User user;
}
