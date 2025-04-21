package langio.daniel.lifetracker.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Object used for User creation with the API
 * */
@Data
@NoArgsConstructor
public class CreateUserRest {
    private String username;
}
