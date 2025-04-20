package langio.daniel.lifetracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Object for server states information
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HealthRest {
    private HealthStatus status;
}
