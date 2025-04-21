package langio.daniel.lifetracker.service;

import langio.daniel.lifetracker.dto.CreateUserRest;
import langio.daniel.lifetracker.dto.UpdateUserRest;
import langio.daniel.lifetracker.dto.UserRest;
import langio.daniel.lifetracker.mapper.UserMapper;
import langio.daniel.lifetracker.model.User;
import langio.daniel.lifetracker.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * User Actions handler for the API
 * */
@AllArgsConstructor
@Service
public class UserService {

    private final UserRepo userRepo;
    private final UserMapper userMapper;

    /**
     * Provides the DTO version of all user
     * <p>
     * Paginated if the parameters {@param page} and {@param pageSize} are given
     * @param page page number for pagination
     * @param pageSize size of the page
     * @return list of {@link UserRest}
     * */
    public List<UserRest> getUsers(Integer page, Integer pageSize) {
        List<User> users = userRepo.getAll(page, pageSize);

        return userMapper.toDTOs(users);
    }

    /**
     * Provides the DTO version of a specific user
     *
     * @param id the identifier of the user in the database
     * @return the DTO with the user infos
     * */
    public UserRest getUser(String id) {
        User user = userRepo.get(id);

        return userMapper.toDTO(user);
    }

    /**
     * Creates multiple user
     *
     * @param creates list of {@link UpdateUserRest} representing what to update
     * @return list of updated {@link UserRest}
     * */
    public List<UserRest> createUsers(List<CreateUserRest> creates) {
        List<User> createdUsers = new ArrayList<>();

        creates.forEach(create -> {
            User user = userMapper.toModel(create);
            userRepo.add(user);
            createdUsers.add(user);
        });

        return userMapper.toDTOs(createdUsers);
    }

    /**
     * Updates multiple user
     *
     * @param users list of {@link UpdateUserRest} representing what to update
     * @return list of updated {@link UserRest}
     * */
    public List<UserRest> updateUsers(List<UpdateUserRest> users) {
        List<User> updated = new ArrayList<>();

        users.forEach(user -> {
            updated.add(userRepo.updatePlus(
                    userMapper.toModel(user)
            ));
        });

        return userMapper.toDTOs(updated);
    }

    /**
     * Deletes multiple user
     *
     * @param ids list of user id to delete
     * @return list of deleted user in {@link UserRest} format
     * */
    public List<UserRest> deleteUsers(List<String> ids) {
        List<User> updated = userRepo.delete(ids);

        return userMapper.toDTOs(updated);
    }
}
