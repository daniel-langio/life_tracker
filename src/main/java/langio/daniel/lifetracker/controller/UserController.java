package langio.daniel.lifetracker.controller;

import langio.daniel.lifetracker.dto.CreateUserRest;
import langio.daniel.lifetracker.dto.UpdateUserRest;
import langio.daniel.lifetracker.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Http Rest controller for User endpoints
 * */
@AllArgsConstructor
@RestController
@RequestMapping("/api/accounts")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<?> getUsers(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer pageSize
    )
    {
        try {
            return ResponseEntity.ok(userService.getUsers(page, pageSize));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> createUsers(@RequestBody List<CreateUserRest> users) {
        try {
            return ResponseEntity.ok(userService.createUsers(users));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> updateUsers(@RequestBody List<UpdateUserRest> users) {
        try {
            return ResponseEntity.ok(userService.updateUsers(users));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUsers(@RequestBody List<String> users) {
        try {
            return ResponseEntity.ok(userService.deleteUsers(users));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}
