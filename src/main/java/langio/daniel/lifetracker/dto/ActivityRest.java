package langio.daniel.lifetracker.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class ActivityRest extends ActivityCreate {
    private String id;
}