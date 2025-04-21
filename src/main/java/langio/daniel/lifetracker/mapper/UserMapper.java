package langio.daniel.lifetracker.mapper;

import langio.daniel.lifetracker.dto.UpdateUserRest;
import langio.daniel.lifetracker.dto.UserRest;
import langio.daniel.lifetracker.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Converter for user's objects
 * */
@AllArgsConstructor
@Component
public class UserMapper implements ModelMapper<User>, DTOMapper<UserRest, User> {
    /**
     * {@inheritDoc}
     * <p>
     * result order: [id, username, createdAt]
     * */
    @Override
    public List<Object> toParams(User user) {
        return List.of(user.getId(), user.getUsername(), user.getCreatedAt());
    }

    @Override
    public User toModel(ResultSet rs) {
        try {
            User user = new User();

            user.setId(rs.getString("id"));
            user.setUsername(rs.getString("username"));
            user.setCreatedAt(LocalDateTime.parse(rs.getString("created_at")));

            return user;
        } catch (SQLException e) {
            throw new RuntimeException("Error on user mapping: " + e);
        }
    }

    @Override
    public List<UserRest> toDTOs(List<User> users) {
        return users.stream().map(this::toDTO).toList();
    }

    @Override
    public UserRest toDTO(User user) {
        UserRest dto = new UserRest();

        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setCreationDate(user.getCreatedAt()
                .format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
        );

        return dto;
    }

    @Override
    public List<User> toModels(List<UserRest> DTOs) {
        return DTOs.stream().map(this::toModel).toList();
    }

    @Override
    public User toModel(UserRest dto) {
        User user = new User();

        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setCreatedAt(LocalDateTime.parse(dto.getCreationDate()));

        return user;
    }

    /**
     * Creates an {@link User} from a {@link UpdateUserRest}
     * <p>
     * Note: the returned {@link User} of this method should ONLY be used in repository update, NOT for User creation.
     * @param update the {@link UpdateUserRest}
     * @return {@link User} containing the data of {@link UpdateUserRest}
     * */
    public User toModel(UpdateUserRest update) {
        User user = new User();

        user.setId(update.getId());
        user.setUsername(update.getUsername());

        return user;
    }

}
