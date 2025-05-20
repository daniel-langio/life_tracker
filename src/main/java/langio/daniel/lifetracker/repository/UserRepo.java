package langio.daniel.lifetracker.repository;

import langio.daniel.lifetracker.mapper.UserMapper;
import langio.daniel.lifetracker.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Bridge between {@link User} and the corresponding data in the database
 * */
@Repository
public class UserRepo extends BaseDAO<User> implements DataProvider<User, String> {
    private final UserMapper userMapper;

    /**
     * @param dataSource {@link java.sql.Connection} providers
     * @param userMapper {@link User} converters
     * */
    public UserRepo(DataSource dataSource, UserMapper userMapper) {
        super(dataSource);
        this.userMapper = userMapper;
    }

    /**
     * Provides the list of all users
     * <p>
     * Paginated if the parameters {@param page} and {@param pageSize} are given
     * @param page page number for pagination
     * @param pageSize size of the page
     * @return list of {@link User}
     * */
    public List<User> getAll(Integer page, Integer pageSize) {
        String sql = "SELECT id, username, created_at FROM account ";
        List<Object> params = new ArrayList<>();
        List<User> users = new ArrayList<>();

        if (page != null && pageSize != null) {
            sql += "LIMIT ? OFFSET ?";
            params.add(pageSize);
            params.add(pageSize * (page - 1));
        }

        executeQuery(sql, params, result -> {
            int retrieved = 0;
            while (result.next()) {
                users.add(userMapper.toModel(result));
                retrieved++;
            }
            return retrieved;
        });

        return users;
    }

    @Override
    public User get(String id) {
        String sql = "SELECT id, username, created_at FROM account WHERE id = ?";
        AtomicReference<User> user = new AtomicReference<>(new User());

        executeQuery(sql, List.of(id), result -> {
           if (result.next()) {
               user.set(userMapper.toModel(result));
               return 1;
           }
           return 0;
        });

        return user.get();
    }

    @Override
    public Integer add(User entity) {
        String sql = "INSERT INTO account (id, username, created_at) VALUES (?, ?, ?)";
        List<Object> params = userMapper.toParams(entity);

        return executeUpdate(sql, params);
    }

    public User updatePlus(User entity) {
        update(entity);
        return get(entity.getId());
    }

    @Override
    public Integer update(User entity) {
        String sql = "UPDATE account SET username = ? WHERE id = ?";
        List<Object> params = List.of(entity.getUsername(), entity.getId());

        return executeUpdate(sql, params);
    }

    @Override
    public Integer save(User entity) {
        return isExists(entity.getId()) ? update(entity) : add(entity);
    }

    @Override
    public Integer delete(String id) {
        String sql = "DELETE FROM account WHERE id = ?";

        return executeUpdate(sql, List.of(id));
    }

    public List<User> delete(List<String> ids) {
        List<User> deleted = new ArrayList<>();

        for (String id : ids) {
            User user = get(id);
            if (user.getId() != null) {
                deleted.add(user);
                delete(id);
            }
        }

        return deleted;
    }

    @Override
    public Boolean isExists(String id) {
        String sql = "SELECT username FROM account WHERE id = ?";

        return executeQuery(sql, List.of(id), result ->
             result.next() ? 1 : 0
        ) == 1;
    }
}
