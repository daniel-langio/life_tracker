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

}
