package langio.daniel.lifetracker.repository;

import langio.daniel.lifetracker.mapper.ActivityCategoryMapper;
import langio.daniel.lifetracker.model.ActivityCategory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;


@Repository
public class ActivityCategoryRepo extends BaseDAO<ActivityCategory>{


    private final ActivityCategoryMapper activityCategoryMapper;

    public ActivityCategoryRepo(DataSource dataSource, ActivityCategoryMapper activityCategoryMapper) {
        super(dataSource);
        this.activityCategoryMapper = activityCategoryMapper;
    }

    public ActivityCategory get(String id) {
        String sql = "SELECT id, name, description, created_at FROM activity_category WHERE id = ?";
        AtomicReference<ActivityCategory> category = new AtomicReference<>(null);

        executeQuery(sql, List.of(id), result -> {
            if (result.next()) {
                category.set(activityCategoryMapper.toModel(result));
                return 1;
            }
            return 0;
        });

        return category.get();
    }

    public ActivityCategory add(ActivityCategory activityCategory) {
        String sql = "INSERT INTO activity_category (name, description, created_at) VALUES (?, ?, ?)";

        executeUpdate(sql,
                List.of(activityCategory.getName(), activityCategory.getDescription(), activityCategory.getCreatedAt()));

        return activityCategory;
    }

    public boolean exists(String name) {
        String sql = "SELECT id FROM activity_category WHERE name = ?";

        return executeQuery(sql, List.of(name), (res ->
            res.next() ? 1 : 0
        )) == 1;
    }

}
