package langio.daniel.lifetracker.controller;

import langio.daniel.lifetracker.dto.HealthRest;
import langio.daniel.lifetracker.dto.HealthStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/health")
public class HealthController {

    @GetMapping
    public ResponseEntity<?> checkHealth() {
        return ResponseEntity.ok(new HealthRest(HealthStatus.UP));
    }
}
