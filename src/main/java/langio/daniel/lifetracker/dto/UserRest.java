package langio.daniel.lifetracker.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User representation for the API
 * */
@Data
@NoArgsConstructor
public class UserRest {
    private String id;
    private String username;
    private String creationDate;
}
