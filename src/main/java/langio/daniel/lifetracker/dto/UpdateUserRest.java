package langio.daniel.lifetracker.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateUserRest {
    private String id;
    private String username;
}
