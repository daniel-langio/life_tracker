package langio.daniel.lifetracker.mapper;

import langio.daniel.lifetracker.model.ActivityCategory;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

@Service
public class ActivityCategoryMapper {

    public ActivityCategory toModel(ResultSet rs){
        try {
            ActivityCategory category = new ActivityCategory();

            category.setId(rs.getString("id"));
            category.setName(rs.getString("name"));
            category.setDescription(rs.getString("description"));
            category.setCreatedAt(
                    LocalDateTime.parse(rs.getString("created_at"))
            );

            return category;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
