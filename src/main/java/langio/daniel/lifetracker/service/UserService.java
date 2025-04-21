package langio.daniel.lifetracker.service;

import langio.daniel.lifetracker.dto.UserRest;
import langio.daniel.lifetracker.mapper.UserMapper;
import langio.daniel.lifetracker.model.User;
import langio.daniel.lifetracker.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
}
