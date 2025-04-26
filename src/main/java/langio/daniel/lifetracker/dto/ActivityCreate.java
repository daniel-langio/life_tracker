package langio.daniel.lifetracker.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ActivityCreate {
    private String title;
    private String description;
    private String startedAt;
    private String finishedAt;
    private String categoryId;
    private String accountId;
}